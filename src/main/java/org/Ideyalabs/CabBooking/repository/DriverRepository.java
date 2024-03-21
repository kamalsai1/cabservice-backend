package org.Ideyalabs.CabBooking.repository;

import org.Ideyalabs.CabBooking.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Integer> {

    Optional<Driver> findByDriverName(String driverName);
}
