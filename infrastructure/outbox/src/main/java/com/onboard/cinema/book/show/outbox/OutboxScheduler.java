package com.onboard.cinema.book.show.outbox;

public interface OutboxScheduler {
    void processOutboxMessage();
}
