package com.onboard.cinema.book.show.domain.valueobject;

import java.util.UUID;

public class BookingId extends BaseId<UUID> {
    public BookingId(UUID value) {
        super(value);
    }
}
