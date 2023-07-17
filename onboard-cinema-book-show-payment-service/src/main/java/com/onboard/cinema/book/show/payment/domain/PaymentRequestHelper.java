package com.onboard.cinema.book.show.payment.domain;


import com.onboard.cinema.book.show.payment.domain.mapper.PaymentDataMapper;
import com.onboard.cinema.book.show.payment.domain.ports.output.message.publisher.PaymentCancelledMessagePublisher;
import com.onboard.cinema.book.show.payment.domain.ports.output.message.publisher.PaymentCompletedMessagePublisher;
import com.onboard.cinema.book.show.payment.domain.ports.output.message.publisher.PaymentFailedMessagePublisher;
import com.onboard.cinema.book.show.payment.service.domain.PaymentDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentRequestHelper {

    private final PaymentDomainService paymentDomainService;
    private final PaymentDataMapper paymentDataMapper;
    private final PaymentCompletedMessagePublisher paymentCompletedEventDomainEventPublisher;
    private final PaymentCancelledMessagePublisher paymentCancelledEventDomainEventPublisher;
    private final PaymentFailedMessagePublisher paymentFailedEventDomainEventPublisher;

    public PaymentRequestHelper(PaymentDomainService paymentDomainService,
                                PaymentDataMapper paymentDataMapper,
                                PaymentCompletedMessagePublisher paymentCompletedEventDomainEventPublisher,
                                PaymentCancelledMessagePublisher paymentCancelledEventDomainEventPublisher,
                                PaymentFailedMessagePublisher paymentFailedEventDomainEventPublisher) {
        this.paymentDomainService = paymentDomainService;
        this.paymentDataMapper = paymentDataMapper;
        this.paymentCompletedEventDomainEventPublisher = paymentCompletedEventDomainEventPublisher;
        this.paymentCancelledEventDomainEventPublisher = paymentCancelledEventDomainEventPublisher;
        this.paymentFailedEventDomainEventPublisher = paymentFailedEventDomainEventPublisher;
    }

}
