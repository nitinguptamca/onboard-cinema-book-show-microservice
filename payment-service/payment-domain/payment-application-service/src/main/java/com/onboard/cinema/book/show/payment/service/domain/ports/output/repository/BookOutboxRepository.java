package com.onboard.cinema.book.show.payment.service.domain.ports.output.repository;



import com.onboard.cinema.book.show.domain.valueobject.PaymentStatus;
import com.onboard.cinema.book.show.outbox.OutboxStatus;
import com.onboard.cinema.book.show.payment.service.domain.outbox.model.BookOutboxMessage;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookOutboxRepository {
    BookOutboxMessage save(BookOutboxMessage bookOutboxMessage);

    Optional<List<BookOutboxMessage>> findByTypeAndOutboxStatus(String type, OutboxStatus status);

    Optional<BookOutboxMessage> findByTypeAndSagaIdAndPaymentStatusAndOutboxStatus(String type,
                                                                                   UUID sagaId,
                                                                                   PaymentStatus paymentStatus,
                                                                                   OutboxStatus outboxStatus);
    void deleteByTypeAndOutboxStatus(String type, OutboxStatus status);
}
