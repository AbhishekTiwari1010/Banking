package com.minorProject.banking.model;
import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "account_number", unique = true, nullable = false)
//    private Long accountNumber;

    @Column(name = "account_holder", nullable = false)
    private String accountHolder;

    @Column(name = "balance")
    private double balance;

    public Account() {}

    public Account(String accountHolder, double balance) {
        //this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

//    public Long getAccountNumber() {
//        return accountNumber;
//    }
//
//    public void setAccountNumber(Long accountNumber) {
//        this.accountNumber = accountNumber;
//    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
