package org.Ideyalabs.CabBooking.service;

import org.Ideyalabs.CabBooking.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    public CustomerDto addCustomer(CustomerDto customerDto);

    public List<CustomerDto> getAllCustomers();

  public   CustomerDto getCustomerById(int customerId);

   public String deleteCustomerById(int customerId);
}
