package com.citi.training.PortfolioManager.service;

import com.citi.training.PortfolioManager.entities.Transaction;

import java.util.Collection;

public interface TransactionService {
    Collection<Transaction> getAllTransactions();
}
