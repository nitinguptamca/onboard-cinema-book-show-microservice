package com.onboard.cinema.book.show.booking.domain.entiry;

import com.onboard.cinema.book.show.booking.domain.valueobject.BookingShowId;
import com.onboard.cinema.book.show.common.entity.BaseEntity;
import com.onboard.cinema.book.show.common.valueobject.BookingId;
import com.onboard.cinema.book.show.common.valueobject.Money;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@Builder
@ToString
public class BookShow extends BaseEntity<BookingShowId> {
        private final Movie movie;
        private final Show show;
        private final int quantity;
        private final CinemaHall cinemaHall;
        private final Money price;
        private final Money subTotal;
        private BookingId bookingId;

        void initializeBookingItem(BookingId bookingId, BookingShowId bookingShowId) {
                this.bookingId = bookingId;
                super.setId(bookingShowId);
        }

        boolean isPriceValid() {
                return price.isGreaterThanZero() &&
                        price.equals(show.getPrice()) &&
                        price.multiply(quantity).equals(subTotal);
        }

}
