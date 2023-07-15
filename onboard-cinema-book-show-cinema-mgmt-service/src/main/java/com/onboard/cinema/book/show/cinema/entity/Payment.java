package com.onboard.cinema.book.show.cinema.entity;

import com.onboard.cinema.book.show.cinema.valueobject.PaymentMethod;
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
@Table(schema = "cinema" ,name ="payment")
@Entity
@Builder
public class Payment {

    @Id
    @GeneratedValue
    @Column( columnDefinition = "uuid", updatable = false )
    private UUID id;
    private double amount;
    @Column(name = "Discount_Coupon_Id")
    private UUID DiscountCouponId;
    @Column(name = "transaction_Id")
    private UUID transactionId;
    @Column(name = "transaction_Time")
    private Timestamp transactionTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_Method")
    private PaymentMethod paymentMethod;
    private String country;
}
