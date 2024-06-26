package org.Ideyalabs.CabBooking.repository;

import org.Ideyalabs.CabBooking.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager ,Integer> {


    Optional<Manager> findByManagerEmail(String email);
}
