package com.riwi.beautySalon.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class LoginRequest {
    @NotBlank(message = "El usuario es requerido")
    @Size(min = 8, max = 150, message = "El usuario debe tener entre 8 y 150 caracteres")
    private String userName;
    @NotBlank(message = "La password es requerida")
    @Size(min = 8, max = 150, message = "La contraseña debe tener entre 8 y 150 caracteres")
    @Pattern(regexp = "^(?=^.{10,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n" + //
                "])(?=.*[A-Z])(?=.*[a-z]).*$")
    private String password;
}
