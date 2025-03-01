package com.minorProject.banking.repository;

import com.minorProject.banking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BankRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByAccountHolder(String accountHolder);
}
