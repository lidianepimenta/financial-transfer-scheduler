package br.com.lidipimenta.financial_service.controller;

import br.com.lidipimenta.financial_service.exception.FeeNotApplicableException;
import br.com.lidipimenta.financial_service.model.Transfer;
import br.com.lidipimenta.financial_service.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    private final TransferService service;

    public TransferController(TransferService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createTransfer(@RequestBody Transfer transfer) {
        try {
            Transfer saved = service.createTransfer(transfer);
            return ResponseEntity.ok(saved);
        } catch (FeeNotApplicableException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Transfer>> getAllTransfers() {
        return ResponseEntity.ok(service.getAllTransfers());
    }
}