package utp.integrador.avance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import utp.integrador.avance.entity.*;
import utp.integrador.avance.repository.*;

import java.util.List;

@Controller
public class LoginController {

    @Autowired UserRepository userRepository;
    @Autowired DocumentoRepository documentoRepository;
    @Autowired SexoRepository sexoRepository;

    @Autowired EspecialidadRepository especialidadRepository;

    @Autowired TituloRepository tituloRepository;

    @Autowired EstudioRepository estudioRepository;

    @GetMapping("/")
    public String viewHomePage(Model model) {

        Documento documento = new Documento();
        documento.setDescripcion("DNI");
        documentoRepository.save(documento);
        Documento documento2 = new Documento();
        documento2.setDescripcion("Pasaporte");
        documentoRepository.save(documento2);
        Sexo sexo1 = new Sexo();
        sexo1.setDescripcion("Masculino");
        sexoRepository.save(sexo1);
        Sexo sexo2 = new Sexo();
        sexo2.setDescripcion("Femenino");
        sexoRepository.save(sexo2);
        Especialidad especialidad = new Especialidad();
        especialidad.setDescripcion("Ing.Sistemas");
        especialidadRepository.save(especialidad);
        Especialidad especialidad1 = new Especialidad();
        especialidad1.setDescripcion("Ing.Civil");
        especialidadRepository.save(especialidad1);
        Especialidad especialidad2 = new Especialidad();
        especialidad2.setDescripcion("Ing.Software");
        especialidadRepository.save(especialidad2);
        Especialidad especialidad3 = new Especialidad();
        especialidad3.setDescripcion("Ing.Electrica");
        especialidadRepository.save(especialidad3);
        Especialidad especialidad4 = new Especialidad();
        especialidad4.setDescripcion("Ing.Mecanica");
        especialidadRepository.save(especialidad4);
        Titulo titulo = new Titulo();
        titulo.setDescripcion("Bachiller");
        tituloRepository.save(titulo);
        Titulo titulo2 = new Titulo();
        titulo2.setDescripcion("Titulacion");
        tituloRepository.save(titulo2);
        Titulo titulo3 = new Titulo();
        titulo3.setDescripcion("Colegiatura");
        tituloRepository.save(titulo3);
        Titulo titulo4 = new Titulo();
        titulo4.setDescripcion("Licenciatura");
        tituloRepository.save(titulo4);
        Titulo titulo5 = new Titulo();
        titulo5.setDescripcion("Maestria");
        tituloRepository.save(titulo5);
        return "index";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        return "index";
    }
    //Check for Credentials
    @PostMapping("/login")
    public String login(@ModelAttribute(name="loginForm") User user, Model m) {
        String uname = user.getEmail();
        String pass = user.getPassword();
        if (uname.equals("admin") && pass.equals("12345")) {
            m.addAttribute("uname", uname);
            m.addAttribute("pass", pass);
            return "redirect:/admin";
        }
        m.addAttribute("error", "Incorrect Username & Password");

        return "index";
    }

    @GetMapping("/end")
    public String end(Model model) {
        return "welcome";
    }

}
