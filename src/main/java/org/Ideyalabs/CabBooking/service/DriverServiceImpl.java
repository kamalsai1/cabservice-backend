package org.Ideyalabs.CabBooking.service;

import lombok.SneakyThrows;
import org.Ideyalabs.CabBooking.dto.CustomerDto;
import org.Ideyalabs.CabBooking.dto.UserDTO;
import org.Ideyalabs.CabBooking.exception.CustomerByIdDoesNotExistException;
import org.Ideyalabs.CabBooking.exception.UserByIdDoesNotExistException;
import org.Ideyalabs.CabBooking.model.Customer;
import org.Ideyalabs.CabBooking.model.User;
import org.Ideyalabs.CabBooking.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return modelMapper.map(customerRepository.save(customer), CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
         List<CustomerDto> customerList = customerRepository.findAll()
                .stream().map(e->modelMapper.map(e,CustomerDto.class)).collect(Collectors.toList());
        return customerList;
    }

    @SneakyThrows
    @Override
    public CustomerDto getCustomerById(int customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if(customerOptional.isEmpty()){
            throw new CustomerByIdDoesNotExistException("Customer id not found");
        }
        return modelMapper.map(customerOptional.get(), CustomerDto.class);
    }

    @Override
    public String deleteCustomerById(int customerId) {
        boolean DeleteUser = customerRepository.existsById(customerId);
        if(DeleteUser){
            customerRepository.deleteById(customerId);
            return "User id " + customerId + " deleted successfully";
        }
        return "User  id"+" "+customerId+" does not exists in the db";
    }
}
