package utp.integrador.avance.controller;


import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utp.integrador.avance.model.Datos_Personales;
import utp.integrador.avance.model.Documento;
import utp.integrador.avance.model.Sexo;
import utp.integrador.avance.model.User;
import utp.integrador.avance.service.RegisterService;
import utp.integrador.avance.service.impl.EmailServiceImpl;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private EmailServiceImpl emailService;

    @RequestMapping("/welcome")
    public String registerMessage() {
        User user = new User();
        user.setEmail("correo@gmail.com");
        user.setPassword("pass");
        registerService.registerUser(user);

        Documento documento = new Documento();
        documento.setDescripcion("DNI");
        registerService.registerDocumento(documento);

        Sexo sexo = new Sexo();
        sexo.setDescripcion("Hombre");
        registerService.registerSexo(sexo);

        //Datos_Personales personales = new Datos_Personales();
        //personales.setDocumento(documentoRepository.findById(1).orElse(new Documento()));
        //personales.setSexo(sexoRepository.findById(1).orElse(new Sexo()));
        //datosPersonalesRepository.save(personales);

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
    public String registerUser(Model model, @ModelAttribute User user) throws MessagingException {
        user.setStatus("Pendiente");
        registerService.registerUser(user);

        emailService.sendSimpleMessage();
        model.addAttribute("email", user.getEmail());
        model.addAttribute("personales", new Datos_Personales());
        model.addAttribute("documentos", registerService.listDocumentos());
        model.addAttribute("sexos", registerService.listSexo());
        return "registerPersonalPage";
    }

    @PostMapping("/registerPersonal/{email}")
    public String loginMessage(@PathVariable String email, @ModelAttribute Datos_Personales personales) {
        System.out.println("EMAIL: "+email);
        User usuario = registerService.findUser(email);
        personales.setUser(usuario);
        registerService.registerDatosPersonales(personales);

        return "redirect:/est/{email}";
    }
}
