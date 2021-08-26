package com.citi.training.PortfolioManager.service;

import com.citi.training.PortfolioManager.entities.Investment;
import com.citi.training.PortfolioManager.entities.Transaction;

import java.util.Collection;

public interface InvestmentService {

    Collection<Investment> getAllInvestments();

    Investment getInvestmentById(Integer id);
    Investment getInvestmentByTicker(String ticker);

    void deleteInvestmentById(Integer id);
    void deleteInvestmentByTicker(String ticker);
    void deleteInvestment(Investment investment);

    void updateInvestment(Investment investment);
    void addNewInvestment(Investment investment);

    Double getInvestmentCurrentPrice(String ticker);

    Double getStockCurrentPrice(String ticker);
    Double getStockChangeInPercent(String ticker);
    Double getStockDividend(String ticker);

    Double getTotalInvestmentValue();
}
