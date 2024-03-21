package org.Ideyalabs.CabBooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
    @NotEmpty(message = "Customer Name cannot be empty")
    private String username;
    private String driverName;
    @NotEmpty(message = "Driver Name cannot be empty")
    private String pickUpLocation;
    @NotBlank(message = "Destination cannot be null")
    private String dropLocation;
}
