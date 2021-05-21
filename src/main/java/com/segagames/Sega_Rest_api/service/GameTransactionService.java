package com.segagames.Sega_Rest_api.service;

import com.segagames.Sega_Rest_api.entity.GameTransaction;
import com.segagames.Sega_Rest_api.repository.GameTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameTransactionService {

    @Autowired
    private GameTransactionRepository gameTransactionRepository;


    public GameTransaction saveGameTransaction(GameTransaction gameTransaction) {
        return gameTransactionRepository.save(gameTransaction);
    }

    public List<GameTransaction> saveGameTransactions(List<GameTransaction> gameTransactions) {
        return gameTransactionRepository.saveAll(gameTransactions);
    }

    public List<GameTransaction> getGameTransactions() {
        return gameTransactionRepository.findAll();
    }

    public GameTransaction getGameTransactionById(int id) {
        return gameTransactionRepository.findById(id).orElse(null);
    }

    public String deleteGameTransaction(int id){
        gameTransactionRepository.deleteById(id);
        return "Game Transaction Removed !! " + id;
    }

    public String deleteAllGameTransactions(){
        gameTransactionRepository.deleteAll();
        return "All Game Transactions Have been Deleted !!";
    }
}