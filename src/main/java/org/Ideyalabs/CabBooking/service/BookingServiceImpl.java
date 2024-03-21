package org.Ideyalabs.CabBooking.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.Ideyalabs.CabBooking.dto.BookingDTO;
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
@AllArgsConstructor
@NoArgsConstructor
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
    public Booking bookDriver(BookingDTO booking) {
        User user = userRepository.findByUsername(booking.getUsername()).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Driver driver = driverRepository.findByDriverName(booking.getDriverName()).orElseThrow(() -> new EntityNotFoundException("Driver not found"));
        Booking booking1 = new Booking();
        booking1.setDriver(driver);
        booking1.setUser(user);
        booking1.setUsername(user.getUsername());
        booking1.setDriverName(driver.getDriverName());
        booking1.setPickUpLocation(booking.getPickUpLocation());
        booking1.setDropLocation(booking.getDropLocation());

        return bookingRepository.save(booking1);
    }
}

