package com.onboard.cinema.book.show.payment.service.messaging.listener.kafka;


import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentBookingStatus;
import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel;
import com.onboard.cinema.book.show.kafka.config.consumer.KafkaConsumer;
import com.onboard.cinema.book.show.payment.domain.exception.PaymentApplicationServiceException;
import com.onboard.cinema.book.show.payment.domain.ports.input.message.listener.PaymentRequestMessageListener;
import com.onboard.cinema.book.show.payment.service.domain.exception.PaymentNotFoundException;
import com.onboard.cinema.book.show.payment.service.messaging.listener.mapper.PaymentMessagingDataMapper;
import java.sql.SQLException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentRequestKafkaListener implements KafkaConsumer<PaymentRequestAvroModel> {

    private final PaymentRequestMessageListener paymentRequestMessageListener;
    private final PaymentMessagingDataMapper paymentMessagingDataMapper;

    public PaymentRequestKafkaListener(PaymentRequestMessageListener paymentRequestMessageListener,
                                       PaymentMessagingDataMapper paymentMessagingDataMapper) {
        this.paymentRequestMessageListener = paymentRequestMessageListener;
        this.paymentMessagingDataMapper = paymentMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.payment-consumer-group-id}",
            topics = "${payment-service.payment-request-topic-name}")
    public void receive(@Payload List<PaymentRequestAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of payment requests received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(paymentRequestAvroModel -> {
            try {
                if (PaymentBookingStatus.PENDING == paymentRequestAvroModel.getPaymentBookingStatus()) {
                    log.info("Processing payment for booking id: {}", paymentRequestAvroModel.getBookingId());
                    paymentRequestMessageListener.completePayment(paymentMessagingDataMapper
                            .paymentRequestAvroModelToPaymentRequest(paymentRequestAvroModel));
                } else if(PaymentBookingStatus.CANCELLED == paymentRequestAvroModel.getPaymentBookingStatus()) {
                    log.info("Cancelling payment for booking id: {}", paymentRequestAvroModel.getBookingId());
                    paymentRequestMessageListener.cancelPayment(paymentMessagingDataMapper
                            .paymentRequestAvroModelToPaymentRequest(paymentRequestAvroModel));
                }
            } catch (DataAccessException e) {
                SQLException sqlException = (SQLException) e.getRootCause();
                if (sqlException != null && sqlException.getSQLState() != null ) {
                    //NO-OP for unique constraint exception
                    log.error("Caught unique constraint exception with sql state: {} " +
                                    "in PaymentRequestKafkaListener for order id: {}",
                            sqlException.getSQLState(), paymentRequestAvroModel.getBookingId());
                } else {
                    throw new PaymentApplicationServiceException("Throwing DataAccessException in" +
                            " PaymentRequestKafkaListener: " + e.getMessage(), e);
                }
            } catch (PaymentNotFoundException e) {
                //NO-OP for PaymentNotFoundException
                log.error("No payment found for order id: {}", paymentRequestAvroModel.getBookingId());
            }
        });

    }
}

