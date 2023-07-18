package com.onboard.cinema.book.show.domain.event.publisher;


import com.onboard.cinema.book.show.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
