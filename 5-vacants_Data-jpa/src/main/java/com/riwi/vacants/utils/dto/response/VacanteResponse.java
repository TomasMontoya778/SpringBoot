package com.riwi.vacants.utils.dto.response;

import com.riwi.vacants.utils.enums.StateVacant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VacanteResponse {
    private Long id;
    private String description;
    private String titulo;
    private StateVacant status;
    private CompanyToVacanteResponse empresa;
}
