package utp.integrador.avance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/exp")
public class RegisterExperienceController {

    @GetMapping()
    public String viewHomePage(Model model) {

        return "welcome";
    }
}
