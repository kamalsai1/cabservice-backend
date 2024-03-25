package org.Ideyalabs.CabBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDto {
    private  String managerName;
    private String managerEmail;
    private String managerPhone;
    private String managerPassword;

}
