package org.Ideyalabs.CabBooking.repository;


import org.Ideyalabs.CabBooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

