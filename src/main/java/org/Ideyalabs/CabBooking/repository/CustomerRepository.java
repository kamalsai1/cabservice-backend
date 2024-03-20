package org.Ideyalabs.CabBooking.repository;

import org.Ideyalabs.CabBooking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
