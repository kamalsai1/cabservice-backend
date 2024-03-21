package org.Ideyalabs.CabBooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    @NotBlank(message = "Driver Name cannot be empty")
    private String driverName;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message = "Invalid passsword")
    private String driverPassword;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}(?:\\.[\\p{L}]{2,})?$",message = "Invalid Email")
    private String driverEmail;
    @Pattern(regexp = "^[6-9]{2}[0-9]{8}$" ,message = "Phone number is Invalid")
    private String driverNumber;
}
