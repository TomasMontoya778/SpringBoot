package com.riwi.beautySalon.api.error_handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/* RestControllerAdvice = Controlador de errores */

import com.riwi.beautySalon.api.dto.errors.BaseErrorResponse;
import com.riwi.beautySalon.api.dto.errors.ErrorsResponse;
@RestControllerAdvice
/* Status de error del controlador */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestController {
    /* MethodArgumentNotValidException Es la excepción que activa la librería de validación */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handlerBadRequest(MethodArgumentNotValidException exception){
        List<Map<String, String>> errors = new ArrayList<>();
        /* getBindingResult Obtiene los resultados con el field y el error 
         * getFieldErrors Obtiene la lista de los nombres del campo del error
        */
        exception.getBindingResult().getFieldErrors().forEach(e ->{
            Map<String, String> error = new HashMap<>();
            error.put("Error", e.getDefaultMessage()); /* Agregar al map el error */
            error.put("Field", e.getField());/* Agrega al map en dónde ocurrió el error */
            errors.add(error);
        });
        return ErrorsResponse.builder()
        .code(HttpStatus.BAD_REQUEST.value()) // 400
        .status(HttpStatus.BAD_REQUEST.name()) // BAD_REQUEST
        .errors(errors). /* [
            {
                "field": "mal", 
                "error": "mal"
            }
        ] */
        build();
    }
}
