package com.onboard.cinema.book.show.booking.service.messaging.listener.kafka;

import com.onboard.cinema.book.show.booking.service.messaging.mapper.BookingMessagingDataMapper;
import com.onboard.cinema.book.show.booking.service.ports.input.message.listener.cineamaapproval.CinemaApprovalResponseMessageListener;
import com.onboard.cinema.book.show.common.valueobject.BookingApprovalStatus;
import com.onboard.cinema.book.show.kafka.booking.avro.model.BookApprovalStatus;
import com.onboard.cinema.book.show.kafka.booking.avro.model.CinemaApprovalResponseAvroModel;
import com.onboard.cinema.book.show.kafka.config.consumer.KafkaConsumer;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.onboard.cinema.book.show.booking.domain.entiry.Booking.FAILURE_MESSAGE_DELIMITER;


@Slf4j
@Component
public class CinemaApprovalResponseKafkaListener implements KafkaConsumer<CinemaApprovalResponseAvroModel> {
    private final CinemaApprovalResponseMessageListener cinemaApprovalResponseMessageListener;
    private final BookingMessagingDataMapper bookingMessagingDataMapper;

    public CinemaApprovalResponseKafkaListener(CinemaApprovalResponseMessageListener cinemaApprovalResponseMessageListener,
                                               BookingMessagingDataMapper bookingMessagingDataMapper) {
        this.cinemaApprovalResponseMessageListener = cinemaApprovalResponseMessageListener;
        this.bookingMessagingDataMapper = bookingMessagingDataMapper;
    }

    @Override
    @KafkaListener(id = "${kafka-consumer-config.cinema-approval-consumer-group-id}",
            topics = "${booking-service.cinema-approval-response-topic-name}")
    public void receive(@Payload List<CinemaApprovalResponseAvroModel> messages,
                        @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<String> keys,
                        @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
                        @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
        log.info("{} number of cinema approval responses received with keys {}, partitions {} and offsets {}",
                messages.size(),
                keys.toString(),
                partitions.toString(),
                offsets.toString());

        messages.forEach(cinemaApprovalResponseAvroModel -> {
            if (BookApprovalStatus.APPROVED == cinemaApprovalResponseAvroModel.getBookApprovalStatus()) {
                log.info("Processing approved booking for booking id: {}",
                        cinemaApprovalResponseAvroModel.getBookingId());
                cinemaApprovalResponseMessageListener.bookingApproved(bookingMessagingDataMapper
                        .approvalResponseAvroModelToApprovalResponse(cinemaApprovalResponseAvroModel));
            } else if (BookApprovalStatus.REJECTED == cinemaApprovalResponseAvroModel.getBookApprovalStatus()) {
                log.info("Processing rejected booking for booking id: {}, with failure messages: {}",
                        cinemaApprovalResponseAvroModel.getBookingId(),
                        String.join(FAILURE_MESSAGE_DELIMITER,
                                cinemaApprovalResponseAvroModel.getFailureMessages()));
                cinemaApprovalResponseMessageListener.bookingRejected(bookingMessagingDataMapper
                        .approvalResponseAvroModelToApprovalResponse(cinemaApprovalResponseAvroModel));
            }
        });

    }
}

