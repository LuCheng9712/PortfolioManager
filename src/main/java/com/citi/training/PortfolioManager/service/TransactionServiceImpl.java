package com.citi.training.PortfolioManager.service;

import com.citi.training.PortfolioManager.entities.Transaction;
import com.citi.training.PortfolioManager.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Collection<Transaction> getAllTransactions() {
        return transactionRepository.findAll();    }

    @Override
    public Transaction getTransactionById(Integer id) {
        return transactionRepository.getById(id);
    }

    @Override
    public Collection<Transaction> getTransactionByPeriod(LocalDateTime start, LocalDateTime end) {
        return transactionRepository.findAllByTimeBetween(start, end);
    }

    @Override
    public Collection<Transaction> getTransactionByAccount(Integer account) {
        return transactionRepository.findByAccount(account);
    }

    @Override
    public Transaction addNewTransaction(Transaction transaction) {
        transaction.setId(0);
        return transactionRepository.save(transaction);
    }

}
