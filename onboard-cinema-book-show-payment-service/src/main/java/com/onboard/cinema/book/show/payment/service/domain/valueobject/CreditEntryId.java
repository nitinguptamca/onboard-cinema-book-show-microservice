package com.onboard.cinema.book.show.payment.service.domain.valueobject;


import com.onboard.cinema.book.show.common.valueobject.BaseId;
import java.util.UUID;

public class CreditEntryId extends BaseId<UUID> {
    public CreditEntryId(UUID value) {
        super(value);
    }
}
