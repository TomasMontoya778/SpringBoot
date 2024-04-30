package com.riwi.vacants.utils.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder //Patrón de diseño para creación de clases
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    @Size(min = 0, max = 40, message = "El nombre supera la cantidad de caracteres permitidos")
    @NotBlank(message = "El nombre de la empresa es requerido.")
    private String name;
    @NotBlank(message = "La locación de la empresa es requerido.")
    private String locacion;
    @Size(min = 0, max = 12, message = "El contacto supera la cantidad de caracteres permitidos")
    @NotBlank(message = "El contacto de la empresa es requerido.")
    private String contacto;

}
