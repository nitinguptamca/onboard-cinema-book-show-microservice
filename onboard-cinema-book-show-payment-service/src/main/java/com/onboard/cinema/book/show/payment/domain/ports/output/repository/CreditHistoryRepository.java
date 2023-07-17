package com.onboard.cinema.book.show.payment.domain.ports.output.repository;


import com.onboard.cinema.book.show.common.valueobject.CustomerId;
import com.onboard.cinema.book.show.payment.service.domain.entity.CreditHistory;
import java.util.List;
import java.util.Optional;

public interface CreditHistoryRepository {

    CreditHistory save(CreditHistory creditHistory);

    Optional<List<CreditHistory>> findByCustomerId(CustomerId customerId);
}
