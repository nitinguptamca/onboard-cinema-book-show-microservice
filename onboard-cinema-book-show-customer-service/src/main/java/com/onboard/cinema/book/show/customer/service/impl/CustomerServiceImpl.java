package com.onboard.cinema.book.show.customer.service.impl;

import com.onboard.cinema.book.show.customer.Entity.Customers;
import com.onboard.cinema.book.show.customer.repository.CustomersRepository;
import com.onboard.cinema.book.show.customer.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomersRepository customersRepository;

    public CustomerServiceImpl(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public Customers create(Customers customers) {
        return customersRepository.save(customers);
    }
}
