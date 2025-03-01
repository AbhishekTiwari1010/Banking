package com.minorProject.banking.controller;

import com.minorProject.banking.service.BankAccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bank")
public class BankAccController {
    @Autowired
    private BankAccService bankService;

    @PostMapping("/createAccount")
    public String createAccount( @RequestParam String holderName, @RequestParam double initialBalance) {
        bankService.createAccount(holderName, initialBalance);
        return "Account created successfully for " + holderName;
    }

    @PostMapping("/deposit")
    public String deposit( @RequestParam String holderName, @RequestParam double amount) {
        return bankService.deposit(holderName, amount);
    }

    @PostMapping("/withdraw")
    public String withdraw( @RequestParam String holderName, @RequestParam double amount) {
        return bankService.withdraw(holderName, amount);
    }

    @GetMapping("/balance")
    public String getBalance(@RequestParam String holderName) {
        return bankService.getBalance(holderName);
    }
}
