package org.Ideyalabs.CabBooking.controller;

import org.Ideyalabs.CabBooking.dto.CustomerDto;
import org.Ideyalabs.CabBooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/customers")
    public CustomerDto addCustomer(CustomerDto customerDto){
        return customerService.addCustomer(customerDto);
    }
    @GetMapping("/customers")
    public List<CustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/customers/{customerId}")
    public CustomerDto getCustomerById(@PathVariable("customerId") int customerId){
        return customerService.getCustomerById(customerId);
    }
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomerById(@PathVariable("customerId") int customerId){
        return customerService.deleteCustomerById(customerId);
    }
}
