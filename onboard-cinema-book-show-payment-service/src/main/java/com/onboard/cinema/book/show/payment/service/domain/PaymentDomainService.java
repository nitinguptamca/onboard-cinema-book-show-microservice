package com.onboard.cinema.book.show.payment.service.domain;


import com.onboard.cinema.book.show.common.event.publisher.DomainEventPublisher;
import com.onboard.cinema.book.show.payment.service.domain.entity.CreditEntry;
import com.onboard.cinema.book.show.payment.service.domain.entity.CreditHistory;
import com.onboard.cinema.book.show.payment.service.domain.entity.Payment;
import com.onboard.cinema.book.show.payment.service.domain.event.PaymentCancelledEvent;
import com.onboard.cinema.book.show.payment.service.domain.event.PaymentCompletedEvent;
import com.onboard.cinema.book.show.payment.service.domain.event.PaymentEvent;
import com.onboard.cinema.book.show.payment.service.domain.event.PaymentFailedEvent;
import java.util.List;

public interface PaymentDomainService {

    PaymentEvent validateAndInitiatePayment(Payment payment,
                                            CreditEntry creditEntry,
                                            List<CreditHistory> creditHistories,
                                            List<String> failureMessages,
                                            DomainEventPublisher<PaymentCompletedEvent>
                                                    paymentCompletedEventDomainEventPublisher, DomainEventPublisher<PaymentFailedEvent> paymentFailedEventDomainEventPublisher);

    PaymentEvent validateAndCancelPayment(Payment payment,
                                          CreditEntry creditEntry,
                                          List<CreditHistory> creditHistories,
                                          List<String> failureMessages, DomainEventPublisher<PaymentCancelledEvent> paymentCancelledEventDomainEventPublisher, DomainEventPublisher<PaymentFailedEvent> paymentFailedEventDomainEventPublisher);
}
