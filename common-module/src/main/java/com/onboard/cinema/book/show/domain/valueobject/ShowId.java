package com.onboard.cinema.book.show.domain.valueobject;

import java.util.UUID;

public class ShowId extends BaseId<UUID> {
    public ShowId(UUID value) {
        super(value);
    }
}
