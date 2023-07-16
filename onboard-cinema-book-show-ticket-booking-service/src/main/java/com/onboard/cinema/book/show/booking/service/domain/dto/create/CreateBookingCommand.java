package com.onboard.cinema.book.show.booking.service.domain.dto.create;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateBookingCommand {
    @NotNull
    private final UUID customerId;
    @NotNull
    private final UUID cinemaHallId;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final List<BookShow> bookShows;
    @NotNull
    private final CinemaHallAddress cinemaHallAddress;
}
