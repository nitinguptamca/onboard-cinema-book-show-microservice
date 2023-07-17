package com.onboard.cinema.book.show.payment.service.messaging.publish.kafka;

import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentResponseAvroModel;
import com.onboard.cinema.book.show.kafka.producer.KafkaMessageHelper;
import com.onboard.cinema.book.show.kafka.producer.service.KafkaProducer;
import com.onboard.cinema.book.show.payment.domain.config.PaymentServiceConfigData;
import com.onboard.cinema.book.show.payment.domain.ports.output.message.publisher.PaymentCancelledMessagePublisher;
import com.onboard.cinema.book.show.payment.service.domain.event.PaymentCancelledEvent;
import com.onboard.cinema.book.show.payment.service.messaging.listener.mapper.PaymentMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PaymentCancelledKafkaMessagePublisher implements PaymentCancelledMessagePublisher {
    private final PaymentMessagingDataMapper paymentMessagingDataMapper;
    private final KafkaProducer<String, PaymentResponseAvroModel> kafkaProducer;
    private final PaymentServiceConfigData paymentServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;

    public PaymentCancelledKafkaMessagePublisher(PaymentMessagingDataMapper paymentMessagingDataMapper, KafkaProducer<String, PaymentResponseAvroModel> kafkaProducer, PaymentServiceConfigData paymentServiceConfigData, KafkaMessageHelper kafkaMessageHelper) {
        this.paymentMessagingDataMapper = paymentMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.paymentServiceConfigData = paymentServiceConfigData;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(PaymentCancelledEvent domainEvent) {
        String bookingId = domainEvent.getPayment().getBookingId().getValue().toString();
        try {
            PaymentResponseAvroModel paymentResponseAvroModel = paymentMessagingDataMapper.paymentCancelledEventToPaymentResponseAvroModel(domainEvent);
            kafkaProducer.send(paymentServiceConfigData.getPaymentResponseTopicName(), bookingId, paymentResponseAvroModel, kafkaMessageHelper.getKafkaCallback(paymentServiceConfigData.getPaymentResponseTopicName(), paymentResponseAvroModel, bookingId, "PaymentResponseAvroModel"));
            log.info("PaymentResponseAvroModel sent to kafka for booking id: {}", bookingId);
        } catch (Exception e) {
            log.error("Error while sending PaymentResponseAvroModel message" + " to kafka with booking id: {}, error: {}", bookingId, e.getMessage());
        }
    }
}
