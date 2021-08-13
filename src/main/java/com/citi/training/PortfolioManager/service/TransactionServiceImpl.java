package com.citi.training.PortfolioManager.service;

import com.citi.training.PortfolioManager.entities.Transaction;
import com.citi.training.PortfolioManager.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Collection<Transaction> getTransactionByDate(Date date) {
        return null;
    }

    @Override
    public Collection<Transaction> getTransactionByAccount(Integer account) {
        return null;
    }

    @Override
    public Transaction addNewTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

}
