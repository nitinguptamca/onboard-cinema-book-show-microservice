package com.onboard.cinema.book.show.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class OnboardCinemaBookShowConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OnboardCinemaBookShowConfigServerApplication.class ,args);
    }
}
