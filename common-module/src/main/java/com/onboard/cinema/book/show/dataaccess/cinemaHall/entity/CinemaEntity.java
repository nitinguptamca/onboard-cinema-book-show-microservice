package com.onboard.cinema.book.show.dataaccess.cinemaHall.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
public class CinemaEntity {
    @Id
    private UUID cinemaId;
    @Id
    private UUID showId;
    @Id
    private UUID movieId;
    private String cinemaName;
    private Boolean cinemaActive;
    private String movieName;
    private BigDecimal showPrice;
    private Boolean showAvailable;


}
