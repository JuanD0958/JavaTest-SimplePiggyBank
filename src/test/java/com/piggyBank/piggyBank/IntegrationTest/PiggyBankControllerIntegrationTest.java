package com.piggyBank.piggyBank.IntegrationTest;

import com.piggyBank.piggyBank.controllers.PiggyBankController;
import com.piggyBank.piggyBank.domain.Coin;
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

    private Coin coin50;
    private Coin coin100;
    private Coin coin200;
    private Coin coin500;
    private Coin coin1000;

    @Autowired
    PiggyBankController piggyBankController;
    @Autowired
    PiggyBankRepository piggyBankRepository;


    @Before
    public void setup() {
        coin50 = new Coin(50);
        coin100 = new Coin(100);
        coin200 = new Coin(200);
        coin500 = new Coin(500);
        coin1000 = new Coin(1000);

        piggyBankRepository.clearData();
    }

    private void insertCountOfCoinsByType(Coin coin, int count) {
        for(int i = 0; i < count; i++){
            piggyBankRepository.insertCoin(coin);
        }
    }

    @Test
    public void insertCoin100IntoPiggy(){
        piggyBankRepository.clearData();
        piggyBankController.insertCoinIntoPiggy(coin100);
        assertEquals(1,piggyBankRepository.getTotalCountCoinsByValue(coin100.getValue()));
    }

    @Test
    public  void insertCoin200IntoPiggy(){
        piggyBankRepository.clearData();
        piggyBankController.insertCoinIntoPiggy(coin200);
        assertEquals(1,piggyBankRepository.getTotalCountCoinsByValue(coin200.getValue()));
    }

    @Test
    public void insertCoin500IntoPiggy(){
        piggyBankRepository.clearData();
        piggyBankController.insertCoinIntoPiggy(coin500);
        assertEquals(1,piggyBankRepository.getTotalCountCoinsByValue(coin500.getValue()));
    }

    @Test
    public void getTotalCountOf50Coins(){
        piggyBankRepository.clearData();
        insertCountOfCoinsByType(coin50,25);
        int numberOfCoins= piggyBankController.numberOfCounsByValue(coin50.getValue());
        assertEquals(25,numberOfCoins);
    }


    @Test
    public void getTotalCountOfCoins(){
        piggyBankRepository.clearData();
        insertCountOfCoinsByType(coin50,23);
        insertCountOfCoinsByType(coin100,7);
        insertCountOfCoinsByType(coin200,10);
        insertCountOfCoinsByType(coin500,15);
        insertCountOfCoinsByType(coin1000,15);
        assertEquals(70,piggyBankController.totalNumberOfCoins());

    }
}

