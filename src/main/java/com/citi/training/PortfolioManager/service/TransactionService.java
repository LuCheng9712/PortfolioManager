package com.citi.training.PortfolioManager.service;

import com.citi.training.PortfolioManager.entities.Transaction;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

public interface TransactionService {
    Collection<Transaction> getAllTransactions();

    Transaction getTransactionById(Integer id);

    Collection<Transaction> getTransactionByPeriod(LocalDateTime start, LocalDateTime end);
    Collection<Transaction> getTransactionByAccount(Integer account);

    Transaction addNewTransaction(Transaction transaction);

}
