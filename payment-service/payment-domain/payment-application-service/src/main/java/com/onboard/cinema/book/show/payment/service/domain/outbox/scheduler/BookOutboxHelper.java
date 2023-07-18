package com.onboard.cinema.book.show.payment.service.domain.outbox.scheduler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.onboard.cinema.book.show.domain.valueobject.PaymentStatus;
import com.onboard.cinema.book.show.outbox.OutboxStatus;
import com.onboard.cinema.book.show.payment.service.domain.exception.PaymentDomainException;
import com.onboard.cinema.book.show.payment.service.domain.outbox.model.BookEventPayload;
import com.onboard.cinema.book.show.payment.service.domain.outbox.model.BookOutboxMessage;
import com.onboard.cinema.book.show.payment.service.domain.ports.output.repository.BookOutboxRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.onboard.cinema.book.show.domain.DomainConstants.UTC;
import static com.onboard.cinema.book.show.saga.book.SagaConstants.BOOK_SAGA_NAME;


@Slf4j
@Component
public class BookOutboxHelper {

    private final BookOutboxRepository bookOutboxRepository;
    private final ObjectMapper objectMapper;

    public BookOutboxHelper(BookOutboxRepository bookOutboxRepository, ObjectMapper objectMapper) {
        this.bookOutboxRepository = bookOutboxRepository;
        this.objectMapper = objectMapper;
    }

    @Transactional(readOnly = true)
    public Optional<BookOutboxMessage> getCompletedOrderOutboxMessageBySagaIdAndPaymentStatus(UUID sagaId,
                                                                                              PaymentStatus
                                                                                                       paymentStatus) {
        return bookOutboxRepository.findByTypeAndSagaIdAndPaymentStatusAndOutboxStatus(BOOK_SAGA_NAME, sagaId,
                paymentStatus, OutboxStatus.COMPLETED);
    }

    @Transactional(readOnly = true)
    public Optional<List<BookOutboxMessage>> getOrderOutboxMessageByOutboxStatus(OutboxStatus outboxStatus) {
        return bookOutboxRepository.findByTypeAndOutboxStatus(BOOK_SAGA_NAME, outboxStatus);
    }

    @Transactional
    public void deleteOrderOutboxMessageByOutboxStatus(OutboxStatus outboxStatus) {
        bookOutboxRepository.deleteByTypeAndOutboxStatus(BOOK_SAGA_NAME, outboxStatus);
    }

    @Transactional
    public void saveOrderOutboxMessage(BookEventPayload bookEventPayload,
                                       PaymentStatus paymentStatus,
                                       OutboxStatus outboxStatus,
                                       UUID sagaId) {
        save(BookOutboxMessage.builder()
                .id(UUID.randomUUID())
                .sagaId(sagaId)
                .createdAt(bookEventPayload.getCreatedAt())
                .processedAt(ZonedDateTime.now(ZoneId.of(UTC)))
                .type(BOOK_SAGA_NAME)
                .payload(createPayload(bookEventPayload))
                .paymentStatus(paymentStatus)
                .outboxStatus(outboxStatus)
                .version(1).build());
    }

    @Transactional
    public void updateOutboxMessage(BookOutboxMessage bookOutboxMessage, OutboxStatus outboxStatus) {
        bookOutboxMessage.setOutboxStatus(outboxStatus);
        save(bookOutboxMessage);
        log.info("Order outbox table status is updated as: {}", outboxStatus.name());
    }

    private String createPayload(BookEventPayload bookEventPayload) {
        try {
            return objectMapper.writeValueAsString(bookEventPayload);
        } catch (JsonProcessingException e) {
            log.error("Could not create BookEventPayload json!", e);
            throw new PaymentDomainException("Could not create BookEventPayload json!", e);
        }
    }

    private void save(BookOutboxMessage bookOutboxMessage) {
        BookOutboxMessage response = bookOutboxRepository.save(bookOutboxMessage);
        if (response == null) {
            log.error("Could not save BookOutboxMessage!");
            throw new PaymentDomainException("Could not save BookOutboxMessage!");
        }
        log.info("BookOutboxMessage is saved with id: {}", bookOutboxMessage.getId());
    }
}
