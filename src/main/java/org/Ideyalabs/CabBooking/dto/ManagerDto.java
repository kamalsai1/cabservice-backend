package org.Ideyalabs.CabBooking.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDto {
    @NotEmpty(message = "Manager name cannot be empty")
    private  String managerName;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",message = "Invalid passsword")
    private String managerEmail;
    @Pattern(regexp = "^[6-9]{2}[0-9]{8}$" ,message = "Phone number is Invalid")
    private String managerPhone;
    private String managerPassword;

}

