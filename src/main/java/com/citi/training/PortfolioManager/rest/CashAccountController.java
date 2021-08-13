package com.citi.training.PortfolioManager.rest;


import com.citi.training.PortfolioManager.entities.CashAccount;
import com.citi.training.PortfolioManager.service.CashAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/cash_accounts")
public class CashAccountController {

    @Autowired
    private CashAccountService cashAccountService;


    @GetMapping
    public Collection<CashAccount> getAllCashAccounts() {
        CashAccount cashAccount = new CashAccount();
        cashAccount.setAmount(4444);
        cashAccount.setName("Added Account");
        cashAccountService.addAccount(cashAccount);
        return cashAccountService.getAllCashAccounts();
    }

}