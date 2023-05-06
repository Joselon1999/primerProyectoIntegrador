package utp.integrador.avance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utp.integrador.avance.entity.Datos_Personales;
import utp.integrador.avance.entity.Documento;
import utp.integrador.avance.entity.Sexo;
import utp.integrador.avance.entity.User;
import utp.integrador.avance.repository.DatosPersonalesRepository;
import utp.integrador.avance.repository.DocumentoRepository;
import utp.integrador.avance.repository.SexoRepository;
import utp.integrador.avance.repository.UserRepository;

import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DocumentoRepository documentoRepository;

    @Autowired
    SexoRepository sexoRepository;

    @Autowired
    DatosPersonalesRepository datosPersonalesRepository;

    @RequestMapping("/welcome")
    public String registerMessage() {
        User user = new User();
        user.setEmail("correo@gmail.com");
        user.setPassword("pass");
        userRepository.save(user);

        Documento documento = new Documento();
        documento.setDescripcion("DNI");
        documentoRepository.save(documento);

        Sexo sexo = new Sexo();
        sexo.setDescripcion("Hombre");
        sexoRepository.save(sexo);

        Datos_Personales personales = new Datos_Personales();
        personales.setDocumento(documentoRepository.findById(1).orElse(new Documento()));
        personales.setSexo(sexoRepository.findById(1).orElse(new Sexo()));
        datosPersonalesRepository.save(personales);

        //PARA REVISAR
        //User user1 = userRepository.findByEmail("correo@gmail.com").orElse(new User());
        //System.out.println("USUARIO: "+user1.getUserId()+") "+user1.getEmail());
        //List<Datos_Personales> listado2 = datosPersonalesRepository.findByUserUserId(1);
        //String linea = "";
        //for (int i = 0; i < listado2.size(); i++) {
        //    linea = linea.concat(listado2.get(i).toString());
        //}

        return "welcome: ";
    }

    @GetMapping("/register")
    public String registerMessage(Model model) {

        return "registerUserPage";
    }

    @PostMapping("/registerUser")
    public String registerUser(Model model, @ModelAttribute User user) {
        userRepository.save(user);

        //model.addAttribute("user", user);
        model.addAttribute("personales", new Datos_Personales());
        model.addAttribute("documentos", documentoRepository.findAll());
        model.addAttribute("sexos", sexoRepository.findAll());
        return "registerPersonalPage";
    }

    @PostMapping("/registerPersonal")
    public String loginMessage(Model model, @ModelAttribute Datos_Personales personales) {
        System.out.println("-------------> "+personales.getDocumento().getDescripcion());
        System.out.println("-------------> "+personales.getSexo().getDescripcion());
        datosPersonalesRepository.save(personales);

        return "welcome";
    }
}
