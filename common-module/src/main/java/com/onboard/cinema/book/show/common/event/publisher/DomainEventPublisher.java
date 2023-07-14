package com.onboard.cinema.book.show.common.event.publisher;


import com.onboard.cinema.book.show.common.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
