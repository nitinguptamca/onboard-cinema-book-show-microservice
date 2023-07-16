package com.onboard.cinema.book.show.booking.domain.valueobject;


import com.onboard.cinema.book.show.common.valueobject.BaseId;
import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
