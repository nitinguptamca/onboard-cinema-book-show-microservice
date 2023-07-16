package com.onboard.cinema.book.show.booking.domain.entiry;

import com.onboard.cinema.book.show.common.entity.AggregateRoot;
import com.onboard.cinema.book.show.common.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {
    public Customer() {
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }
}
