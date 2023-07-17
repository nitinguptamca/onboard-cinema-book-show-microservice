package com.onboard.cinema.book.show.payment.service.dataaccess.credithistory.mapper;


import com.onboard.cinema.book.show.common.valueobject.CustomerId;
import com.onboard.cinema.book.show.common.valueobject.Money;
import com.onboard.cinema.book.show.payment.service.dataaccess.credithistory.entity.CreditHistoryEntity;
import com.onboard.cinema.book.show.payment.service.domain.entity.CreditHistory;
import com.onboard.cinema.book.show.payment.service.domain.valueobject.CreditHistoryId;
import org.springframework.stereotype.Component;

@Component
public class CreditHistoryDataAccessMapper {

    public CreditHistory creditHistoryEntityToCreditHistory(CreditHistoryEntity creditHistoryEntity) {
        return CreditHistory.builder()
                .creditHistoryId(new CreditHistoryId(creditHistoryEntity.getId()))
                .customerId(new CustomerId(creditHistoryEntity.getCustomerId()))
                .amount(new Money(creditHistoryEntity.getAmount()))
                .transactionType(creditHistoryEntity.getType())
                .build();
    }

    public CreditHistoryEntity creditHistoryToCreditHistoryEntity(CreditHistory creditHistory) {
        return CreditHistoryEntity.builder()
                .id(creditHistory.getId().getValue())
                .customerId(creditHistory.getCustomerId().getValue())
                .amount(creditHistory.getAmount().getAmount())
                .type(creditHistory.getTransactionType())
                .build();
    }

}
