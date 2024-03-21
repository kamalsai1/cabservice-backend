package org.Ideyalabs.CabBooking.service;

import jakarta.persistence.EntityNotFoundException;
import org.Ideyalabs.CabBooking.model.Driver;
import org.Ideyalabs.CabBooking.model.User;
import org.Ideyalabs.CabBooking.repository.BookingRepository;
import org.Ideyalabs.CabBooking.repository.DriverRepository;
import org.Ideyalabs.CabBooking.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.Ideyalabs.CabBooking.model.Booking;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DriverRepository driverRepository;
//    @Override
//    public BookingDTO createBooking(BookingDTO bookingDTO) {
//        Booking booking = modelMapper.map(bookingDTO, Booking.class);
//        return modelMapper.map(bookingRepository.save(booking), BookingDTO.class);
//    }

    @Override
    public Booking bookDriver(int userid, int driverId) {
        User user = userRepository.findById(userid).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Driver driver = driverRepository.findById(driverId).orElseThrow(() -> new EntityNotFoundException("Driver not found"));
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setDriver(driver);
        booking.setUserName(booking.getUserName());
        booking.setPickUpLocation(booking.getPickUpLocation());
        booking.setDropLocation(booking.getDropLocation());

        return bookingRepository.save(booking);
    }
}

