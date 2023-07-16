package com.onboard.cinema.book.show.booking.service.domain.dto.track;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TrackBookingQuery {
    @NotNull
    private final UUID bookTrackingId;
}
