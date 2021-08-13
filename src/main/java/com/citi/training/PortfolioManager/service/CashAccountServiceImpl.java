package com.citi.training.PortfolioManager.service;

import com.citi.training.PortfolioManager.entities.CashAccount;
import com.citi.training.PortfolioManager.repo.CashAccountRepository;
import com.citi.training.PortfolioManager.service.CashAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CashAccountServiceImpl implements CashAccountService {

    @Autowired
    private CashAccountRepository cashAccountRepository;

    @Override
    public Collection<CashAccount> getAllCashAccounts() {
        return cashAccountRepository.findAll();
    }

    @Override
    public CashAccount getAccountById(Integer id) {
        return cashAccountRepository.findById(id).get();
    }

    @Override
    public CashAccount getAccountByName(String name){
        return cashAccountRepository.findByName(name).stream().findFirst().get();
    }

    @Override
    public void deleteAccountById(Integer id) {
        cashAccountRepository.deleteById(id);
    }

    @Override
    public void deleteAccountByName(String name) {

    }

    @Override
    public void addAccount(CashAccount cashAccount) {
        cashAccount.setId(0);
        cashAccountRepository.save(cashAccount);

    }

    @Override
    public void depositById(Integer id, Double amount) {

    }

    @Override
    public void depositByName(String name, Double amount) {

    }

    @Override
    public void withdrawById(Integer id, Double amount) {

    }

    @Override
    public void withdrawByName(String name, Double amount) {

    }

    @Override
    public double getTotalCash() {
        return 100; //placeholder
    }
}