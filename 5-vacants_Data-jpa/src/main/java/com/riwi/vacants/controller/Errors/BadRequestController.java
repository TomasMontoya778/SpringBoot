package com.riwi.vacants.controller.Errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/*
 * @RestControllerAdvice = Controlador de errores
 */

import com.riwi.vacants.utils.dto.Errors.BaseErrorResponse;
import com.riwi.vacants.utils.dto.Errors.ErrorsResponce;
import com.riwi.vacants.utils.exceptions.IdNotFoundExceptions;
@RestControllerAdvice
/*
 * Status de error del controlador
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {
    @ExceptionHandler(IdNotFoundExceptions.class)
    public BaseErrorResponse handleIdNotFound(IdNotFoundExceptions exception){
        return ErrorsResponce.builder().code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).message(exception.getMessage()).build();
    }
}
