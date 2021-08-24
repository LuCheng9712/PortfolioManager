package com.citi.training.PortfolioManager.rest;


import com.citi.training.PortfolioManager.entities.Transaction;
import com.citi.training.PortfolioManager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @GetMapping
    public Collection<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping(value = "id/{id}")
    public Transaction getTransactionById(@PathVariable("id") int id) {
        return transactionService.getTransactionById(id);
    }

    @GetMapping(value = "account/{account}")
    public Collection<Transaction> getTransactionByAccount(@PathVariable("account") int account) {
        return transactionService.getTransactionByAccount(account);
    }
    
    @PostMapping
    public void addTramsaction(@RequestBody Transaction transaction) {
        transactionService.addNewTransaction(transaction);
    }


}
