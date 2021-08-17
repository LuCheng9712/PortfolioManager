package com.citi.training.PortfolioManager.rest;


import com.citi.training.PortfolioManager.entities.Investment;
import com.citi.training.PortfolioManager.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;


    @GetMapping
    public Collection<Object> getAllInvestmentsAndTotalValue() {
        double val = investmentService.getTotalInvestmentValue();
        Collection<Investment> investments = investmentService.getAllInvestments();
        Collection<Object> res = new ArrayList<Object>();
        res.add(val);
        res.add(investments);
        return res;
    }

    public double getCashTotal() {
        return investmentService.getTotalInvestmentValue();
    }

    public Collection<Investment> getAllInvestments() {

        Investment investmentId3 = investmentService.getInvestmentById(3);
        Investment AAPL = investmentService.getInvestmentByTicker("AAPL");

        investmentService.deleteInvestmentById(1);
        investmentService.deleteInvestmentByTicker("GOOGL");
        investmentService.deleteInvestment(investmentId3);
        investmentService.deleteInvestment(AAPL);

        Investment AMD = new Investment(1, "AMD", "Advanced Micro Devices, Inc.", "stock", 34, 110.55);
        investmentService.addNewInvestment(AMD);

        return investmentService.getAllInvestments();
    }
}
