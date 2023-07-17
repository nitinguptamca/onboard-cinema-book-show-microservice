package com.onboard.cinema.book.show.payment.service.domain.valueobject;


import com.onboard.cinema.book.show.common.valueobject.BaseId;
import java.util.UUID;

public class PaymentId extends BaseId<UUID> {
    public PaymentId(UUID value) {
        super(value);
    }
}
