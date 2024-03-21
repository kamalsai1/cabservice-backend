package org.Ideyalabs.CabBooking.repository;


import org.Ideyalabs.CabBooking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String username);
}

