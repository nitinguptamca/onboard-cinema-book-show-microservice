package com.onboard.cinema.book.show.saga;

import com.onboard.cinema.book.show.common.event.DomainEvent;

public interface SagaStep<T, S extends DomainEvent, U extends DomainEvent> {
    S process(T data);

    U rollback(T data);
}
