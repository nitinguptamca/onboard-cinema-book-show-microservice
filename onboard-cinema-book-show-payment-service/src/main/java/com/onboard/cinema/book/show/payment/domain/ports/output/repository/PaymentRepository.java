package com.onboard.cinema.book.show.payment.domain.ports.output.repository;


import com.onboard.cinema.book.show.payment.service.domain.entity.Payment;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {

    Payment save(Payment payment);

    Optional<Payment> findByBookingId(UUID bookingId);
}
