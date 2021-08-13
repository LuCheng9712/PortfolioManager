package com.citi.training.PortfolioManager.service;

import com.citi.training.PortfolioManager.entities.Investment;
import com.citi.training.PortfolioManager.repo.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class InvestmentServiceImpl implements InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    @Override
    public Collection<Investment> getAllInvestments() {
        return investmentRepository.findAll();
    }

    @Override
    public Investment getInvestmentById(Integer id) {
        return null;
    }

    @Override
    public Investment getInvestmentByTicker(String ticker) {
        return null;
    }

    @Override
    public void deleteInvestmentById(Integer id) {

    }

    @Override
    public void deleteInvestmentByTicker(String ticker) {

    }

    @Override
    public void updateInvestment(Investment investment) {

    }

    @Override
    public void addNewInvestment(Investment investment) {

    }

    @Override
    public Integer getTotalInvestmentAmount() {
        return null;
    }


}
