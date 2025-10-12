package br.com.backend.Backend_satc.arquitetura1.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
