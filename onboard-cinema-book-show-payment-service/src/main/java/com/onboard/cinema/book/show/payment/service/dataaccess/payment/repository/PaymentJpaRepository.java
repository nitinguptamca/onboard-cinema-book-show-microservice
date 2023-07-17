package com.onboard.cinema.book.show.payment.service.dataaccess.payment.repository;


import com.onboard.cinema.book.show.payment.service.dataaccess.payment.entity.PaymentEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentJpaRepository extends JpaRepository<PaymentEntity, UUID> {

    Optional<PaymentEntity> findByBookingId(UUID bookingId);


}
