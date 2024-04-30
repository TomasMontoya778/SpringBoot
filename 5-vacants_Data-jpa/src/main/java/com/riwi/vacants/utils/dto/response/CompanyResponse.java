package com.riwi.vacants.utils.dto.response;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyResponse {
    private String id;
    private String name;
    private String locacion;
    private String contacto;
    private List<VancanteToCompanyResponse> vacantes;
}
