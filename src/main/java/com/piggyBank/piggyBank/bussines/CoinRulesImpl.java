package com.piggyBank.piggyBank.bussines;

import com.piggyBank.piggyBank.exeptions.CoinTypeException;
import com.piggyBank.piggyBank.exeptions.ExceptionMessages;
import org.springframework.stereotype.Component;

@Component
public class CoinRulesImpl implements CoinRules {

    public CoinRulesImpl(){}

    @Override
    public void validateTypeOfCoin(int value) {
        if (value != 50 && value != 100 && value != 200 && value != 500 && value != 1000) {
            throw new CoinTypeException(ExceptionMessages.WRONG_VALUE_OF_COIN);
        }
    }
}
