package com.onboard.cinema.book.show.dataaccess.cinemaHall.entity;

import java.io.Serializable;
import java.util.UUID;
import lombok.Data;

@Data
public class CinemaEntityId implements Serializable {
    private UUID cinemaId;
    private UUID showId;
}
