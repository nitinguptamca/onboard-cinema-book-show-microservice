package com.onboard.cinema.book.show.booking.service.ports.input.message.listener.cineamaapproval;

import com.onboard.cinema.book.show.booking.service.domain.dto.message.CinemaApprovalResponse;

public interface CinemaApprovalResponseMessageListener {
    void bookingApproved(CinemaApprovalResponse cinemaApprovalResponse);
    void bookingRejected(CinemaApprovalResponse cinemaApprovalResponse);
}
