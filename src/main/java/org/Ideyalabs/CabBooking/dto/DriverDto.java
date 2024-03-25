package org.Ideyalabs.CabBooking.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    @NotBlank(message = "Driver Name cannot be empty")
    private String driverName;
    @NotBlank(message = "Email is mandatory")
    private String driverEmail;
    @NotBlank(message = "Password is mandatory")
    private String driverPassword;
    @NotBlank(message = "Phone number is mandatory")
    private String driverNumber;
}
