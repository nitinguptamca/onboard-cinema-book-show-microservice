package com.onboard.cinema.book.show.domain.valueobject;

import java.util.UUID;

public class CinemaId extends BaseId<UUID> {
    public CinemaId(UUID value) {
        super(value);
    }
}
