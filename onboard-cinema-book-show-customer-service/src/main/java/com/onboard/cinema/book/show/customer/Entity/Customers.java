package com.onboard.cinema.book.show.customer.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="customers")
public class Customers {

    @Id
    private UUID id;
    private String email;
    private String firstname;
    private String lastname;
    private Integer mobile;
    private Integer pincode;
}
