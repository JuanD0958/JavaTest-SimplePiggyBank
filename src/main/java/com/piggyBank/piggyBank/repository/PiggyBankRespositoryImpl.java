package com.piggyBank.piggyBank.repository;
import com.piggyBank.piggyBank.domain.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.HashMap;


@Component
public class PiggyBankRespositoryImpl implements PiggyBankRepository{

    @Autowired
    private Coin coin;
    private HashMap<Integer,Integer> piggyBank;



    public PiggyBankRespositoryImpl(){
        piggyBank = new HashMap<Integer, Integer>();

        piggyBank.put(50,0);
        piggyBank.put(100,0);
        piggyBank.put(200,0);
        piggyBank.put(500,0);
        piggyBank.put(1000,0);
    }

    @Override
    public void insertCoin(Coin coin){
        int count = piggyBank.get(coin.getValue());
        piggyBank.put(coin.getValue(),count + 1);
    }

    @Override
    public int getTotalCountCoinsByValue(int value){
        return piggyBank.get(value);
    }

    @Override
    public int getTotalCountCoins(){
        int totalCount = 0;
        for (int count : piggyBank.values()) {
            totalCount += count;
        }
        return totalCount;
    }

    @Override
    public void clearData(){
        piggyBank.put(50,0);
        piggyBank.put(100,0);
        piggyBank.put(200,0);
        piggyBank.put(500,0);
        piggyBank.put(1000,0);
    }
}
