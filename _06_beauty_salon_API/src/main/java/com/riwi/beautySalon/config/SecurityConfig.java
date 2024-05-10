package com.riwi.beautySalon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity // Activar spring security en esta clase
public class SecurityConfig {
    /* Crear rutas públicos */
    private final String [] PUBLIC_RESOURCES = {"/service/public/get", "/auth/**"};
    /*
     * @Bean Esta anotación le indica a spring boot que el objeto retornado por el metodo debe ser registrado como un bean en el contexto de spring (en la lata)
     */
    @Bean
    public org.springframework.security.web.SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(csrf -> csrf.disable())//desabilitar protección csrf -> Statelest
        .authorizeHttpRequests(authRequest -> 
        authRequest.requestMatchers(PUBLIC_RESOURCES).permitAll() //Configurar rutas publicas
        .anyRequest().authenticated()
        ).build();
    }
}
