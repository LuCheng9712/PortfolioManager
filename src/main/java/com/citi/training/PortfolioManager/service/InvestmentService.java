package com.citi.training.PortfolioManager.service;

import com.citi.training.PortfolioManager.entities.Investment;

import java.util.Collection;

public interface InvestmentService {
    Collection<Investment> getAllInvestments();
}
