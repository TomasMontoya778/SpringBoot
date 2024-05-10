package com.riwi.beautySalon.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    @NotBlank(message = "El usuario es requerido")
    @Size(min = 8, max = 150, message = "El usuario debe tener entre 8 y 150 caracteres")
    private String userName;
    @NotBlank(message = "La password es requerida")
    @Size(min = 8, max = 150, message = "La contraseña debe tener entre 8 y 150 caracteres")
    private String password;
}
