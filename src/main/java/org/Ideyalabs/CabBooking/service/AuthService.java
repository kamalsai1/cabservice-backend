package org.Ideyalabs.CabBooking.service;

import org.Ideyalabs.CabBooking.dto.JwtRequestDto;
import org.Ideyalabs.CabBooking.dto.JwtResponseDto;
import org.Ideyalabs.CabBooking.dto.UserDTO;

public interface AuthService {

    public UserDTO createUser(UserDTO userDto);

    JwtResponseDto login(JwtRequestDto request);
}
