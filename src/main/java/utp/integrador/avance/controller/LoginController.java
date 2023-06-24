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

    @Autowired private ParameterEspecialidadRepository pespecialidadRepository;

    @Autowired private ParameterTituloRepository ptituloRepository;

    @Autowired private PuestoRepository repository;

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

    /*private void buildEspecialidad() {
        Especialidad especialidad = new Especialidad();
        especialidad.setDescripcion("ADMINISTRACIÓN");
        especialidadRepository.save(especialidad);
        Especialidad especialidad1 = new Especialidad();
        especialidad1.setDescripcion("ANTROPOLOGÍA");
        especialidadRepository.save(especialidad1);
        Especialidad especialidad4 = new Especialidad();
        especialidad4.setDescripcion("ARQUITECTURA");
        especialidadRepository.save(especialidad4);
        Especialidad especialidad2 = new Especialidad();
        especialidad2.setDescripcion("CIENCIA POLÍTICA Y GOBIERNO");
        especialidadRepository.save(especialidad2);
        Especialidad especialidad3 = new Especialidad();
        especialidad3.setDescripcion("CIENCIAS DE LA COMUNICACIÓN");
        especialidadRepository.save(especialidad3);

        Especialidad especialidad5 = new Especialidad();
        especialidad5.setDescripcion("CIENCIAS DE LA INFORMACIÓN");
        especialidadRepository.save(especialidad5);
        Especialidad especialidad6 = new Especialidad();
        especialidad6.setDescripcion("CONTABILIDAD");
        especialidadRepository.save(especialidad6);
        Especialidad especialidad7 = new Especialidad();
        especialidad7.setDescripcion("DERECHO");
        especialidadRepository.save(especialidad7);
        Especialidad especialidad8 = new Especialidad();
        especialidad8.setDescripcion("ECONOMÍA");
        especialidadRepository.save(especialidad8);
        Especialidad especialidad9 = new Especialidad();
        especialidad9.setDescripcion("EDUCACIÓN");
        especialidadRepository.save(especialidad9);
        Especialidad especialidad10 = new Especialidad();
        especialidad10.setDescripcion("FILOSOFÍA");
        especialidadRepository.save(especialidad3);
        Especialidad especialidad11 = new Especialidad();
        especialidad11.setDescripcion("FINANZAS");
        especialidadRepository.save(especialidad11);
        Especialidad especialidad3 = new Especialidad();
        especialidad3.setDescripcion("FÍSICA");
        especialidadRepository.save(especialidad3);
        Especialidad especialidad3 = new Especialidad();
        especialidad3.setDescripcion("CIENCIAS DE LA COMUNICACIÓN");
        especialidadRepository.save(especialidad3);
        Especialidad especialidad3 = new Especialidad();
        especialidad3.setDescripcion("CIENCIAS DE LA COMUNICACIÓN");
        especialidadRepository.save(especialidad3);
        Especialidad especialidad3 = new Especialidad();
        especialidad3.setDescripcion("CIENCIAS DE LA COMUNICACIÓN");
        especialidadRepository.save(especialidad3);
        Especialidad especialidad3 = new Especialidad();
        especialidad3.setDescripcion("CIENCIAS DE LA COMUNICACIÓN");
        especialidadRepository.save(especialidad3);





                                                                        "GEOGRAFÍA Y MEDIO AMBIENTE"
                                                                        "HISTORIA"
                                                                        "IDIOMAS"
                                                                        "INFORMÁTICA"
                                                                        "INGENIERÍA CIVIL"
                                                                        "INGENIERÍA DE INDUSTRIAS ALIMENTARIAS"
                                                                        "INGENIERÍA DE SISTEMAS"
                                                                        "INGENIERÍA ELECTRÓNICA"
                                                                        "INGENIERÍA INDUSTRIAL"
                                                                        "INGENIERÍA INFORMÁTICA"
                                                                        "INGENIERÍA MECÁNICA"
                                                                        "LINGUÍSTICA"
                                                                        "LITERATURA"
                                                                        "MARKETING"
                                                                        "MARKETING DIGITAL"
                                                                        "MATEMÁTICAS"
                                                                        "NEGOCIOS INTERNACIONALES"
                                                                        "OTROS"
                                                                        "PSICOLOGÍA"
                                                                        "PUBLICIDAD"
                                                                        "RECURSOS HUMANOS"
                                                                        "TURISMO"

    }*/
}
