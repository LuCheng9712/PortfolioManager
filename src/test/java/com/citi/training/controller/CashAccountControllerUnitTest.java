package com.citi.training.controller;

import com.citi.training.PortfolioManager.entities.CashAccount;
import com.citi.training.PortfolioManager.repo.CashAccountRepository;
import com.citi.training.PortfolioManager.rest.CashAccountController;
import com.citi.training.PortfolioManager.service.CashAccountService;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CashAccountControllerUnitTest {
    @Autowired
    private CashAccountController controller;
    @TestConfiguration
    protected static class Config {
        @Bean
        @Primary
        public CashAccountRepository repo() {
            return mock(CashAccountRepository.class);
        }

        @Bean
        @Primary
        public CashAccountService service() {
            CashAccount cashacc = new CashAccount();
            List<CashAccount> cashaccs = new ArrayList<>();
            cashaccs.add(cashacc);

            CashAccountService service = mock(CashAccountService.class);
            when(service.getAllCashAccounts()).thenReturn(cashaccs);
            when(service.getAccountById(1)).thenReturn(cashacc);
            return service;
        }

        @Bean
        @Primary
        public CashAccountController controller() {
            return new CashAccountController();
        }
    }

    @Test
    public void testFindAll() {
        Iterable<CashAccount> cashaccs = controller.getAllCashAccounts();
        Stream<CashAccount> stream = StreamSupport.stream(cashaccs.spliterator(), false);
        Assertions.assertEquals(stream.count(), 1L);
    }
}
