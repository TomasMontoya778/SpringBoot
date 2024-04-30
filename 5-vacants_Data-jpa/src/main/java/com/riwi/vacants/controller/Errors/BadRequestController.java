package com.riwi.vacants.controller.Errors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/*
 * @RestControllerAdvice = Controlador de errores
 */

import com.riwi.vacants.utils.dto.Errors.BaseErrorResponse;
import com.riwi.vacants.utils.dto.Errors.ErrorResponse;
import com.riwi.vacants.utils.dto.Errors.ErrorsResponse;
import com.riwi.vacants.utils.exceptions.IdNotFoundExceptions;
@RestControllerAdvice
/*
 * Status de error del controlador
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {
    @ExceptionHandler(IdNotFoundExceptions.class)
    public BaseErrorResponse handleIdNotFound(IdNotFoundExceptions exception){
        return ErrorsResponse.builder().code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).message(exception.getMessage()).build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleErrors(MethodArgumentNotValidException exception){
        List<String> errors = new ArrayList<>();
        exception.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
        return ErrorResponse.builder().code(HttpStatus.BAD_REQUEST.value()).status(HttpStatus.BAD_REQUEST.name()).errors(errors).build();
    }
}
