package com.onboard.cinema.book.show.booking.service.domain.dto.track;

import com.onboard.cinema.book.show.common.valueobject.BookingStatus;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TrackBookingResponse {
    @NotNull
    private final UUID bookTrackingId;
    @NotNull
    private final BookingStatus bookingStatus;
    private final List<String> failureMessages;
}
