package org.Ideyalabs.CabBooking.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.Ideyalabs.CabBooking.dto.BookingDTO;
import org.Ideyalabs.CabBooking.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booking-api/v1")
public class BookingController {
    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
    @Autowired
    private BookingService bookingService;

//    @PostMapping("/bookings")
//    public BookingDTO createBooking(@RequestBody BookingDTO bookingDTO){
//        logger.info("Creating booking for user: {} ", bookingDTO.getUserName());
//        return bookingService.createBooking(bookingDTO);
//    }
    @PostMapping("/book")
    public ResponseEntity<String> bookDriver(@RequestBody BookingDTO booking) {
        bookingService.bookDriver(booking);
        return ResponseEntity.ok("Booking successful");
    }
}
