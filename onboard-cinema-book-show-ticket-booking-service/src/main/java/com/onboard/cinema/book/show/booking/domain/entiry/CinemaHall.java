package com.onboard.cinema.book.show.booking.domain.entiry;

import com.onboard.cinema.book.show.common.entity.AggregateRoot;
import com.onboard.cinema.book.show.common.valueobject.CinemaHallId;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class CinemaHall extends AggregateRoot<CinemaHallId> {
    private final List<Movie> movies;
    private final List<Show> shows;
    private final boolean active;
}
