package com.onboard.cinema.book.show.payment.domain.ports.output.repository;


import com.onboard.cinema.book.show.common.valueobject.CustomerId;
import com.onboard.cinema.book.show.payment.service.domain.entity.CreditEntry;
import java.util.Optional;

public interface CreditEntryRepository {

    CreditEntry save(CreditEntry creditEntry);

    Optional<CreditEntry> findByCustomerId(CustomerId customerId);
}
