package com.piggyBank.piggyBank.repository;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class PiggyBankRespositoryImpl implements PiggyBankRepository{

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
    public void insertCoin(int type){
        int count = piggyBank.get(type);
        piggyBank.put(type,count + 1);
    }

    @Override
    public int getTotalCountCoinsByType(int type){
        return piggyBank.get(type);
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
