package com.onboard.cinema.book.show.booking.service.domain.dto.message;

import com.onboard.cinema.book.show.common.valueobject.BookingApprovalStatus;
import java.time.Instant;
import java.util.List;
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
    private String paymentId;
    private String customerId;
    private String movieId;
    private String showId;
    private String cinemaHallId;
    private List<String> seats;
    private BookingApprovalStatus bookingApprovalStatus;
    private List<String> failureMessages;
}
