package com.onboard.cinema.book.show.payment.service.domain.valueobject;



import com.onboard.cinema.book.show.domain.valueobject.BaseId;
import java.util.UUID;

public class PaymentId extends BaseId<UUID> {
    public PaymentId(UUID value) {
        super(value);
    }
}
