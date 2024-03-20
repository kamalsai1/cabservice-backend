package org.Ideyalabs.CabBooking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String customerName;
    private String CustomerPassword;
    private String CustomerEmail;
    private String customerNumber;
}
