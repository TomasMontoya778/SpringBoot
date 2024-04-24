package dailyHomeWork.com.dailyHomeWork.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dailyHomeWork.com.dailyHomeWork.Entity.Homework;
import dailyHomeWork.com.dailyHomeWork.Service.TareaService;

@Controller
@RequestMapping("/")
public class TareaController {
    @Autowired
    private TareaService objTareaService;
    // GetMapping
    @GetMapping("/form")
    public String showViewForm(Model objModel) {
        objModel.addAttribute("homeWork", new Homework());
        objModel.addAttribute("action", "/create-home");
        return "viewForm";
    }

    @GetMapping
    public String showViewMain(Model model) {
        List<Homework> listHomeWork = this.objTareaService.findAll();
        model.addAttribute("listHomeWork", listHomeWork);
        return "viewHomeWork";
    }
    @GetMapping("/findByTitle")
    public String showViewFindBytitle(@RequestParam(defaultValue = "") String title ,Model objModel){
        
        objModel.addAttribute("action", "/findByTitle");
        List<Homework> objHomework = this.objTareaService.findByTitle(title);
        if (title.equals("")) {
            objModel.addAttribute("listHomeWork", new ArrayList<>());
        }else{
            objModel.addAttribute("listHomeWork", objHomework);
        }
        return "findbyname";
    }

    @GetMapping("/delete/{id}")
    public String deleteHomework(@PathVariable Long id) {
        this.objTareaService.deleteTarea(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateHomeWork(@PathVariable Long id, Model objModel) {
        Homework objHomework = this.objTareaService.findByid(id);
        objModel.addAttribute("homeWork", objHomework);
        objModel.addAttribute("action", "/edit/"+(id));
        return "viewForm";
    }
    // PostMapping
    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute Homework homework, @PathVariable Long id){
        this.objTareaService.updateTarea(id, homework);
        return "redirect:/";
    }
    @PostMapping("/create-home")
    public String createHomeWork(@ModelAttribute Homework objHomework) {
        this.objTareaService.save(objHomework);
        return "redirect:/";
    }

}
