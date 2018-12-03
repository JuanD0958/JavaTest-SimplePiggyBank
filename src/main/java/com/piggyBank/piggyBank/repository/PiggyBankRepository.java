package com.piggyBank.piggyBank.repository;
import com.piggyBank.piggyBank.domain.Coin;

public interface PiggyBankRepository {

    void insertCoin(Coin coin);

    int getTotalCountCoinsByValue(int value);

    int getTotalCountCoins();

    void clearData();
}
