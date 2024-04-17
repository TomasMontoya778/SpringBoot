package com.riwi.primeraWeb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.riwi.primeraWeb.Entity.Coder;
import com.riwi.primeraWeb.Service.CoderService;



@Controller
// @ResquestMapping crea la ruta donde se activará este controlador
@RequestMapping("/")
public class CoderController {
    @Autowired
    private CoderService objCoderService;
    // Método para mostrar la vista y enviarle toda la lista de coders
    @GetMapping
    public String showViewCoder(Model objModel){
        // Obtenemos la lista de coders
        List<Coder> listCoder = this.objCoderService.findAll();
        // Cargamos la lista en el modelo
        objModel.addAttribute("listCoder", listCoder);
        return "viewCoder";
    }
}
