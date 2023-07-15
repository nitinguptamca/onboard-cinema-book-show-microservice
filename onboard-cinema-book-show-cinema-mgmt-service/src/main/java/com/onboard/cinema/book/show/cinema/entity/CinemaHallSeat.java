package com.onboard.cinema.book.show.cinema.entity;

import com.onboard.cinema.book.show.cinema.valueobject.SeatType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "cinema" ,name ="cinemaHallSeat")
@Entity
@Builder
public class CinemaHallSeat {

    @Id
    @GeneratedValue
    @Column( columnDefinition = "uuid", updatable = false )
    private UUID id;
    private Integer seatNumber ;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private Integer totalSeats;
    private UUID cinemaHallId;
}
