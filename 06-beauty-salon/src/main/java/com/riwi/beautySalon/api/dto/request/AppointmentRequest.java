package com.riwi.beautySalon.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentRequest {
    @FutureOrPresent
    @NotBlank(message = "La Fecha y la hora de la cita es requerida")
    private LocalDateTime dateTime;
    @NotNull(message = "La duración de la cita es requerida")
    @Min(value = 5)
    @Max(value = 760)
    private Integer duration;
    private String comments;
    @NotBlank(message = "El ID del cliente es requerida")
    private Long client;
    @NotBlank(message = "El ID del servicio es requerida")
    private Long service;
    @NotBlank(message = "El ID del empleado es requerida")
    private Long employee;
}
