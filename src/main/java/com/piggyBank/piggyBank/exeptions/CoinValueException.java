package com.piggyBank.piggyBank.exeptions;

public class CoinValueException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -2812190201200119620L;

    public CoinValueException(String message) {
        super(message);
    }
}