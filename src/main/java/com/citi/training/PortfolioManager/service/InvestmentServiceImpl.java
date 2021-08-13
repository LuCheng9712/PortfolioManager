package com.citi.training.PortfolioManager.service;

import com.citi.training.PortfolioManager.entities.Investment;
import com.citi.training.PortfolioManager.entities.Transaction;
import com.citi.training.PortfolioManager.repo.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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
        Optional<Investment> investment = investmentRepository.findById(id);
        return investment.orElse(null);
    }

    @Override
    public Investment getInvestmentByTicker(String ticker) {
        Optional<Investment> investment = investmentRepository.findByTicker(ticker);
        return investment.orElse(null);
    }

    @Override
    public void deleteInvestmentById(Integer id) {
        Investment toBeDeleted = getInvestmentById(id);
        deleteInvestment(toBeDeleted);
    }

    @Override
    public void deleteInvestmentByTicker(String ticker) {
        Investment toBeDeleted = getInvestmentByTicker(ticker);
        deleteInvestment(toBeDeleted);
    }

    @Override
    public void deleteInvestment(Investment investment) {
        investmentRepository.delete(investment);
    }

    @Override
    public void updateInvestment(Transaction transaction) {

    }

    @Override
    public void addNewInvestment(Investment investment) {
        investment.setId(0);
        investmentRepository.save(investment);
    }

    @Override
    public Integer getTotalInvestmentAmount() {
        Collection<Investment> allInvestments = investmentRepository.findAll();
        Integer total = 0;
        for (Investment investment: allInvestments) {
            total += investment.getQuantity();
        }
        return null;
    }

}
