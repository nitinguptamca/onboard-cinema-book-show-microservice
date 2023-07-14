package com.onboard.cinema.book.show.common.valueobject;

import java.util.UUID;

public class CustomerId extends BaseId<UUID> {
    public CustomerId(UUID value) {
        super(value);
    }
}
