package com.piggyBank.piggyBank.UnitTest;


import com.piggyBank.piggyBank.controllers.PiggyBankController;
import com.piggyBank.piggyBank.domain.Coin;
import com.piggyBank.piggyBank.exeptions.ExceptionMessages;
import com.piggyBank.piggyBank.repository.PiggyBankRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PiggyBankControllerTest {


    @InjectMocks
    @Autowired
    PiggyBankController piggyBankController;
    @Mock
    PiggyBankRepository piggyBankRepository;



    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getTotalCountOf50Coins(){
        int type = 50;
        Mockito.when(piggyBankRepository.getTotalCountCoinsByValue(type)).thenReturn(30);
        int numberOfCoins= piggyBankController.numberOfCoinsByValue(type);
        assertEquals(30,numberOfCoins);
    }

    @Test
    public void getTotalCountOf100Coins(){
        int type = 100;
        Mockito.when(piggyBankRepository.getTotalCountCoinsByValue(type)).thenReturn(40);
        int numberOfCoins= piggyBankController.numberOfCoinsByValue(type);
        assertEquals(40,numberOfCoins);
    }

    @Test
    public void getTotalCountOf200Coins(){
        int type = 200;
        Mockito.when(piggyBankRepository.getTotalCountCoinsByValue(type)).thenReturn(28);
        int numberOfCoins= piggyBankController.numberOfCoinsByValue(type);
        assertEquals(28,numberOfCoins);
    }

    @Test
    public void getTotalCountOf500Coins(){
        int type = 500;
        Mockito.when(piggyBankRepository.getTotalCountCoinsByValue(type)).thenReturn(45);
        int numberOfCoins= piggyBankController.numberOfCoinsByValue(type);
        assertEquals(45,numberOfCoins);
    }

    @Test
    public void getTotalCountOf1000Coins(){
        int type = 1000;
        Mockito.when(piggyBankRepository.getTotalCountCoinsByValue(type)).thenReturn(19);
        int numberOfCoins= piggyBankController.numberOfCoinsByValue(type);
        assertEquals(19,numberOfCoins);
    }

    @Test
    public void wrongTypeOfCoin(){
        try {
            int type = 6000;
            piggyBankController.numberOfCoinsByValue(type);
            fail();
        } catch (Exception e) {
            assertEquals(ExceptionMessages.WRONG_VALUE_OF_COIN, e.getMessage());
        }
    }

    @Test
    public void totalNumberOfCoinsTest(){
        Mockito.when(piggyBankRepository.getTotalCountCoins()).thenReturn(54);
        int numberOfCoins= piggyBankController.totalNumberOfCoins();
        assertEquals(54,numberOfCoins);
    }

    @Test
    public void insertCoinIntoPiggy(){
        Coin coin = new Coin(50);
        Mockito.doNothing().when(piggyBankRepository).insertCoin(coin);
        piggyBankController.insertCoinIntoPiggy(coin);
        verify(piggyBankRepository, times(1)).insertCoin(coin);
    }
}
