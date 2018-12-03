package com.piggyBank.piggyBank.bussines;

import com.piggyBank.piggyBank.exceptions.CoinValueException;
import com.piggyBank.piggyBank.exceptions.ExceptionMessages;
import org.springframework.stereotype.Component;

@Component
public class CoinRulesImpl implements CoinRules {

    public CoinRulesImpl(){}

    @Override
    public void validateValueOfCoin(int value) {
        if (value != 50 && value != 100 && value != 200 && value != 500 && value != 1000) {
            throw new CoinValueException(ExceptionMessages.WRONG_VALUE_OF_COIN);
        }
    }
}
