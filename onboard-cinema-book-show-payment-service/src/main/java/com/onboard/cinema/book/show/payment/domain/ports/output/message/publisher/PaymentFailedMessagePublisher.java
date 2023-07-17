package com.onboard.cinema.book.show.payment.domain.ports.output.message.publisher;


import com.onboard.cinema.book.show.common.event.publisher.DomainEventPublisher;
import com.onboard.cinema.book.show.payment.service.domain.event.PaymentFailedEvent;

public interface PaymentFailedMessagePublisher extends DomainEventPublisher<PaymentFailedEvent> {
}
