package org.Ideyalabs.CabBooking.service;

import org.Ideyalabs.CabBooking.dto.DriverDto;

import java.util.List;

public interface DriverService {
    public DriverDto addCustomer(DriverDto driverDto);

    public List<DriverDto> getAllCustomers();

  public DriverDto getCustomerById(int customerId);

   public String deleteCustomerById(int customerId);
}
