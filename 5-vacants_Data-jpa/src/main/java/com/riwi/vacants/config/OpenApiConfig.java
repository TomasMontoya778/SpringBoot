package com.riwi.vacants.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.context.annotation.Configuration;
// Para configurar beans dentro de spring
@Configuration
@OpenAPIDefinition(
 info = @Info(
    title = "Api para administración de vacantes y empresas",
    description = "se basa en poder agregar, eliminar, editar o listar una empresa y así mismo poder asignarle una vacante",
    version = "1.0"
 )
)
public class OpenApiConfig {

}
