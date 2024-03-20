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
    @PostMapping("/drivers")
    public DriverDto addDriver(@RequestBody DriverDto driverDto){
        logger.info("Creating driver for user: {} ", driverDto.getDriverName());
        return driverService.addDriver(driverDto);
    }
    @GetMapping("/drivers")
    public List<DriverDto> getAllDrivers(){
        logger.info("Retrieving all drivers");
        return driverService.getAllDrivers();
    }
    @GetMapping("/drivers/{driverId}")
    public DriverDto getDriverById(@PathVariable("driverId") int driverId){
        logger.info("Retrieving driver by id: {} ", driverId);
        return driverService.getDriverById(driverId);
    }
    @DeleteMapping("/drivers/{driverId}")
    public String deleteDriverById(@PathVariable("driverId") int driverId){
        logger.info("Deleting driver by id: {} ", driverId);
        return driverService.deleteDriverById(driverId);
    }
}
