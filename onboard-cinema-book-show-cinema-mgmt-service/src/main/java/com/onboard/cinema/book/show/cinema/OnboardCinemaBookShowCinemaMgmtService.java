package com.onboard.cinema.book.show.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OnboardCinemaBookShowCinemaMgmtService {
    public static void main(String[] args) {
        SpringApplication.run(OnboardCinemaBookShowCinemaMgmtService.class ,args);
    }
}
