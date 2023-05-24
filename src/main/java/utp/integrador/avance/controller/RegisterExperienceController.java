package utp.integrador.avance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utp.integrador.avance.entity.Trabajo;
import utp.integrador.avance.repository.TrabajoRepository;
import utp.integrador.avance.service.RegisterExperienceService;
import utp.integrador.avance.service.RegisterStudiesService;

@Controller
@RequestMapping(value = "/exp")
public class RegisterExperienceController {


    @Autowired
    private RegisterExperienceService experienceService;

    @GetMapping("/{email}")
    public String viewHomePage(@PathVariable String email, Model model) {
        model.addAttribute("allemplist", experienceService.getAllTrabajo(email));
        return "registerExperience";
    }

    @GetMapping("/addnew/{email}")
    public String addNewTrabajo(@PathVariable String email,Model model) {
        Trabajo trabajo = new Trabajo();
        model.addAttribute("email", email);
        model.addAttribute("trabajo", trabajo);
        return "registerWork";
    }

    @PostMapping("/save/{email}")
    public String saveTrabajo(Model model, @ModelAttribute("trabajo") Trabajo trabajo, @PathVariable(value = "email") String email) {
        model.addAttribute("email", email);
        experienceService.save(trabajo,email);
        return "redirect:/exp/"+email;
    }

    @PostMapping("/update/{email}")
    public String updateeTrabajo(Model model, @ModelAttribute("trabajo") Trabajo trabajo, @PathVariable(value = "email") String email) {
        model.addAttribute("email", email);
        experienceService.update(trabajo,email);
        return "redirect:/exp/"+email;
    }

    @GetMapping("/showFormForUpdate/{id}/{email}")
    public String updateForm(@PathVariable(value = "id") Integer id,@PathVariable(value = "email") String email, Model model) {
        Trabajo trabajo = experienceService.getById(id);
        model.addAttribute("email", email);
        model.addAttribute("trabajo", trabajo);
        return "updateWork";
    }

    @GetMapping("/deleteTrabajo/{id}/{email}")
    public String deleteThroughId(@PathVariable(value = "id") Integer id, @PathVariable(value = "email") String email, Model model) {
        model.addAttribute("email", email);
        experienceService.deleteViaId(id);
        return "redirect:/exp/"+email;

    }
}
