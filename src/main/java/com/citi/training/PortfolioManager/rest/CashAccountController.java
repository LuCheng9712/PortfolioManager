package com.citi.training.PortfolioManager.rest;


import com.citi.training.PortfolioManager.entities.CashAccount;
import com.citi.training.PortfolioManager.service.CashAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/cash_accounts")
public class CashAccountController {

    @Autowired
    private CashAccountService cashAccountService;


    @GetMapping
    public Collection<CashAccount> getAllCashAccounts() {
        return cashAccountService.getAllCashAccounts();
    }

    @GetMapping(value = "/get_total")
    public double getTotalCash () {
        return cashAccountService.getTotalCash();
    }

    @GetMapping(value = "/{id}")
    public CashAccount findById(@PathVariable("id") int id) {
        return cashAccountService.getAccountById(id);
    }

    @PostMapping(value="/addaccount", consumes="application/json")
    public void addCashAccount(@RequestBody CashAccount cashAccount) {
        cashAccountService.addAccount(cashAccount);
    }

}