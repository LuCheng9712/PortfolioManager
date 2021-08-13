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
}