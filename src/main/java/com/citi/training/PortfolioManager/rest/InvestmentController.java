package com.citi.training.PortfolioManager.rest;

import com.citi.training.PortfolioManager.entities.Investment;
import com.citi.training.PortfolioManager.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @GetMapping
    public Collection<Investment> getAllInvestments() {
        return investmentService.getAllInvestments();
    }

    @GetMapping(value = "/id/{id}")
    public Investment getInvestmentById(@PathVariable("id") Integer id) {
        return investmentService.getInvestmentById(id);
    }

    @GetMapping(value ="/ticker/{ticker}")
    public Investment getInvestmentByTicker(@PathVariable("ticker") String ticker) {
        return investmentService.getInvestmentByTicker(ticker);
    }

    @DeleteMapping(value ="/delete_investment/id/{id}")
    public void deleteInvestmentById(@PathVariable("id") Integer id) {
        investmentService.deleteInvestmentById(id);
    }

    @DeleteMapping("/delete_investment/ticker/{ticker}")
    public void deleteInvestmentByTicker(@PathVariable("ticker") String ticker) {
        investmentService.deleteInvestmentByTicker(ticker);
    }

    @DeleteMapping
    public void deleteInvestment(@RequestBody Investment investment) {
        investmentService.deleteInvestment(investment);
    }

    @PostMapping(value="/add_investment", consumes="application/json")
    public void updateInvestment(@RequestBody Investment investment) {
        investmentService.updateInvestment(investment);
    }

    @PutMapping(value="/update_investment/{id}", consumes="application/json")
    public void addInvestment(@RequestBody Investment investment) {
        investmentService.addNewInvestment(investment);
    }

    @GetMapping(value = "/get_current_price/id/{id}")
    public Double getCurrentPriceById(@PathVariable("id") Integer id) {
        Investment investment = investmentService.getInvestmentById(id);
        return investmentService.getInvestmentCurrentPrice(investment.getTicker());
    }

    @GetMapping("/get_current_price/ticker/{ticker}")
    public Double getCurrentPriceByTicker(@PathVariable("ticker") String ticker) {
        return investmentService.getInvestmentCurrentPrice(ticker);
    }

    @GetMapping(value = "/get_current_total_value")
    public Double getTotalInvesmentValue() {
        return investmentService.getTotalInvestmentValue();
    }
}
