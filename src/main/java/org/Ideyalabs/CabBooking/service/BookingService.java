package org.Ideyalabs.CabBooking.service;

import org.Ideyalabs.CabBooking.model.Booking;

public interface BookingService {
//    public  BookingDTO createBooking(BookingDTO bookingDTO);
public Booking bookDriver(int userid, int driverId);
}
