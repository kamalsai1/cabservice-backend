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
    public DriverDto addDriver(DriverDto driverDto) {
        Driver driver = modelMapper.map(driverDto, Driver.class);
        return modelMapper.map(driverRepository.save(driver), DriverDto.class);
    }

    @Override
    public List<DriverDto> getAllDrivers() {
         List<DriverDto> driverDtoList = driverRepository.findAll()
                .stream().map(e->modelMapper.map(e, DriverDto.class)).collect(Collectors.toList());
        return driverDtoList;
    }

    @SneakyThrows
    @Override
    public DriverDto getDriverById(int driverId) {
        Optional<Driver> driverOptional = driverRepository.findById(driverId);
        if(driverOptional.isEmpty()){
            throw new CustomerByIdDoesNotExistException("Customer id not found");
        }
        return modelMapper.map(driverOptional.get(), DriverDto.class);
    }

    @Override
    public String deleteDriverById(int driverId) {
        boolean DeleteUser = driverRepository.existsById(driverId);
        if(DeleteUser){
            driverRepository.deleteById(driverId);
            return "User id " + driverId + " deleted successfully";
        }
        return "User  id"+" "+driverId+" does not exists in the db";
    }
}
