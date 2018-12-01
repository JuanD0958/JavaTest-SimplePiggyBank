package com.piggyBank.piggyBank.exeptions;

public class CoinTypeException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -2812190201200119620L;

    public CoinTypeException(String message) {
        super(message);
    }
}