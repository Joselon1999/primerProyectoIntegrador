package utp.integrador.avance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utp.integrador.avance.entity.Datos_Personales;
import utp.integrador.avance.entity.Estudio;
import utp.integrador.avance.service.RegisterStudiesService;

@Controller
@RequestMapping(value = "/est")
public class RegisterStudiesController {


    @Autowired
    private RegisterStudiesService estudioService;

    @GetMapping("/{email}")
    public String viewHomePage(@PathVariable String email, Model model) {
        model.addAttribute("allemplist", estudioService.getAllEstudio(email));
        return "registerStudies";
    }

    @GetMapping("/addnew/{email}")
    public String addNewEstudio(@PathVariable String email,Model model) {
        Estudio estudio = new Estudio();
        model.addAttribute("email", email);
        model.addAttribute("estudio", estudio);
        model.addAttribute("titulos", estudioService.listTitulos());
        model.addAttribute("especialidades", estudioService.listEspecialidades());
        return "registerCourse";
    }

    @PostMapping("/save/{email}")
    public String saveEstudio(Model model, @ModelAttribute("estudio") Estudio estudio, @PathVariable(value = "email") String email) {
        model.addAttribute("email", email);
        estudioService.save(estudio,email);
        return "redirect:/est/{email}";
    }

    @PostMapping("/update/{email}")
    public String updateEstudio(Model model, @ModelAttribute("estudio") Estudio estudio, @PathVariable(value = "email") String email) {
        model.addAttribute("email", email);
        estudioService.update(estudio,email);
        return "redirect:/est/{email}";
    }

    @GetMapping("/showFormForUpdate/{id}/{email}")
    public String updateForm(@PathVariable(value = "id") Integer id,@PathVariable(value = "email") String email, Model model) {
        Estudio Estudio = estudioService.getById(id);
        model.addAttribute("email", email);
        model.addAttribute("titulos", estudioService.listTitulos());
        model.addAttribute("especialidades", estudioService.listEspecialidades());
        model.addAttribute("estudio", Estudio);
        return "updateCourse";
    }

    @GetMapping("/deleteEstudio/{id}/{email}")
    public String deleteThroughId(@PathVariable(value = "id") Integer id, @PathVariable(value = "email") String email, Model model) {
        model.addAttribute("email", email);
        estudioService.deleteViaId(id);
        return "redirect:/est/{email}";

    }
}

