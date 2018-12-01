package com.piggyBank.piggyBank.api;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@RestController
public interface PiggyBankServices {

    @RequestMapping("/getNumberOfCoins")
    int totalNumberOfCoins();

    @PostMapping("/insertCoinIntoPiggy")
     void insertCoinIntoPiggy(@RequestBody int coin);

    @GetMapping("/getNumberOfCounsByType")
    int numberOfCounsByType(@RequestParam("type") int typeCoin);
}