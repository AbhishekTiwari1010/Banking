package com.minorProject.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
	}

}

//POST http://localhost:8080/bank/createAccount?holderName=John&initialBalance=5000
//POST http://localhost:8080/bank/deposit?holderName=John&amount=1000
//POST http://localhost:8080/bank/withdraw?holderName=John&amount=500
//GET http://localhost:8080/bank/balance?holderName=John