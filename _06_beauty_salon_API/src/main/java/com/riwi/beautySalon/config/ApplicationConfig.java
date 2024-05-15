package com.riwi.beautySalon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.riwi.beautySalon.domain.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class ApplicationConfig {
    /* Se inyecta el repositorio del usuario para hacer el manejo de la base de datos.*/
    @Autowired
    private final UserRepository userRepository;


    /* AuthenticationManager permine el manejo del usuario en toda la app
     * Define un bean de tipo AuthenticationManager y utiliza configuración por defecto de spring security.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
    /* Define una configuración para password encoder
     * este encoder es utilizado para cifrar y decifrar las contraseñas
     * retorna una instancia de tipo cifrado.
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /* Este servicio es utilizado por spring security para cargar detalles del usuario durante la autenticación. */
    @Bean
    public UserDetailsService userDetailsService(){
        return username -> this.userRepository.findByusername(username).orElseThrow(()-> new UsernameNotFoundException("El usuario no fue encontrado"));
    }
    /* configuramos el provider con un DaoProvider que es implementación que tiene como finalidad proveer la información del usuario a la app.*/
    @Bean
    public AuthenticationProvider authenticationProvider(){
        var authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setPasswordEncoder(this.passwordEncoder());
        authenticationProvider.setUserDetailsService(this.userDetailsService());

        return authenticationProvider;
    }


}
