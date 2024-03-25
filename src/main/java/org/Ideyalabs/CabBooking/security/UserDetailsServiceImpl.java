package org.Ideyalabs.CabBooking.security;

import org.Ideyalabs.CabBooking.exception.UserByIdDoesNotExistException;
import org.Ideyalabs.CabBooking.model.Driver;
import org.Ideyalabs.CabBooking.model.Manager;
import org.Ideyalabs.CabBooking.model.User;
import org.Ideyalabs.CabBooking.repository.DriverRepository;
import org.Ideyalabs.CabBooking.repository.ManagerRepository;
import org.Ideyalabs.CabBooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private DriverRepository driverRepository;


    @Override
    public UserDetails loadUserByUsername(String email) {

        Optional<Manager> manager = managerRepository.findByManagerEmail(email);
        if(manager.isPresent())
        {
            return new ManagerDetailsImpl(manager.get());
        }
        Optional<Driver> driver = driverRepository.findByDriverEmail(email);
        if(driver.isPresent())
        {
            return new DriverDetailsImpl(driver.get());
        }
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent())
        {
            return new UserDetailImpl(user.get());
        }

throw new UserByIdDoesNotExistException("User with this id does not exist");

    }
}