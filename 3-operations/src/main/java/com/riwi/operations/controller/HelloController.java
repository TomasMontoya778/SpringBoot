package com.riwi.operations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/saludo")
public class HelloController {
    @GetMapping
    public String HelloWord(){
        return "Hola Mundo";
    }
}
