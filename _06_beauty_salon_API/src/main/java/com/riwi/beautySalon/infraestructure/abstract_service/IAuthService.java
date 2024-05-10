package com.riwi.beautySalon.infraestructure.abstract_service;

import com.riwi.beautySalon.api.dto.request.LoginRequest;
import com.riwi.beautySalon.api.dto.request.RegisterRequest;
import com.riwi.beautySalon.api.dto.response.AuthResponse;

public interface IAuthService{
    public AuthResponse login(LoginRequest logRequest);
    public AuthResponse register(RegisterRequest regRequest);
}
