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
    private String driverEmail;
    private String driverPassword;
    private String driverNumber;
    @OneToOne(mappedBy = "driver")
    private Booking bookings;

    @ManyToOne
    //Many drivers are assigned to  one Manager
    // Name of the foreign key column in the Driver table
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
