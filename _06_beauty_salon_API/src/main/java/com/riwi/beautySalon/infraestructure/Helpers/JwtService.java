package com.riwi.beautySalon.infraestructure.Helpers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.riwi.beautySalon.domain.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService {
    /* 1. Crear la firma o clave */
    private final String SECRECT_KEY = "bWkgc3VwZXIgY2xhdmUgc2VjcmV0YSBtYXMgc2VjcmV0YSBxdWUgbGEgc2VjcmV0YSwgbWkgc3VwZXIgY2xhdmUgc2VjcmV0YSBtYXMgc2VjcmV0YSBxdWUgbGEgc2VjcmV0YQ==";

    /* Metodo para encriptar la clave secreta */
    public SecretKey getKey(){
        // Convertir la llave a bytes
        byte[] keyBytes = Decoders.BASE64.decode(SECRECT_KEY);
        // retornar clave cifrada
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String getToken(Map<String, Object> claims, User User){
        return Jwts.builder().claims(claims)// Sgrego el cuerpo del jwt
        .subject(User.getUsername()) // seteo de quien es el token
        .issuedAt(new Date(System.currentTimeMillis())) // guardar la fecha de creación
        .expiration(new Date(System.currentTimeMillis()+ 1000 * 60 * 60 * 24))// duración del token
        .signWith(this.getKey())
        .compact();
    }

    // crear el metodo para obtener el jwt
    public String getToken(User user){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("role", user.getRole().name());
        return getToken(claims, user);
    }

    /* Desestructurar el jwt para obtener todos los claims */

    public Claims getAllClaims(String token){
        return Jwts
        .parser() // Desarmar el jwt
        .verifyWith(this.getKey()) // Validamos que sea la misma firma con
        .build(). // Lo construimos de nuevo
        parseSignedClaims(token) // Convertimos el token a base 10 - base 64
        .getPayload(); // Extraemos el payload (claims)
    }
    // método para obtener un claim específico
    public <T> T getCLaims (String token, Function<Claims, T> claimsResolver){
        // Obtener los claims
        final Claims claims = this.getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // método para obtener el subject del jwt
    public String getUserNameForToken(String token){
        return this.getCLaims(token, Claims::getSubject);
    }

    //método para obtener la fecha de expiración
    public Date getExpiration(String token){
        return this.getCLaims(token, Claims::getExpiration);
    }
    // método para validar si el token está expirado
    public boolean isTokenExpired(String token){
        return this.getExpiration(token).before(new Date());
    }
    // método para validar si el token es valido
    public boolean isTokenValid(String token, UserDetails user){
        String userName = this.getUserNameForToken(token);
        return userName.equals(user.getUsername()) && !this.isTokenExpired(token);
    }
}   
