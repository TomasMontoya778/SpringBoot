package com.riwi.beautySalon.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentBasicResponse {
    private Long id;
    private LocalDateTime dateTime;
    private Integer duration;
    private String comments;
    private ServiceResponse service;
    private EmployeeResponse employee;
}
