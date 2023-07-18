package com.onboard.cinema.book.show.payment.service.domain.valueobject;


import com.onboard.cinema.book.show.domain.valueobject.BaseId;
import java.util.UUID;

public class CreditEntryId extends BaseId<UUID> {
    public CreditEntryId(UUID value) {
        super(value);
    }
}
