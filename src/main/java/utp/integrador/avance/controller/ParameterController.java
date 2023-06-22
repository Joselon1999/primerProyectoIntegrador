package utp.integrador.avance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import utp.integrador.avance.service.ParameterService;

@Controller
@RequestMapping(value = "/admin/puestoTrabajo")
public class ParameterController {

    @Autowired
    private ParameterService parameterService;

    @GetMapping("/getAll")
    public String viewHomePage(Model model) {
        model.addAttribute("listPuestos", parameterService.listPuestos());
        return "registerExperience";
    }

    @GetMapping("/get/{id}")
    public String viewHomePage(@PathVariable Integer id, Model model) {
        model.addAttribute("puesto", parameterService.findOne(id));
        model.addAttribute("especialidades", parameterService.listEspecialidadById(id));
        model.addAttribute("titulos", parameterService.listTituloById(id));
        return "registerExperience";
    }
}
