package org.Ideyalabs.CabBooking.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.Ideyalabs.CabBooking.dto.BookingDTO;
import org.Ideyalabs.CabBooking.repository.BookingRepository;
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
    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO) {
        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        return modelMapper.map(bookingRepository.save(booking), BookingDTO.class);
    }
}
