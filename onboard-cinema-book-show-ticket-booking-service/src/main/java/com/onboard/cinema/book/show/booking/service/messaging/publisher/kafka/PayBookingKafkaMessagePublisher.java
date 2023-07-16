package com.onboard.cinema.book.show.booking.service.messaging.publisher.kafka;

import com.onboard.cinema.book.show.booking.domain.event.BookingPaidEvent;
import com.onboard.cinema.book.show.booking.service.domain.config.BookServiceConfigData;
import com.onboard.cinema.book.show.booking.service.messaging.mapper.BookingMessagingDataMapper;
import com.onboard.cinema.book.show.booking.service.ports.output.message.publish.cinemaapproval.BookingPaidCinemaRequestMessagePublisher;
import com.onboard.cinema.book.show.kafka.booking.avro.model.CinemaApprovalRequestAvroModel;
import com.onboard.cinema.book.show.kafka.producer.KafkaMessageHelper;
import com.onboard.cinema.book.show.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PayBookingKafkaMessagePublisher implements BookingPaidCinemaRequestMessagePublisher{
    private final BookingMessagingDataMapper bookingMessagingDataMapper;
    private final BookServiceConfigData bookServiceConfigData;
    private final KafkaProducer<String, CinemaApprovalRequestAvroModel> kafkaProducer;
    private final KafkaMessageHelper kafkaMessageHelper;

    public PayBookingKafkaMessagePublisher(BookingMessagingDataMapper bookingMessagingDataMapper,
                                           BookServiceConfigData bookServiceConfigData,
                                           KafkaProducer<String, CinemaApprovalRequestAvroModel> kafkaProducer,
                                           KafkaMessageHelper kafkaMessageHelper) {
        this.bookingMessagingDataMapper = bookingMessagingDataMapper;
        this.bookServiceConfigData = bookServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(BookingPaidEvent domainEvent) {
        String bookingId = domainEvent.getBooking().getId().getValue().toString();
        log.info("Received bookingCreatedEvent for booking id: {}", bookingId);
        try{
                CinemaApprovalRequestAvroModel cinemaApprovalRequestAvroModel=
                        bookingMessagingDataMapper.bookingPaidEventToCinemaApprovalRequestAvroModel(domainEvent);

                kafkaProducer.send(
                        bookServiceConfigData.getCinemaApprovalRequestTopicName(),
                        bookingId,
                        cinemaApprovalRequestAvroModel,
                        kafkaMessageHelper.getKafkaCallback(
                                bookServiceConfigData.getCinemaApprovalRequestTopicName(),
                                cinemaApprovalRequestAvroModel,
                                bookingId,
                                "CinemaApprovalRequestAvroModel"
                        ));
            log.info("RestaurantApprovalRequestAvroModel sent to kafka for booking id: {}", bookingId);
        }catch (Exception e) {
            log.error("Error while sending CinemaApprovalRequestAvroModel message" +
                    " to kafka with booking id: {}, error: {}", bookingId, e.getMessage());
        }

    }
}
