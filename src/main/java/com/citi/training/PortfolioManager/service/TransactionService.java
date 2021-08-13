package com.citi.training.PortfolioManager.service;

import com.citi.training.PortfolioManager.entities.Transaction;

import java.util.Collection;
import java.util.Date;

public interface TransactionService {
    Collection<Transaction> getAllTransactions();

    Transaction getTransactionById(Integer id);

    Collection<Transaction> getTransactionByDate(Date date);
    Collection<Transaction> getTransactionByAccount(Integer account);

    Transaction addNewTransaction(Transaction transaction);

}
