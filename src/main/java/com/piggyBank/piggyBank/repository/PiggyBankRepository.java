package com.piggyBank.piggyBank.repository;
import org.springframework.beans.factory.annotation.Autowired;

public interface PiggyBankRepository {

    @Autowired
    void insertCoin(int type);

    @Autowired
    int getTotalCountCoinsByType(int type);

    @Autowired
    int getTotalCountCoins();

    @Autowired
    void clearData();
}
