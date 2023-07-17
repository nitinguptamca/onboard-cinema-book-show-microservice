package com.onboard.cinema.book.show.payment.domain;

import com.onboard.cinema.book.show.payment.service.domain.PaymentDomainService;
import com.onboard.cinema.book.show.payment.service.domain.PaymentDomainServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public PaymentDomainService paymentDomainService() {
        return new PaymentDomainServiceImpl();
    }
}
