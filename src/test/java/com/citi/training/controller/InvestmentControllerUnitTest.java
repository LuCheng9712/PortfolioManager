package com.citi.training.controller;

import com.citi.training.PortfolioManager.entities.Investment;
import com.citi.training.PortfolioManager.repo.InvestmentRepository;
import com.citi.training.PortfolioManager.rest.InvestmentController;
import com.citi.training.PortfolioManager.service.InvestmentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class InvestmentControllerUnitTest {

    @TestConfiguration
    protected static class config {
        @Bean
        @Primary
        public InvestmentRepository investRepo() {
            return mock(InvestmentRepository.class);
        }

        @Bean
        @Primary
        public InvestmentService service() {
            Investment investment = new Investment();
            List<Investment> investments = new ArrayList<>();
            investments.add(investment);

            InvestmentService service = mock(InvestmentService.class);
            when(service.getAllInvestments()).thenReturn(investments);
            when(service.getInvestmentById(1)).thenReturn(investment);
            when(service.getInvestmentByTicker("AAPL")).thenReturn(null);
            return service;
        }

        @Bean
        @Primary
        public InvestmentController controller() {
            return new InvestmentController();
        }
    }

    @Autowired
    private InvestmentController controller;

    @Test
    public void testFindAll() {
        Iterable<Investment> cds = controller.getAllInvestments();
        Stream<Investment> stream = StreamSupport.stream(cds.spliterator(), false);
        Assertions.assertEquals(stream.count(), 1L);
    }

    @Test
    public void testGetInvestmentByID(Integer id) {

    }
}
