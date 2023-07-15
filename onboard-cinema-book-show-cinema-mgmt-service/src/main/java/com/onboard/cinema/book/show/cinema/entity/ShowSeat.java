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
@Table(schema = "cinema" ,name ="show_Seat")
@Entity
@Builder
public class ShowSeat {

    @Id
    @GeneratedValue
    @Column( columnDefinition = "uuid", updatable = false )
    private UUID id;
    @Column(name = "show_Seat_Id")
    private Integer showSeatId;
    @Enumerated(EnumType.STRING)
    @Column(name = "seat_Type")
    private SeatType seatType ;
    private double price;
    @Column(name = "show_Id")
    private UUID showId;
    @Column(name = "booking_Id")
    private UUID bookingId;
}
