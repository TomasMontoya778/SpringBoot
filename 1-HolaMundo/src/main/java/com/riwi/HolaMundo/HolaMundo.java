package com.riwi.HolaMundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//Indica que esta clase será un controlador
@Controller
// Request mapping crea la ruta base para acceder al controlador
@RequestMapping("/soyElMejor")
public class HolaMundo {
    // Get mapping crea la ruta específica donde se disparará el mensaje
    @GetMapping("/saludar")
    // Permite responder en formato texto o json
    @ResponseBody
    public String showMessaje (){
        return "Hola Mundo, soy el mejor";
    }
}
