package utp.integrador.avance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import utp.integrador.avance.entity.Documento;
import utp.integrador.avance.entity.Sexo;
import utp.integrador.avance.entity.User;
import utp.integrador.avance.repository.DocumentoRepository;
import utp.integrador.avance.repository.SexoRepository;
import utp.integrador.avance.repository.UserRepository;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DocumentoRepository documentoRepository;

    @Autowired
    SexoRepository sexoRepository;

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
        return "index";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {

        return "index";
    }
    //Check for Credentials
    @PostMapping("/login")
    public String login(@ModelAttribute(name="loginForm") User user, Model m) {
        System.out.println("--------> "+user.getEmail());
        String uname = user.getEmail();
        String pass = user.getPassword();
        if (uname.equals("admin") && pass.equals("12345")) {
            m.addAttribute("uname", uname);
            m.addAttribute("pass", pass);

            List<User> lista = userRepository.findAll();
            m.addAttribute("allUserlist", lista);
            return "loginPage";
        }
        m.addAttribute("error", "Incorrect Username & Password");

        return "index";
    }
}
