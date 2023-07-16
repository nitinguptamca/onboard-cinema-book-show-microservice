package com.onboard.cinema.book.show.booking.service.domain.dto.message;

import com.onboard.cinema.book.show.common.valueobject.BookingApprovalStatus;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CinemaApprovalResponse {
    private String id;
    private String sagaId;
    private String bookingId;
    private String cinemaId;
    private Instant createdAt;
    private java.lang.String paymentId;
    private java.lang.String customerId;
    private java.lang.String movieId;
    private java.lang.String showId;
    private java.lang.String cinemaHallId;
    private java.lang.String cinemaHallSeatId;
    private int showSeatId;
    private BookingApprovalStatus bookingApprovalStatus;
    private java.util.List<java.lang.String> failureMessages;
}
