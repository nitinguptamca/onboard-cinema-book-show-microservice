package com.onboard.cinema.book.show.cinema.rest;

import com.onboard.cinema.book.show.cinema.entity.Payment;
import com.onboard.cinema.book.show.cinema.repository.PaymentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/payment")
@RestController
public class PaymentController {
    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PostMapping
    public ResponseEntity<Payment> create(@Valid @RequestBody Payment payment){
        Payment payment1 = paymentRepository.save(payment);
        return  new ResponseEntity<>(payment1, HttpStatus.CREATED);
    }
}
