package com.onboard.cinema.book.show.payment.service.domain.outbox.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class BookEventPayload {
    @JsonProperty
    private String paymentId;

    @JsonProperty
    private String customerId;

    @JsonProperty
    private String bookingId;

    @JsonProperty
    private BigDecimal price;

    @JsonProperty
    private ZonedDateTime createdAt;

    @JsonProperty
    private String paymentStatus;

    @JsonProperty
    private List<String> failureMessages;
}
