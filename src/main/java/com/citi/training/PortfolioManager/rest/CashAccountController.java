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

    @DeleteMapping(value= "/deletebyid/{id}")
    public void deleteAccountById(@PathVariable("id") int id){
        cashAccountService.deleteAccountById(id);
    }

    @PostMapping(value= "/deposit/{deposit}", consumes="application/json")
    public void depositById(@PathVariable("deposit") double deposit, @RequestBody CashAccount cashAccount) {
        cashAccountService.depositById(cashAccount.getId(), deposit);
    }

    @PostMapping(value= "/withdraw/{withdraw}", consumes="application/json")
    public void withdrawById(@PathVariable("withdraw") double withdraw, @RequestBody CashAccount cashAccount) {
        cashAccountService.withdrawById(cashAccount.getId(), withdraw);
    }

}