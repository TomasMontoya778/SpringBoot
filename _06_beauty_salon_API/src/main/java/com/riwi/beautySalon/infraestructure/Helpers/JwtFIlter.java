package com.riwi.beautySalon.infraestructure.Helpers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
@Component
@AllArgsConstructor
public class JwtFIlter extends OncePerRequestFilter{

    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // 1. Obtener el token por request
        String token = this.getFromRequest(request);
        //2. Si el token nulo entonces que siga con los filtros de spring security
        if(token == null){
            filterChain.doFilter(request, response);
            return;
        }
        //3. Sacar el username del token SUB
        String userName = this.jwtService.getUserNameForToken(token);
        // 4. Si no lo encuentra en el contexto de spring
        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // 5. Obtener la información del usuario
            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
            // 6. si el token es valido 
            if (this.jwtService.isTokenValid(token, userDetails)) {
                // 7. creamos la autenticación y la registramos en el contexto de spring
                var authToken = new UsernamePasswordAuthenticationToken(userName,null, userDetails.getAuthorities());
                /*
                 * setDetails Establece detalles adicionales de la autenticación, como la dirección ip y la sesión de donde es realizada la solicitud.
                 */
                authToken.setDetails(new WebAuthenticationDetails(request));
                /* GUARDAR LA AUTENTICACIÓN EN EL CONTEXTO DE SPRING BOOT */
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }

    public String getFromRequest(HttpServletRequest request){
        final String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(StringUtils.hasText(token) && token.startsWith("Bearer")){
            return token.substring(7);
        }
        return null;
    }
}
