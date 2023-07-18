package com.onboard.cinema.book.show.payment.service.domain.outbox.scheduler;


import com.onboard.cinema.book.show.outbox.OutboxScheduler;
import com.onboard.cinema.book.show.outbox.OutboxStatus;
import com.onboard.cinema.book.show.payment.service.domain.outbox.model.BookOutboxMessage;
import com.onboard.cinema.book.show.payment.service.domain.ports.output.message.publisher.PaymentResponseMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Component
public class BookOutboxScheduler implements OutboxScheduler {

    private final BookOutboxHelper bookOutboxHelper;
    private final PaymentResponseMessagePublisher paymentResponseMessagePublisher;

    public BookOutboxScheduler(BookOutboxHelper bookOutboxHelper,
                               PaymentResponseMessagePublisher paymentResponseMessagePublisher) {
        this.bookOutboxHelper = bookOutboxHelper;
        this.paymentResponseMessagePublisher = paymentResponseMessagePublisher;
    }

    @Override
    @Transactional
    @Scheduled(fixedRateString = "${payment-service.outbox-scheduler-fixed-rate}",
            initialDelayString = "${payment-service.outbox-scheduler-initial-delay}")
    public void processOutboxMessage() {
        Optional<List<BookOutboxMessage>> outboxMessagesResponse =
                bookOutboxHelper.getOrderOutboxMessageByOutboxStatus(OutboxStatus.STARTED);
        if (outboxMessagesResponse.isPresent() && outboxMessagesResponse.get().size() > 0) {
            List<BookOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} BookOutboxMessage with ids {}, sending to message bus!", outboxMessages.size(),
                    outboxMessages.stream().map(outboxMessage ->
                            outboxMessage.getId().toString()).collect(Collectors.joining(",")));
            outboxMessages.forEach(orderOutboxMessage ->
                    paymentResponseMessagePublisher.publish(orderOutboxMessage,
                            bookOutboxHelper::updateOutboxMessage));
            log.info("{} BookOutboxMessage sent to message bus!", outboxMessages.size());
        }
    }

}
