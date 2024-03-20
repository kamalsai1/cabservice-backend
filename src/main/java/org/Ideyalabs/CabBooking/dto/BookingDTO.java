package org.Ideyalabs.CabBooking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDTO {
    @NotEmpty(message = "Customer Name cannot be empty")
    private String userName;
    @NotEmpty(message = "Driver Name cannot be empty")
    private String driverName;
    @NotBlank(message = "Source cannot be null")
    private String source;
    @NotBlank(message = "Destination cannot be null")
    private String destination;
}
