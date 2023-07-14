package com.onboard.cinema.book.show.common.event;

public interface DomainEvent<T> {
    public void fire();
}
