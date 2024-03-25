package org.Ideyalabs.CabBooking.service;

import org.Ideyalabs.CabBooking.dto.*;

public interface AuthService {

    public UserDTO createUser(UserDTO userDto);

    public ManagerDto addManager(ManagerDto managerDto);

    JwtResponseDto login(JwtRequestDto request);

    DriverDto addDriver(DriverDto driverDto);
}
