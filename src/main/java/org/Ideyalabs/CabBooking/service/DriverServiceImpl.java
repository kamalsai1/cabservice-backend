package org.Ideyalabs.CabBooking.service;

import lombok.SneakyThrows;
import org.Ideyalabs.CabBooking.dto.DriverDto;
import org.Ideyalabs.CabBooking.exception.CustomerByIdDoesNotExistException;
import org.Ideyalabs.CabBooking.model.Driver;
import org.Ideyalabs.CabBooking.repository.DriverRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class DriverServiceImpl implements DriverService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DriverRepository driverRepository;
    @Override
    public DriverDto addCustomer(DriverDto driverDto) {
        Driver driver = modelMapper.map(driverDto, Driver.class);
        return modelMapper.map(driverRepository.save(driver), DriverDto.class);
    }

    @Override
    public List<DriverDto> getAllCustomers() {
         List<DriverDto> customerList = driverRepository.findAll()
                .stream().map(e->modelMapper.map(e, DriverDto.class)).collect(Collectors.toList());
        return customerList;
    }

    @SneakyThrows
    @Override
    public DriverDto getCustomerById(int customerId) {
        Optional<Driver> customerOptional = driverRepository.findById(customerId);
        if(customerOptional.isEmpty()){
            throw new CustomerByIdDoesNotExistException("Customer id not found");
        }
        return modelMapper.map(customerOptional.get(), DriverDto.class);
    }

    @Override
    public String deleteCustomerById(int customerId) {
        boolean DeleteUser = driverRepository.existsById(customerId);
        if(DeleteUser){
            driverRepository.deleteById(customerId);
            return "User id " + customerId + " deleted successfully";
        }
        return "User  id"+" "+customerId+" does not exists in the db";
    }
}
