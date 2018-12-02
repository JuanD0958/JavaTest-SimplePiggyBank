package com.piggyBank.piggyBank.repository;
import com.piggyBank.piggyBank.domain.Coin;
import org.springframework.beans.factory.annotation.Autowired;

public interface PiggyBankRepository {

    @Autowired
    void insertCoin(Coin coin);

    @Autowired
    int getTotalCountCoinsByType(int type);

    @Autowired
    int getTotalCountCoins();

    @Autowired
    void clearData();
}
