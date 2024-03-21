package org.Ideyalabs.CabBooking.service;

import org.Ideyalabs.CabBooking.dto.JwtRequestDto;
import org.Ideyalabs.CabBooking.dto.JwtResponseDto;
import org.Ideyalabs.CabBooking.dto.UserDTO;
import org.Ideyalabs.CabBooking.jwt.JwtHelper;
import org.Ideyalabs.CabBooking.model.User;
import org.Ideyalabs.CabBooking.repository.UserRepository;
import org.Ideyalabs.CabBooking.security.UserDetailsServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;

    /*
     * validating the login input parameters and creating token by setting authentication
     */

    private void doAuthenticate(String email, String password) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);
        }
        catch (BadCredentialsException e) {
            throw new BadCredentialsException("Invalid Username or Password Provided!!");
        }
    }

    public JwtResponseDto login(JwtRequestDto request) {
        doAuthenticate(request.getEmail(), request.getPassword());

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);
        String username = userDetails.getUsername();
        return  JwtResponseDto.builder()
                .jwtToken(token)
                .email(username).build();

    }

    public UserDTO createUser(UserDTO userDto)
    {
        User user = modelMapper.map(userDto,User.class);

        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));


        return modelMapper.map(userRepository.save(user), UserDTO.class);
    }


}
