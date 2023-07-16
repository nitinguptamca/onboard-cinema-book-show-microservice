package com.onboard.cinema.book.show.booking.service.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "order-service")
public class BookServiceConfigData {
    private String paymentRequestTopicName;
    private String paymentResponseTopicName;
    private String cinemaApprovalRequestTopicName;
    private String cinemaApprovalResponseTopicName;
}
