package org.Ideyalabs.CabBooking.controller;

import jakarta.validation.Valid;
import org.Ideyalabs.CabBooking.dto.JwtRequestDto;
import org.Ideyalabs.CabBooking.dto.JwtResponseDto;
import org.Ideyalabs.CabBooking.dto.UserDTO;
import org.Ideyalabs.CabBooking.jwt.JwtHelper;
import org.Ideyalabs.CabBooking.security.UserDetailsServiceImpl;
import org.Ideyalabs.CabBooking.service.AuthService;
import org.Ideyalabs.CabBooking.service.AuthServiceImpl;
import org.Ideyalabs.CabBooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth-api/v1")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO userDto)
    {

        return new ResponseEntity<UserDTO>(authService.createUser(userDto), HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@Valid @RequestBody JwtRequestDto request) {



        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }

}