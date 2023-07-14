package com.onboard.cinema.book.show.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OnboardCinemaBookShowCustomerService {
    public static void main(String[] args) {
        SpringApplication.run(OnboardCinemaBookShowCustomerService.class ,args);
    }
}
