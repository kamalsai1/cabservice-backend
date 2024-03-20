package org.Ideyalabs.CabBooking.service;

import org.Ideyalabs.CabBooking.dto.BookingDTO;
import org.Ideyalabs.CabBooking.repository.BookingRepository;

public interface BookingService {
    BookingDTO createBooking(BookingDTO bookingDTO);
}
