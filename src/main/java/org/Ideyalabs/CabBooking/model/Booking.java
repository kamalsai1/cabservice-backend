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
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private String username;
    private String driverName;
    private String pickUpLocation;
    private String dropLocation;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

}


/*

// User entity
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
// Other user fields
@OneToMany(mappedBy = "user")
private List<Booking> bookings;
// Getters and setters
}
// Driver entity
@Entity
public class Driver {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
// Other driver fields
@OneToMany(mappedBy = "driver")
private List<Booking> bookings;
// Getters and setters
}
// Booking entity
@Entity
public class Booking {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@ManyToOne
@JoinColumn(name = "user_id")
private User user;
@ManyToOne
@JoinColumn(name = "driver_id")
private Driver driver;
// Other booking fields, e.g., date, time, status
// Getters and setters
}
// UserRepository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
// Add custom methods if needed
}
// DriverRepository
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
// Add custom methods if needed
}
// BookingService
@Service
public class BookingService {
@Autowired
private UserRepository userRepository;
@Autowired
private DriverRepository driverRepository;
// Method to book a driver for a user
public void bookDriver(Long userId, Long driverId) {
User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
Driver driver = driverRepository.findById(driverId).orElseThrow(() -> new EntityNotFoundException("Driver not found"));
Booking booking = new Booking();
booking.setUser(user);
booking.setDriver(driver);
// Set other booking details
// Save booking
// You can also implement checks for availability, conflicts, etc., before saving
// Save booking to database
// bookingRepository.save(booking);
}
}
// BookingController
@RestController
@RequestMapping("/bookings")
public class BookingController {
@Autowired
private BookingService bookingService;
@PostMapping("/book")
public ResponseEntity<String> bookDriver(@RequestParam Long userId, @RequestParam Long driverId) {
bookingService.bookDriver(userId, driverId);
return ResponseEntity.ok("Booking successful");
}
}

 */
