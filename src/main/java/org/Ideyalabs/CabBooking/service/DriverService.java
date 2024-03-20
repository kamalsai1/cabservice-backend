package org.Ideyalabs.CabBooking.service;

import org.Ideyalabs.CabBooking.dto.DriverDto;

import java.util.List;

public interface DriverService {
    public DriverDto addDriver(DriverDto driverDto);

    public List<DriverDto> getAllDrivers();

  public DriverDto getDriverById(int driverId);

   public String deleteDriverById(int driverId);
}
