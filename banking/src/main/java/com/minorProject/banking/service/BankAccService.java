package com.minorProject.banking.service;

import org.springframework.stereotype.Service;

import com.minorProject.banking.model.Account;
import com.minorProject.banking.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankAccService {

    @Autowired
    private BankRepository bankRepository;

    public Account createAccount(String holderName, double initialBalance) {
        Account account = new Account(holderName, initialBalance);
        return bankRepository.save(account);
    }

    public String deposit(String holderName, double amount) {
        Optional<Account> accountOpt = bankRepository.findByAccountHolder(holderName);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            account.setBalance(account.getBalance() + amount);
            bankRepository.save(account);
            return "Deposit successful. New Balance: " + account.getBalance();
        }
        return "Account not found!";
    }

    public String withdraw(String holderName, double amount) {
        Optional<Account> accountOpt = bankRepository.findByAccountHolder(holderName);
        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                bankRepository.save(account);
                return "Withdrawal successful. New Balance: " + account.getBalance();
            } else {
                return "Insufficient funds!";
            }
        }
        return "Account not found!";
    }

    public String getBalance(String holderName) {
        Optional<Account> accountOpt = bankRepository.findByAccountHolder(holderName);
        return accountOpt.map(account -> "Current Balance: " + account.getBalance())
                .orElse("Account not found!");
    }
}