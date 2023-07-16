package com.onboard.cinema.book.show.booking.domain.entiry;


import com.onboard.cinema.book.show.common.entity.BaseEntity;
import com.onboard.cinema.book.show.common.valueobject.Money;
import com.onboard.cinema.book.show.common.valueobject.ShowId;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class Show extends BaseEntity<ShowId> {
    private UUID cinemaHallId;
    private UUID movieId;
    private Timestamp startTime;
    private Timestamp endTime;
    private LocalDate showDate;
    private Money price;

    public Show(ShowId showId) {
        super.setId(showId);
    }

    public Show(UUID cinemaHallId,
                UUID movieId,
                Timestamp startTime,
                Timestamp endTime,
                LocalDate showDate,
                Money price) {
        this.cinemaHallId = cinemaHallId;
        this.movieId = movieId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.showDate = showDate;
        this.price = price;
    }

    public void updateWithConfirmedTitleAndPrice(UUID cinemaHallId,
                                                 UUID movieId,
                                                 Timestamp startTime,
                                                 Timestamp endTime,
                                                 LocalDate showDate,
                                                 ShowId showId,
                                                 Money price
    ) {
        this.cinemaHallId = cinemaHallId;
        this.movieId = movieId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.showDate = showDate;
        this.setId(showId);
        this.price = price;
    }
}
