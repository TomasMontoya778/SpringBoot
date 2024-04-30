package com.riwi.vacants.utils.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyToVacanteResponse {
    private String id;
    private String name;
    private String locacion;
    private String contacto;
}
