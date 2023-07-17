package com.onboard.cinema.book.show.payment.service.dataaccess.payment.adapter;


import com.onboard.cinema.book.show.payment.domain.ports.output.repository.PaymentRepository;
import com.onboard.cinema.book.show.payment.service.dataaccess.payment.mapper.PaymentDataAccessMapper;
import com.onboard.cinema.book.show.payment.service.dataaccess.payment.repository.PaymentJpaRepository;
import com.onboard.cinema.book.show.payment.service.domain.entity.Payment;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class PaymentRepositoryImpl implements PaymentRepository {

    private final PaymentJpaRepository paymentJpaRepository;
    private final PaymentDataAccessMapper paymentDataAccessMapper;

    public PaymentRepositoryImpl(PaymentJpaRepository paymentJpaRepository,
                                 PaymentDataAccessMapper paymentDataAccessMapper) {
        this.paymentJpaRepository = paymentJpaRepository;
        this.paymentDataAccessMapper = paymentDataAccessMapper;
    }

    @Override
    public Payment save(Payment payment) {
        return paymentDataAccessMapper
                .paymentEntityToPayment(paymentJpaRepository
                        .save(paymentDataAccessMapper.paymentToPaymentEntity(payment)));
    }

    @Override
    public Optional<Payment> findByBookingId(UUID orderId) {
        return paymentJpaRepository.findByBookingId(orderId)
                .map(paymentDataAccessMapper::paymentEntityToPayment);
    }
}
