package com.onboard.cinema.book.show.customer.repository;

import com.onboard.cinema.book.show.customer.Entity.Customers;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers , UUID> {
}
