package org.Ideyalabs.CabBooking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    @OneToOne(targetEntity = User.class)
    private String customerName;
    @OneToOne(targetEntity = Driver.class)
    private String driverName;
}
