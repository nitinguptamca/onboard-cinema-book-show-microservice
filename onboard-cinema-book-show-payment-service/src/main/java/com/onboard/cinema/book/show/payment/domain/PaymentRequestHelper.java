package com.onboard.cinema.book.show.payment.domain;


import com.onboard.cinema.book.show.common.valueobject.CustomerId;
import com.onboard.cinema.book.show.payment.domain.dto.PaymentRequest;
import com.onboard.cinema.book.show.payment.domain.exception.PaymentApplicationServiceException;
import com.onboard.cinema.book.show.payment.domain.mapper.PaymentDataMapper;
import com.onboard.cinema.book.show.payment.domain.ports.output.message.publisher.PaymentCancelledMessagePublisher;
import com.onboard.cinema.book.show.payment.domain.ports.output.message.publisher.PaymentCompletedMessagePublisher;
import com.onboard.cinema.book.show.payment.domain.ports.output.message.publisher.PaymentFailedMessagePublisher;
import com.onboard.cinema.book.show.payment.domain.ports.output.repository.CreditEntryRepository;
import com.onboard.cinema.book.show.payment.domain.ports.output.repository.CreditHistoryRepository;
import com.onboard.cinema.book.show.payment.domain.ports.output.repository.PaymentRepository;
import com.onboard.cinema.book.show.payment.service.domain.PaymentDomainService;
import com.onboard.cinema.book.show.payment.service.domain.entity.CreditEntry;
import com.onboard.cinema.book.show.payment.service.domain.entity.CreditHistory;
import com.onboard.cinema.book.show.payment.service.domain.entity.Payment;
import com.onboard.cinema.book.show.payment.service.domain.event.PaymentEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class PaymentRequestHelper {

    private final PaymentDomainService paymentDomainService;
    private final PaymentDataMapper paymentDataMapper;
    private final PaymentRepository paymentRepository;
    private final CreditEntryRepository creditEntryRepository;
    private final CreditHistoryRepository creditHistoryRepository;
    private final PaymentCompletedMessagePublisher paymentCompletedEventDomainEventPublisher;
    private final PaymentCancelledMessagePublisher paymentCancelledEventDomainEventPublisher;
    private final PaymentFailedMessagePublisher paymentFailedEventDomainEventPublisher;

    public PaymentRequestHelper(PaymentDomainService paymentDomainService,
                                PaymentDataMapper paymentDataMapper,
                                PaymentRepository paymentRepository,
                                CreditEntryRepository creditEntryRepository,
                                CreditHistoryRepository creditHistoryRepository,
                                PaymentCompletedMessagePublisher paymentCompletedEventDomainEventPublisher,
                                PaymentCancelledMessagePublisher paymentCancelledEventDomainEventPublisher,
                                PaymentFailedMessagePublisher paymentFailedEventDomainEventPublisher) {
        this.paymentDomainService = paymentDomainService;
        this.paymentDataMapper = paymentDataMapper;
        this.paymentRepository = paymentRepository;
        this.creditEntryRepository = creditEntryRepository;
        this.creditHistoryRepository = creditHistoryRepository;
        this.paymentCompletedEventDomainEventPublisher = paymentCompletedEventDomainEventPublisher;
        this.paymentCancelledEventDomainEventPublisher = paymentCancelledEventDomainEventPublisher;
        this.paymentFailedEventDomainEventPublisher = paymentFailedEventDomainEventPublisher;
    }

    @Transactional
    public PaymentEvent persistPayment(PaymentRequest paymentRequest) {
        log.info("Received payment complete event for booking id: {}", paymentRequest.getBookingId());
        Payment payment = paymentDataMapper.paymentRequestModelToPayment(paymentRequest);
        CreditEntry creditEntry = getCreditEntry(payment.getCustomerId());
        List<CreditHistory> creditHistories = getCreditHistory(payment.getCustomerId());
        List<String> failureMessages = new ArrayList<>();
        PaymentEvent paymentEvent =
                paymentDomainService.validateAndInitiatePayment(payment, creditEntry, creditHistories, failureMessages,
                        paymentCompletedEventDomainEventPublisher, paymentFailedEventDomainEventPublisher);
        persistDbObjects(payment, creditEntry, creditHistories, failureMessages);
        return paymentEvent;
    }

    @Transactional
    public PaymentEvent persistCancelPayment(PaymentRequest paymentRequest) {
        log.info("Received payment rollback event for booking id: {}", paymentRequest.getBookingId());
        Optional<Payment> paymentResponse = paymentRepository
                .findByBookingId(UUID.fromString(paymentRequest.getBookingId()));
        if (paymentResponse.isEmpty()) {
            log.error("Payment with booking id: {} could not be found!", paymentRequest.getBookingId());
            throw new PaymentApplicationServiceException("Payment with booking id: " +
                    paymentRequest.getBookingId() + " could not be found!");
        }
        Payment payment = paymentResponse.get();
        CreditEntry creditEntry = getCreditEntry(payment.getCustomerId());
        List<CreditHistory> creditHistories = getCreditHistory(payment.getCustomerId());
        List<String> failureMessages = new ArrayList<>();
        PaymentEvent paymentEvent = paymentDomainService
                .validateAndCancelPayment(payment, creditEntry, creditHistories, failureMessages,
                        paymentCancelledEventDomainEventPublisher, paymentFailedEventDomainEventPublisher);
        persistDbObjects(payment, creditEntry, creditHistories, failureMessages);
        return paymentEvent;
    }

    private CreditEntry getCreditEntry(CustomerId customerId) {
        Optional<CreditEntry> creditEntry = creditEntryRepository.findByCustomerId(customerId);
        if (creditEntry.isEmpty()) {
            log.error("Could not find credit entry for customer: {}", customerId.getValue());
            throw new PaymentApplicationServiceException("Could not find credit entry for customer: " +
                    customerId.getValue());
        }
        return creditEntry.get();
    }

    private List<CreditHistory> getCreditHistory(CustomerId customerId) {
        Optional<List<CreditHistory>> creditHistories = creditHistoryRepository.findByCustomerId(customerId);
        if (creditHistories.isEmpty()) {
            log.error("Could not find credit history for customer: {}", customerId.getValue());
            throw new PaymentApplicationServiceException("Could not find credit history for customer: " +
                    customerId.getValue());
        }
        return creditHistories.get();
    }

    private void persistDbObjects(Payment payment,
                                  CreditEntry creditEntry,
                                  List<CreditHistory> creditHistories,
                                  List<String> failureMessages) {
        paymentRepository.save(payment);
        if (failureMessages.isEmpty()) {
            creditEntryRepository.save(creditEntry);
            creditHistoryRepository.save(creditHistories.get(creditHistories.size() - 1));
        }
    }

}
