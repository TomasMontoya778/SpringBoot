package com.riwi.vacants.utils.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder //Patrón de diseño para creación de clases
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequest {
    private String name;
    private String locacion;
    private String contacto;

}
