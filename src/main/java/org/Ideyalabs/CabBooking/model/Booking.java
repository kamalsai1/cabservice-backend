package org.Ideyalabs.CabBooking.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;

public class Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    @OneToOne(targetEntity = User.class)
    private String customerName;
    @OneToOne(targetEntity = Driver.class)
    private String driverName;
}
