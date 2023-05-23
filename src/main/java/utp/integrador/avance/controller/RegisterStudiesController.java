package utp.integrador.avance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utp.integrador.avance.entity.Estudio;
import utp.integrador.avance.service.RegisterStudiesService;

@Controller
@RequestMapping(value = "/est")
public class RegisterStudiesController {


    @Autowired
    private RegisterStudiesService estudioService;

    @GetMapping()
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", estudioService.getAllEstudio());
        return "registerStudies";
    }

    @GetMapping("/addnew")
    public String addNewEstudio(Model model) {
        Estudio Estudio = new Estudio();
        model.addAttribute("estudio", Estudio);
        return "registerCourse";
    }

    @PostMapping("/save")
    public String saveEstudio(@ModelAttribute("estudio") Estudio Estudio) {
        estudioService.save(Estudio);
        return "redirect:/est";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") Integer id, Model model) {
        Estudio Estudio = estudioService.getById(id);
        model.addAttribute("estudio", Estudio);
        return "update";
    }

    @GetMapping("/deleteEstudio/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Integer id) {
        estudioService.deleteViaId(id);
        return "redirect:/est";

    }
}

