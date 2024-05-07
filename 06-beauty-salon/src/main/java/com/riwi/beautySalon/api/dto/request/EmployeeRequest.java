package com.riwi.beautySalon.api.dto.request;

import com.riwi.beautySalon.utils.enums.RoleEnum;

import jakarta.validation.constraints.Email;
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
public class EmployeeRequest {
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 1, max = 100)
    private String firstName;
    @NotBlank(message = "El apellido es requerido")
    @Size(min = 1, max = 100)
    private String lastName;
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$")
    @Size(min = 1, max = 100)
    private String email;
    @Size(min = 1, max = 20)
    private String phoneNumber;
    @NotBlank(message = "El rol es requerido")
    private RoleEnum role;
}
