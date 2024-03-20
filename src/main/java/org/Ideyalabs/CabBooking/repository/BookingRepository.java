package org.Ideyalabs.CabBooking.repository;

import org.Ideyalabs.CabBooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long>{
}
