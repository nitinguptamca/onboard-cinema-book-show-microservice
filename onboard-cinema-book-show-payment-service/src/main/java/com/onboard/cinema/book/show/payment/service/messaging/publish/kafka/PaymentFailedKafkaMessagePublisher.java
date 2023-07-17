package com.onboard.cinema.book.show.payment.service.messaging.publish.kafka;


import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentResponseAvroModel;
import com.onboard.cinema.book.show.kafka.producer.KafkaMessageHelper;
import com.onboard.cinema.book.show.kafka.producer.service.KafkaProducer;
import com.onboard.cinema.book.show.payment.domain.config.PaymentServiceConfigData;
import com.onboard.cinema.book.show.payment.domain.ports.output.message.publisher.PaymentFailedMessagePublisher;
import com.onboard.cinema.book.show.payment.service.domain.event.PaymentFailedEvent;
import com.onboard.cinema.book.show.payment.service.messaging.listener.mapper.PaymentMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentFailedKafkaMessagePublisher implements PaymentFailedMessagePublisher {

    private final PaymentMessagingDataMapper paymentMessagingDataMapper;
    private final KafkaProducer<String, PaymentResponseAvroModel> kafkaProducer;
    private final PaymentServiceConfigData paymentServiceConfigData;
    private final KafkaMessageHelper kafkaMessageHelper;

    public PaymentFailedKafkaMessagePublisher(PaymentMessagingDataMapper paymentMessagingDataMapper,
                                              KafkaProducer<String, PaymentResponseAvroModel> kafkaProducer,
                                              PaymentServiceConfigData paymentServiceConfigData,
                                              KafkaMessageHelper kafkaMessageHelper) {
        this.paymentMessagingDataMapper = paymentMessagingDataMapper;
        this.kafkaProducer = kafkaProducer;
        this.paymentServiceConfigData = paymentServiceConfigData;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(PaymentFailedEvent domainEvent) {
        String bookingId = domainEvent.getPayment().getBookingId().getValue().toString();

        log.info("Received PaymentFailedEvent for order id: {}", bookingId);

        try {
            PaymentResponseAvroModel paymentResponseAvroModel =
                    paymentMessagingDataMapper.paymentFailedEventToPaymentResponseAvroModel(domainEvent);

            kafkaProducer.send(paymentServiceConfigData.getPaymentResponseTopicName(),
                    bookingId,
                    paymentResponseAvroModel,
                    kafkaMessageHelper.getKafkaCallback(paymentServiceConfigData.getPaymentResponseTopicName(),
                            paymentResponseAvroModel,
                            bookingId,
                            "PaymentResponseAvroModel"));

            log.info("PaymentResponseAvroModel sent to kafka for order id: {}", bookingId);
        } catch (Exception e) {
            log.error("Error while sending PaymentResponseAvroModel message" +
                    " to kafka with order id: {}, error: {}", bookingId, e.getMessage());
        }
    }
}
