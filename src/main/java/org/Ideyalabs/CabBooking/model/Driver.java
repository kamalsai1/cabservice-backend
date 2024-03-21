package org.Ideyalabs.CabBooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverId;
    private String driverName;
    private String driverPassword;
    private String driverEmail;
    private String driverNumber;
    @OneToMany(mappedBy = "driver")
    private List<Booking> bookings;
}
