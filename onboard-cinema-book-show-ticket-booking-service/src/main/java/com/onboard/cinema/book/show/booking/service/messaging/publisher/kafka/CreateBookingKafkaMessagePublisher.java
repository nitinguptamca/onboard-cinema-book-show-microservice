package com.onboard.cinema.book.show.booking.service.messaging.publisher.kafka;

import com.onboard.cinema.book.show.booking.domain.event.BookingCreatedEvent;
import com.onboard.cinema.book.show.booking.service.domain.config.BookServiceConfigData;
import com.onboard.cinema.book.show.booking.service.messaging.mapper.BookingMessagingDataMapper;
import com.onboard.cinema.book.show.booking.service.ports.output.message.publish.payment.BookingCreatedPaymentRequestMessagePublisher;
import com.onboard.cinema.book.show.kafka.booking.avro.model.PaymentRequestAvroModel;
import com.onboard.cinema.book.show.kafka.producer.KafkaMessageHelper;
import com.onboard.cinema.book.show.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CreateBookingKafkaMessagePublisher implements BookingCreatedPaymentRequestMessagePublisher {

    private final BookingMessagingDataMapper bookingMessagingDataMapper;
    private final BookServiceConfigData bookServiceConfigData;
    private final KafkaProducer<String, PaymentRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper kafkaMessageHelper;

    public CreateBookingKafkaMessagePublisher(BookingMessagingDataMapper bookingMessagingDataMapper,
                                              BookServiceConfigData bookServiceConfigData,
                                              KafkaProducer<String, PaymentRequestAvroModel> kafkaProducer,
                                              KafkaMessageHelper kafkaMessageHelper) {
        this.bookingMessagingDataMapper = bookingMessagingDataMapper;
        this.bookServiceConfigData = bookServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }
    @Override
    public void publish(BookingCreatedEvent bookingCreatedEvent) {
        String bookingId = bookingCreatedEvent.getBooking().getId().getValue().toString();
        log.info("Received bookingCreatedEvent for booking id: {}", bookingId);

        try {
            PaymentRequestAvroModel paymentRequestAvroModel = bookingMessagingDataMapper
                    .bookingCreatedEventToPaymentRequestAvroModel(bookingCreatedEvent);


            kafkaProducer.send(bookServiceConfigData.getPaymentRequestTopicName(),
                    bookingId,
                    paymentRequestAvroModel,
                    kafkaMessageHelper
                            .getKafkaCallback(bookServiceConfigData.getPaymentResponseTopicName(),
                                    paymentRequestAvroModel,
                                    bookingId,
                                    "PaymentRequestAvroModel"));

            log.info("PaymentRequestAvroModel sent to Kafka for booking id: {}", paymentRequestAvroModel.getBookingId());
        } catch (Exception e) {
            log.error("Error while sending PaymentRequestAvroModel message" +
                    " to kafka with booking id: {}, error: {}", bookingId, e.getMessage());
        }
    }
}
