package com.riwi.beautySalon.infraestructure.Helpers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.riwi.beautySalon.domain.entities.User;

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
}
