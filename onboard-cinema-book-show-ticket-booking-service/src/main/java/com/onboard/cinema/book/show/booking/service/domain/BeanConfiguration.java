package com.onboard.cinema.book.show.booking.service.domain;

import com.onboard.cinema.book.show.booking.BookingDomainServiceImpl;
import com.onboard.cinema.book.show.booking.domain.BookingDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public BookingDomainService bookingDomainService(){
        return new BookingDomainServiceImpl();
    }
}
