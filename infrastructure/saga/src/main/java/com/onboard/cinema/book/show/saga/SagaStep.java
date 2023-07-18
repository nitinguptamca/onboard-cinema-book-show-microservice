package com.onboard.cinema.book.show.saga;

public interface SagaStep<T> {
    void process(T data);
    void rollback(T data);
}
