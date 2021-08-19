package com.citi.training.PortfolioManager.repo;

import com.citi.training.PortfolioManager.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Collection<Transaction> findByAccount(Integer account_id);
    Collection<Transaction> findAllByTimeBetween(LocalDateTime start, LocalDateTime end);
}
