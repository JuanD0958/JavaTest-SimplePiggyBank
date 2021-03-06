package com.piggyBank.piggyBank.api;


import com.piggyBank.piggyBank.domain.Coin;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
public interface PiggyBankServices {

    @GetMapping("/getTotalNumberOfCoins")
    int totalNumberOfCoins();

    @PostMapping("/insertCoinIntoPiggy")
     void insertCoinIntoPiggy(@RequestBody Coin coin);

    @GetMapping("/getNumberOfCounsByValue")
    int numberOfCoinsByValue(@RequestParam("value") int valueCoin);
}