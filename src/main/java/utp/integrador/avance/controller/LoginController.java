package utp.integrador.avance.controller;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import utp.integrador.avance.model.*;
import utp.integrador.avance.dao.*;
import utp.integrador.avance.service.impl.EmailServiceImpl;

@Controller
public class LoginController {

    @Autowired UserRepository userRepository;
    @Autowired DocumentoRepository documentoRepository;
    @Autowired SexoRepository sexoRepository;

    @Autowired EspecialidadRepository especialidadRepository;

    @Autowired TituloRepository tituloRepository;

    @Autowired EstudioRepository estudioRepository;

    @Autowired DatosPersonalesRepository personalesRepository;

    @Autowired EstProfesionRepository profesionRepository;

    @Autowired ExpLaboralRepository laboralRepository;

    @Autowired private ParameterEspecialidadRepository pespecialidadRepository;

    @Autowired private ParameterTituloRepository ptituloRepository;

    @Autowired private PuestoRepository repository;

    @Autowired TrabajoRepository trabajoRepository;

    @Autowired
    private EmailServiceImpl emailService;

    @GetMapping("/")
    public String viewHomePage(Model model) {

        if (documentoRepository.count()<1) {
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
            Titulo titulo6 = new Titulo();
            titulo6.setDescripcion("Doctor");
            tituloRepository.save(titulo6);
            Titulo titulo7 = new Titulo();
            titulo7.setDescripcion("Tecnico");
            tituloRepository.save(titulo7);
            Puesto_Docente puestoDocente = new Puesto_Docente();
            puestoDocente.setDescripcion("Profesor de Inteligencia Artificial");
            puestoDocente.setEstado("Abierto");
            repository.save(puestoDocente);
            Parameter_Especialidad pes = new Parameter_Especialidad();
            pes.setEspecialidad(especialidad);
            pes.setPuntaje(1);
            pes.setPuestoDocente(puestoDocente);
            pespecialidadRepository.save(pes);
            Parameter_Titulo pti = new Parameter_Titulo();
            pti.setTitulo(titulo);
            pti.setPuntaje(3);
            pti.setPuestoDocente(puestoDocente);
            ptituloRepository.save(pti);
            User user1 = new User();
            user1.setEmail("josesuperxp20@gmail.com");
            user1.setPassword("Ugabuga");
            user1.setStatus("Pendiente");
            User user2 = new User();
            user2.setEmail("joselon1999@hotmail.com");
            user2.setPassword("Ugabuga");
            user2.setStatus("Pendiente");
            userRepository.save(user1);
            userRepository.save(user2);
            Datos_Personales d1 = new Datos_Personales();
            d1.setMaterno("Morales");
            d1.setPaterno("Torrejon");
            d1.setNombres("Jose");
            d1.setCelular("999999999");
            d1.setDocumento(documento);
            d1.setNumero_documento("77777777");
            d1.setTelef_fijo("5050505");
            d1.setSexo(sexo1);
            d1.setUser(user1);
            personalesRepository.save(d1);
            Estudio estudio = new Estudio();
            estudio.setEspecialidad(especialidad);
            estudio.setTitulo(titulo);
            estudio.setCiudad("Lima");
            estudio.setFecha_culmina("2023-06-28");
            estudioRepository.save(estudio);
            Est_Profesional e1 = new Est_Profesional();
            e1.setUser(user1);
            e1.setEstudio(estudio);
            profesionRepository.save(e1);
            Estudio estudio2 = new Estudio();
            estudio2.setEspecialidad(especialidad2);
            estudio2.setTitulo(titulo2);
            estudio2.setCiudad("Lima");
            estudio2.setFecha_culmina("2023-06-28");
            estudioRepository.save(estudio2);
            Est_Profesional e2 = new Est_Profesional();
            e2.setUser(user1);
            e2.setEstudio(estudio2);
            profesionRepository.save(e2);
            Exp_Laboral laboral = new Exp_Laboral();
            Trabajo t1 = new Trabajo();
            t1.setCargo("Analista de sistemas");
            t1.setTiempo_inicio("2022-06-28");
            t1.setTimpo_final("2023-06-28");
            trabajoRepository.save(t1);
            laboral.setUser(user1);
            laboral.setTrabajo(t1);
            laboralRepository.save(laboral);

            Datos_Personales d2 = new Datos_Personales();
            d2.setMaterno("Morales");
            d2.setPaterno("Torrejon");
            d2.setNombres("Francisco");
            d2.setUser(user2);
            personalesRepository.save(d2);
            Estudio estudio1 = new Estudio();
            estudio1.setEspecialidad(especialidad3);
            estudio1.setTitulo(titulo3);
            estudioRepository.save(estudio1);
            Est_Profesional e3 = new Est_Profesional();
            e3.setUser(user2);
            e3.setEstudio(estudio1);
            profesionRepository.save(e3);
        }
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

    @GetMapping("/end/{email}")
    public String end(Model model,@PathVariable String email) throws MessagingException {
        emailService.sendCompleteMessage(email);
        return "welcome";
    }
}
