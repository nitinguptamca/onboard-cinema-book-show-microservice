package com.onboard.cinema.book.show.cinema.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(schema = "cinema" ,name ="cinema")
@Entity
@Builder
public class Cinema {

    @Id
    @GeneratedValue
    @Column( columnDefinition = "uuid", updatable = false )
    private UUID id;
    @NotBlank
    private String name;
    @Column(name="contact_number")
    private Long contactNumber;
    @Column(name="pin_code")
    private Long pinCode;
    private String address;
    @Column(name="total_cinema_hall")
    private Integer totalCinemaHall;
}
