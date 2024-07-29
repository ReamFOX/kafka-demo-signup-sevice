package ua.farion.kafkademosignupservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PlayerDto {
    @Email
    @NotBlank
    private String email;
    @Size(min = 8, max = 24)
    @NotBlank
    private String password;
}
