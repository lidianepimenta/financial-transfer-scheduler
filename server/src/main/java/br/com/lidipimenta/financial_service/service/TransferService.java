package br.com.lidipimenta.financial_service.service;

import br.com.lidipimenta.financial_service.exception.FeeNotApplicableException;
import br.com.lidipimenta.financial_service.model.Transfer;
import br.com.lidipimenta.financial_service.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransferService {

    private final TransferRepository repository;

    public TransferService(TransferRepository repository) {
        this.repository = repository;
    }

    public Transfer createTransfer(Transfer transfer) {
        BigDecimal fee = calculateFee(transfer); // calcula taxa
        transfer.setFee(fee);
        transfer.setSchedulingDate(LocalDate.now());
        return repository.save(transfer);
    }

    public List<Transfer> getAllTransfers() {
        return repository.findAll();
    }

    private BigDecimal calculateFee(Transfer transfer) {
        long days = ChronoUnit.DAYS.between(LocalDate.now(), transfer.getTransferDate());
        if (days == 0) return transfer.getAmount().multiply(BigDecimal.valueOf(0.025)).add(BigDecimal.valueOf(3));
        else if (days >= 1 && days <= 10) return BigDecimal.valueOf(12);
        else if (days >= 11 && days <= 20) return transfer.getAmount().multiply(BigDecimal.valueOf(0.082));
        else if (days >= 21 && days <= 30) return transfer.getAmount().multiply(BigDecimal.valueOf(0.069));
        else if (days >= 31 && days <= 40) return transfer.getAmount().multiply(BigDecimal.valueOf(0.047));
        else if (days >= 41 && days <= 50) return transfer.getAmount().multiply(BigDecimal.valueOf(0.017));
        else throw new FeeNotApplicableException("Fee not applicable for the selected date");
    }
}