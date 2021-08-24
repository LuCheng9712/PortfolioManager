package com.citi.training.controller;

import com.citi.training.PortfolioManager.entities.Transaction;
import com.citi.training.PortfolioManager.repo.TransactionRepository;
import com.citi.training.PortfolioManager.rest.InvestmentController;
import com.citi.training.PortfolioManager.rest.TransactionController;
import com.citi.training.PortfolioManager.service.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes=TransactionControllerUnitTest.Config.class)
public class TransactionControllerUnitTest {
    
    @Autowired
    private TransactionController controller;

    @TestConfiguration
    protected static class Config {
        @Bean
        @Primary
        public TransactionRepository repo() {
            return mock(TransactionRepository.class);
        }

        @Bean
        @Primary
        public TransactionService service() {
            Transaction transaction = new Transaction();
            List<Transaction> transactions = new ArrayList<>();
            transactions.add(transaction);

            TransactionService service = mock(TransactionService.class);
            when(service.getAllTransactions()).thenReturn(transactions);
            when(service.getTransactionById(1)).thenReturn(transaction);
            when(service.getTransactionByAccount(1)).thenReturn(transactions);
            
            return service;
        }

        @Bean
        @Primary
        public InvestmentController controller() {
            return new InvestmentController();
        }

    }
    
    @Test
    public void testFindAll() {
        Iterable<Transaction> trs = controller.getAllTransactions();
        Stream<Transaction> stream = StreamSupport.stream(trs.spliterator(), false);
        Assertions.assertEquals(stream.count(), 1L);
    }

    @Test
    public void testFindById() {
        Transaction tr = controller.getTransactionById(1);
        assertNotNull(tr);
    }

    @Test
    public void testFindByAccount() {
        Iterable<Transaction> trs = controller.getTransactionByAccount(1);
        Stream<Transaction> stream = StreamSupport.stream(trs.spliterator(), false);
        Assertions.assertEquals(stream.count(), 1L);
    }
}
