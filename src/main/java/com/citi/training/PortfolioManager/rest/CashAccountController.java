package com.citi.training.PortfolioManager.rest;


import com.citi.training.PortfolioManager.entities.CashAccount;
import com.citi.training.PortfolioManager.service.CashAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/cashaccount")
public class CashAccountController {

    @Autowired
    private CashAccountService cashAccountService;


    @GetMapping
    public Collection<CashAccount> getAllCashAccounts() {
        return cashAccountService.getAllCashAccounts();
    }



}