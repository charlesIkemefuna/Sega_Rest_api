package com.segagames.Sega_Rest_api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GAME_TRANSACTION_TBL")
public class GameTransaction {

    @Id
    @GeneratedValue
    private int transactionId;
    private int userId;
    private String product;
    private double amount;

    public GameTransaction(){

    }

    public GameTransaction(int transactionId, int userId, String product, double amount) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.product = product;
        this.amount = amount;
    }



    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
