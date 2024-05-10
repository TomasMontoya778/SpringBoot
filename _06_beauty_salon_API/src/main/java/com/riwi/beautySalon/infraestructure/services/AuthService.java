package com.riwi.beautySalon.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riwi.beautySalon.api.dto.request.LoginRequest;
import com.riwi.beautySalon.api.dto.request.RegisterRequest;
import com.riwi.beautySalon.api.dto.response.AuthResponse;
import com.riwi.beautySalon.domain.entities.User;
import com.riwi.beautySalon.domain.repositories.UserRepository;
import com.riwi.beautySalon.infraestructure.Helpers.JwtService;
import com.riwi.beautySalon.infraestructure.abstract_service.IAuthService;
import com.riwi.beautySalon.utils.enums.RoleEnum;
import com.riwi.beautySalon.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class AuthService implements IAuthService{
    @Autowired
    private final UserRepository objUserRepository;
    @Autowired
    private final JwtService obJwtService;
    @Override
    public AuthResponse login(LoginRequest logRequest) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public AuthResponse register(RegisterRequest regRequest) {
        User userExist = this.findByUserName(regRequest.getUserName());
        if(userExist != null){
            throw new BadRequestException("El usuario ya existe");
        }
        User user = User.builder().username(regRequest.getUserName())
        .password(regRequest.getPassword()).role(RoleEnum.CLIENT).build();
        user = this.objUserRepository.save(user);
        return AuthResponse.builder()
        .message("Registro completado exitosamente")
        .token(this.obJwtService.getToken(user)).build();
    }
    private User findByUserName(String Username){
        return this.objUserRepository.findByusername(Username).orElse(null);
    }
}
