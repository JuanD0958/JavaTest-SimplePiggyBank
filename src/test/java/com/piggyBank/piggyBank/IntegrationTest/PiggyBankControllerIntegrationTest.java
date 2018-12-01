package com.piggyBank.piggyBank.IntegrationTest;

import com.piggyBank.piggyBank.controllers.PiggyBankController;
import com.piggyBank.piggyBank.repository.PiggyBankRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PiggyBankControllerIntegrationTest {

    @Autowired
    PiggyBankController piggyBankController;
    @Autowired
    PiggyBankRepository piggyBankRepository;


    @Before
    public void setup() {
        piggyBankRepository.clearData();
    }

    private void insertCountOfCoinsByType(int type, int count) {
        for(int i = 0; i < count; i++){
            piggyBankRepository.insertCoin(type);
        }
    }

    @Test
    public void insertCoin100IntoPiggy(){
        piggyBankRepository.clearData();
        int type = 100;
        piggyBankController.insertCoinIntoPiggy(type);
        assertEquals(1,piggyBankRepository.getTotalCountCoinsByType(type));
    }

    @Test
    public  void insertCoin200IntoPiggy(){
        piggyBankRepository.clearData();
        int type = 200;
        piggyBankController.insertCoinIntoPiggy(type);
        assertEquals(1,piggyBankRepository.getTotalCountCoinsByType(type));
    }

    @Test
    public void insertCoin500IntoPiggy(){
        piggyBankRepository.clearData();
        int type = 500;
        piggyBankController.insertCoinIntoPiggy(type);
        assertEquals(1,piggyBankRepository.getTotalCountCoinsByType(type));
    }

    @Test
    public void getTotalCountOf50Coins(){
        piggyBankRepository.clearData();
        int type = 50;
        insertCountOfCoinsByType(type,25);
        int numberOfCoins= piggyBankController.numberOfCounsByType(type);
        assertEquals(25,numberOfCoins);
    }


    @Test
    public void getTotalCountOfCoins(){
        piggyBankRepository.clearData();
        insertCountOfCoinsByType(50,23);
        insertCountOfCoinsByType(100,7);
        insertCountOfCoinsByType(200,10);
        insertCountOfCoinsByType(500,15);
        insertCountOfCoinsByType(1000,15);
        assertEquals(70,piggyBankController.totalNumberOfCoins());

    }
}

