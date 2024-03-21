package org.Ideyalabs.CabBooking.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtRequestDto {
    @NotEmpty(message="must not be null or empty")
    private String email;
    @NotEmpty(message="must not be null or empty")
    private String password;
}

