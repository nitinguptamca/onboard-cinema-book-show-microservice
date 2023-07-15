package com.onboard.cinema.book.show.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class OnboardCinemaBookShowAdminServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnboardCinemaBookShowAdminServerApplication.class ,args);
    }
}
