package com.riwi.vacants.utils.dto.request;

import com.riwi.vacants.utils.enums.StateVacant;

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
public class VacanteRequest {
    @NotBlank(message = "La descripción es requerido")
    private String description;
    @NotBlank(message = "El título es requerido")
    private String titulo;
    private StateVacant status;
    @Size(max = 36, min = 0)
    @NotBlank(message = "El id de la empresa es requerido.")
    private String company_id;
}
