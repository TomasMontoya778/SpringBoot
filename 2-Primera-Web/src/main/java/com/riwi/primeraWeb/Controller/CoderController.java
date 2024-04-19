package com.riwi.primeraWeb.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.riwi.primeraWeb.Entity.Coder;
import com.riwi.primeraWeb.Service.CoderService;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
// @ResquestMapping crea la ruta donde se activará este controlador
@RequestMapping("/")
public class CoderController {
    @Autowired
    private CoderService objCoderService;

    // Método para mostrar la vista y enviarle toda la lista de coders
    @GetMapping
    public String showViewCoder(Model objModel, @RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "4") int size) {
        // Obtenemos la lista de coders
        Page<Coder> listCoder = this.objCoderService.findAllPaginate(page-1, size);
        // Cargamos la lista en el modelo
        objModel.addAttribute("listCoder", listCoder);
        objModel.addAttribute("currentPage", page);
        objModel.addAttribute("totalPage", listCoder.getTotalPages());
        return "viewCoder";
    }

    // Método para mostrar la vista de formulario y además enviar una instancia vacía
    @GetMapping("/form")
    public String showViewForm(Model objModel) {
        objModel.addAttribute("coder", new Coder());
        objModel.addAttribute("action", "/create-coder");
        return "viewForm";
    }
    @GetMapping("/findbyid")
    public String showViewFindById(@RequestParam(defaultValue = "0") long id, Model objModel){
        objModel.addAttribute("action", "/findbyid?id="+id);
        Coder objCoder = this.objCoderService.findById(id);
        objModel.addAttribute("coder", objCoder);
        return "viewfindbyid";
    }

    // Método para recibir todos la información del formulario
   // @ModelAttribute lo utilizamos para recibir información de la vista
    @PostMapping("/create-coder")
    public String createCoder(@ModelAttribute Coder objCoder) {
        this.objCoderService.save(objCoder);
        return "redirect:/";
    }
    // pathVariable funciona para obtener el valor de una variable solo si es de tipo path EJM delete/10, donde el 10 es dinámico
    @GetMapping("/delete/{id}")
    public String showDeleteCoder(@PathVariable Long id){
        this.objCoderService.deleteCoder(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showCoderByid(@PathVariable Long id, Model objModel){
        Coder objCoder = objCoderService.findById(id);
        objModel.addAttribute("coder", objCoder);
        objModel.addAttribute("action", "/edit/"+(id));
        return "viewForm";
    }
    @PostMapping("/edit/{id}")
    public String updateCoder(@PathVariable Long id, @ModelAttribute Coder coder){
        objCoderService.update(id, coder);
        return "redirect:/";
    }

}
