package com.onboard.cinema.book.show.booking.service.messaging.listener.kafka;

import com.onboard.cinema.book.show.booking.service.messaging.mapper.BookingMessagingDataMapper;
import com.onboard.cinema.book.show.booking.service.ports.input.message.listener.payment.PaymentResponseMessageListener;
import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentResponseAvroModel;
import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentStatus;
import com.onboard.cinema.book.show.kafka.config.consumer.KafkaConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class PaymentResponseKafkaListener implements KafkaConsumer<PaymentResponseAvroModel> {

    private final PaymentResponseMessageListener paymentResponseMessageListener;
    private final BookingMessagingDataMapper bookingMessagingDataMapper;

    public PaymentResponseKafkaListener(PaymentResponseMessageListener paymentResponseMessageListener,
                                        BookingMessagingDataMapper bookingMessagingDataMapper) {
        this.paymentResponseMessageListener = paymentResponseMessageListener;
        this.bookingMessagingDataMapper = bookingMessagingDataMapper;
    }


    @Override
    @KafkaListener(id = "${kafka-consumer-config.payment-consumer-group-id}",
            topics = "${booking-service.payment-response-topic-name}")
    public void receive(@Payload List<PaymentResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of payment responses received with keys:{}, partitions:{} and offsets: {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(paymentResponseAvroModel -> {
            if (PaymentStatus.COMPLETED == paymentResponseAvroModel.getPaymentStatus()) {
                log.info("Processing successful payment for booking id: {}", paymentResponseAvroModel.getBookingId());
                paymentResponseMessageListener.paymentCompleted(bookingMessagingDataMapper
                        .paymentResponseAvroModelToPaymentResponse(paymentResponseAvroModel));
            } else if (PaymentStatus.CANCELLED == paymentResponseAvroModel.getPaymentStatus() ||
                    PaymentStatus.FAILED == paymentResponseAvroModel.getPaymentStatus()) {
                log.info("Processing unsuccessful payment for booking id: {}", paymentResponseAvroModel.getBookingId());
                paymentResponseMessageListener.paymentCancelled(bookingMessagingDataMapper
                        .paymentResponseAvroModelToPaymentResponse(paymentResponseAvroModel));
            }
        });
    }
}

