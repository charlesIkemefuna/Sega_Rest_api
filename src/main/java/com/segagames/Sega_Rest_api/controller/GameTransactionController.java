package com.segagames.Sega_Rest_api.controller;


import com.segagames.Sega_Rest_api.entity.GameTransaction;
import com.segagames.Sega_Rest_api.exceptions.InvalidGameTransactionIdException;
import com.segagames.Sega_Rest_api.exceptions.NegativeValueException;
import com.segagames.Sega_Rest_api.service.GameTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/segagames")
public class GameTransactionController {

    @Autowired
    private GameTransactionService gameTransactionService;

    @PostMapping("/addGameTransaction")
    public GameTransaction addGameTransaction(@RequestBody GameTransaction gameTransaction){
        if(gameTransaction.getAmount()<0){
            throw new NegativeValueException("Please enter a transaction Id and an amount that are greater than 0.");
        }
        List <GameTransaction> gameTransactions = gameTransactionService.getGameTransactions();
       // gameTransactions.stream().filter(e->e.getTransactionId() == gameTransaction.getTransactionId());
        for(GameTransaction g:gameTransactions){
            if(g.getTransactionId() == gameTransaction.getTransactionId()){
                throw new InvalidGameTransactionIdException("This Transaction id already exists in the database. Please enter a valid transactionId or Leave this field blank. ");
            }
        }
        return gameTransactionService.saveGameTransaction(gameTransaction);
    }

    @PostMapping("/addGameTransactions")
    public List <GameTransaction> addGameTransactions (@RequestBody List<GameTransaction> gameTransactions){
        return gameTransactionService.saveGameTransactions(gameTransactions);
    }

    @GetMapping("/getGameTransactions")
    public List<GameTransaction> getGameTransactions(){
        return gameTransactionService.getGameTransactions();
    }

    @GetMapping("/getGameTransaction")
    public GameTransaction getGameTransaction(int id){
        return gameTransactionService.getGameTransactionById(id);
    }

    @DeleteMapping("/removeGameTransaction")
    public String removeGameTransaction(int id){
        return gameTransactionService.deleteGameTransaction(id);
    }

    @DeleteMapping("/removeAllGameTransactions")
    public void removeGameTransactions(){
         gameTransactionService.deleteAllGameTransactions();
    }

}
