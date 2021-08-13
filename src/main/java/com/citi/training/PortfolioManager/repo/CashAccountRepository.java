package com.citi.training.PortfolioManager.repo;

import com.citi.training.PortfolioManager.entities.CashAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
public interface CashAccountRepository extends JpaRepository<CashAccount, Integer> {
    Collection<CashAccount> findByName(String title);
}
