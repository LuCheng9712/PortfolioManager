package com.citi.training.PortfolioManager.repo;

import com.citi.training.PortfolioManager.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Collection<Transaction> findByName(String title);
}
