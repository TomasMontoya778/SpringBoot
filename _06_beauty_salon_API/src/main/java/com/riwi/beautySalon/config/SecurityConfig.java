package com.riwi.beautySalon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.riwi.beautySalon.infraestructure.Helpers.JwtFIlter;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity // Activar spring security en esta clase
@AllArgsConstructor 
public class SecurityConfig {
    @Autowired
    private final AuthenticationProvider authenticationProvider;
    @Autowired
    private final JwtFIlter jwtFilter;
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
        ).sessionManagement(sessionManager -> sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
        .build();
    }
}
