package br.com.lidipimenta.financial_service.controller;

import br.com.lidipimenta.financial_service.exception.FeeNotApplicableException;
import br.com.lidipimenta.financial_service.model.Transfer;
import br.com.lidipimenta.financial_service.service.TransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransferControllerTest {

    private TransferService service;
    private TransferController controller;

    @BeforeEach
    void setUp() {
        service = mock(TransferService.class);
        controller = new TransferController(service);
    }

    @Test
    void createTransfer_shouldReturnOk() {
        Transfer transfer = new Transfer();
        transfer.setAmount(BigDecimal.valueOf(100));
        transfer.setTransferDate(LocalDate.now());

        Transfer saved = new Transfer();
        saved.setAmount(BigDecimal.valueOf(100));
        saved.setTransferDate(LocalDate.now());
        saved.setFee(BigDecimal.valueOf(5.5));

        when(service.createTransfer(transfer)).thenReturn(saved);

        ResponseEntity<?> response = controller.createTransfer(transfer);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(saved, response.getBody());
    }

    @Test
    void createTransfer_shouldReturnBadRequestOnFeeException() {
        Transfer transfer = new Transfer();
        transfer.setAmount(BigDecimal.valueOf(50));
        transfer.setTransferDate(LocalDate.now().plusDays(60));

        when(service.createTransfer(transfer))
                .thenThrow(new FeeNotApplicableException("Fee not applicable for the selected date"));

        ResponseEntity<?> response = controller.createTransfer(transfer);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Fee not applicable for the selected date", response.getBody());
    }
}