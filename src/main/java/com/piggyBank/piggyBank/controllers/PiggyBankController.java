package com.piggyBank.piggyBank.controllers;

import com.piggyBank.piggyBank.api.PiggyBankServices;
import com.piggyBank.piggyBank.exeptions.CoinTypeException;
import com.piggyBank.piggyBank.repository.PiggyBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PiggyBankController implements PiggyBankServices {

    @Autowired
    private PiggyBankRepository piggyBankRepository;

    @Override
    public void insertCoinIntoPiggy(int type){
        validateTypeOfCoin(type);
        piggyBankRepository.insertCoin(type);
    }

    @Override
    public int totalNumberOfCoins(){
        return piggyBankRepository.getTotalCountCoins();
    }

    @Override
    public int numberOfCounsByType(int type){
        validateTypeOfCoin(type);
        return piggyBankRepository.getTotalCountCoinsByType(type);
    }

    private void validateTypeOfCoin(int type) {
        if (type != 50 && type != 100 && type != 200 && type != 500 && type != 1000) {
            throw new CoinTypeException("Type of coin does not exist!!!");
        }
    }
}
