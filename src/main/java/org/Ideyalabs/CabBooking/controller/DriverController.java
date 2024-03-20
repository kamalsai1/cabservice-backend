package org.Ideyalabs.CabBooking.controller;

import org.Ideyalabs.CabBooking.dto.DriverDto;
import org.Ideyalabs.CabBooking.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    @Autowired
    private DriverService driverService;
    @PostMapping("/customers")
    public DriverDto addCustomer(@RequestBody DriverDto driverDto){
        logger.info("Creating driver for user: {} ", driverDto.getDriverName());
        return driverService.addCustomer(driverDto);
    }
    @GetMapping("/customers")
    public List<DriverDto> getAllCustomers(){
        logger.info("Retrieving all drivers");
        return driverService.getAllCustomers();
    }
    @GetMapping("/customers/{customerId}")
    public DriverDto getCustomerById(@PathVariable("driverId") int driverId){
        logger.info("Retrieving driver by id: {} ", driverId);
        return driverService.getCustomerById(driverId);
    }
    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomerById(@PathVariable("driverId") int driverId){
        logger.info("Deleting driver by id: {} ", driverId);
        return driverService.deleteCustomerById(driverId);
    }
}
