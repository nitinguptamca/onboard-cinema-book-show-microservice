package com.onboard.cinema.book.show.booking.service.domain.dto.create;

import com.onboard.cinema.book.show.common.valueobject.BookingStatus;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateBookingResponse {
    @NotNull
    private final UUID bookTrackingId;
    @NotNull
    private final BookingStatus bookingStatus;
    @NotNull
    private final String message;
}
