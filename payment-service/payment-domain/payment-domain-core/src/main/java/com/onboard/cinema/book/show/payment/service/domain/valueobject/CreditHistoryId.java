package com.onboard.cinema.book.show.payment.service.domain.valueobject;



import com.onboard.cinema.book.show.domain.valueobject.BaseId;
import java.util.UUID;

public class CreditHistoryId extends BaseId<UUID> {
    public CreditHistoryId(UUID value) {
        super(value);
    }
}
