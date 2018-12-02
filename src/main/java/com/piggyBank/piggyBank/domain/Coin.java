package com.piggyBank.piggyBank.domain;

import org.springframework.stereotype.Component;

@Component
public class Coin {
    private int value;

    public Coin(){}

    public Coin(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
