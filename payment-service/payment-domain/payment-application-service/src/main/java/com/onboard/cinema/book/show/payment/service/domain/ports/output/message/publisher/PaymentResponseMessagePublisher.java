package com.onboard.cinema.book.show.payment.service.domain.ports.output.message.publisher;



import com.onboard.cinema.book.show.outbox.OutboxStatus;
import com.onboard.cinema.book.show.payment.service.domain.outbox.model.BookOutboxMessage;
import java.util.function.BiConsumer;

public interface PaymentResponseMessagePublisher {
    void publish(BookOutboxMessage bookOutboxMessage,
                 BiConsumer<BookOutboxMessage, OutboxStatus> outboxCallback);
}
