package com.citi.training.PortfolioManager.service;

import com.citi.training.PortfolioManager.entities.CashAccount;
import java.util.Collection;

public interface CashAccountService {
    Collection<CashAccount> getAllCashAccounts();

    CashAccount getAccountById(Integer id);
    CashAccount getAccountByName(String name);
    void deleteAccountById(Integer id);
    void deleteAccountByName(String name);
    void addAccount(CashAccount cashAccount);
    void depositById(Integer id, Double amount);
    void depositByName(String name, Double amount);
    void withdrawById(Integer id, Double amount);
    void withdrawByName(String name, Double amount);
    double getTotalCash();
}
