package com.onboard.cinema.book.show.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
public class OnboardCinemaBookShowCustomerService {
    public static void main(String[] args) {
        SpringApplication.run(OnboardCinemaBookShowCustomerService.class ,args);
    }
}
