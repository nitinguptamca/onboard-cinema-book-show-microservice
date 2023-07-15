package com.onboard.cinema.book.show.cinema.entity;

import com.onboard.cinema.book.show.cinema.valueobject.ApprovalStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Timestamp;
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
@Table(schema = "cinema" ,name ="booking")
@Entity
@Builder
public class Booking {

    @Id
    @GeneratedValue
    @Column( columnDefinition = "uuid", updatable = false )
    private UUID id;
    @Column(name="number_of_seats")
    private Integer numberOfSeats;
    @Enumerated(EnumType.STRING)
    private ApprovalStatus status;
    @Column(name = "booking_time")
    private Timestamp bookingTime;
    @Column(name = "show_id")
    private UUID showId;
    @Column(name = "user_id")
    private UUID userId;
}
