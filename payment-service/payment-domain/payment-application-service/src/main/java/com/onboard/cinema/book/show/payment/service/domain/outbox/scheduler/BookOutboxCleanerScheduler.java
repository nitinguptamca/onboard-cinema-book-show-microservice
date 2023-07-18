package com.onboard.cinema.book.show.payment.service.domain.outbox.scheduler;


import com.onboard.cinema.book.show.outbox.OutboxScheduler;
import com.onboard.cinema.book.show.outbox.OutboxStatus;
import com.onboard.cinema.book.show.payment.service.domain.outbox.model.BookOutboxMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class BookOutboxCleanerScheduler implements OutboxScheduler {

    private final BookOutboxHelper bookOutboxHelper;

    public BookOutboxCleanerScheduler(BookOutboxHelper bookOutboxHelper) {
        this.bookOutboxHelper = bookOutboxHelper;
    }

    @Override
    @Transactional
    @Scheduled(cron = "@midnight")
    public void processOutboxMessage() {
        Optional<List<BookOutboxMessage>> outboxMessagesResponse =
                bookOutboxHelper.getOrderOutboxMessageByOutboxStatus(OutboxStatus.COMPLETED);
        if (outboxMessagesResponse.isPresent() && outboxMessagesResponse.get().size() > 0) {
            List<BookOutboxMessage> outboxMessages = outboxMessagesResponse.get();
            log.info("Received {} BookOutboxMessage for clean-up!", outboxMessages.size());
            bookOutboxHelper.deleteOrderOutboxMessageByOutboxStatus(OutboxStatus.COMPLETED);
            log.info("Deleted {} BookOutboxMessage!", outboxMessages.size());
        }
    }
}
