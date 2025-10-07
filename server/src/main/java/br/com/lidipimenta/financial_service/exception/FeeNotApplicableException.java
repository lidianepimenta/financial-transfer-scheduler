package br.com.lidipimenta.financial_service.exception;

public class FeeNotApplicableException extends RuntimeException {
    public FeeNotApplicableException(String message) {
        super(message);
    }
}
