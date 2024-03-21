package org.Ideyalabs.CabBooking.security;

import org.Ideyalabs.CabBooking.exception.UserByIdDoesNotExistException;
import org.Ideyalabs.CabBooking.model.User;
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


    @Override
    public UserDetails loadUserByUsername(String username) {

        Optional<User> user = userRepository.findByEmail(username);
        if(user.isEmpty())
        {
            throw new UserByIdDoesNotExistException("no such user exists");
        }


        return new UserDetailImpl(user.get());
    }
}