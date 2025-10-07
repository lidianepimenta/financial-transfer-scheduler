package br.com.lidipimenta.financial_service.service;

import br.com.lidipimenta.financial_service.exception.FeeNotApplicableException;
import br.com.lidipimenta.financial_service.model.Transfer;
import br.com.lidipimenta.financial_service.repository.TransferRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransferServiceTest {

    private TransferRepository repository;
    private TransferService service;

    @BeforeEach
    void setUp() {
        repository = mock(TransferRepository.class);
        service = new TransferService(repository);
    }

    @Test
    void createTransfer_shouldCalculateFeeForToday() {
        Transfer transfer = new Transfer();
        transfer.setAmount(BigDecimal.valueOf(100));
        transfer.setTransferDate(LocalDate.now()); // today

        when(repository.save(any(Transfer.class))).thenAnswer(i -> i.getArguments()[0]);

        Transfer saved = service.createTransfer(transfer);

        BigDecimal expectedFee = BigDecimal.valueOf(100).multiply(BigDecimal.valueOf(0.025)).add(BigDecimal.valueOf(3));
        assertEquals(0, saved.getFee().compareTo(expectedFee), "Fee should be 5.5 for today");
        assertEquals(LocalDate.now(), saved.getSchedulingDate());
        verify(repository, times(1)).save(saved);
    }

    @Test
    void createTransfer_shouldCalculateFeeFor1to10Days() {
        Transfer transfer = new Transfer();
        transfer.setAmount(BigDecimal.valueOf(200));
        transfer.setTransferDate(LocalDate.now().plusDays(5));

        when(repository.save(any(Transfer.class))).thenAnswer(i -> i.getArguments()[0]);

        Transfer saved = service.createTransfer(transfer);

        assertEquals(0, saved.getFee().compareTo(BigDecimal.valueOf(12)), "Fee should be 12 for 1-10 days transfer");
    }

    @Test
    void createTransfer_shouldThrowExceptionForInvalidDays() {
        Transfer transfer = new Transfer();
        transfer.setAmount(BigDecimal.valueOf(50));
        transfer.setTransferDate(LocalDate.now().plusDays(60)); // outside 0-50

        FeeNotApplicableException exception = assertThrows(FeeNotApplicableException.class,
                () -> service.createTransfer(transfer));

        assertEquals("Fee not applicable for the selected date", exception.getMessage());
        verify(repository, never()).save(any());
    }
}
