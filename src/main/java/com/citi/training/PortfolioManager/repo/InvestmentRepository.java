package com.citi.training.PortfolioManager.repo;

import com.citi.training.PortfolioManager.entities.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface InvestmentRepository extends JpaRepository<Investment, Integer> {
    Optional<Investment> findByTicker(String ticker);
}
