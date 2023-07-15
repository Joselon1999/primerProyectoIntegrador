package utp.integrador.avance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import utp.integrador.avance.model.Estudio;
import utp.integrador.avance.model.Parameter_Especialidad;
import utp.integrador.avance.model.Parameter_Titulo;
import utp.integrador.avance.model.Puesto_Docente;
import utp.integrador.avance.service.ParameterService;

@Controller
@RequestMapping(value = "/admin/puestoTrabajo")
public class ParameterController {

    @Autowired
    private ParameterService parameterService;

    @GetMapping("/getAll")
    public String viewHomePage(Model model) {
        model.addAttribute("listPuestos", parameterService.listPuestos());
        return "loginPage";
    }

    @GetMapping("/get/{id}")
    public String viewHomePage(@PathVariable Integer id, Model model) {
        model.addAttribute("puesto", parameterService.findOne(id));
        model.addAttribute("especialidades", parameterService.listEspecialidadById(id));
        model.addAttribute("titulos", parameterService.listTituloById(id));
        return "listPuestos";
    }

    @PostMapping("/save")
    public String saveEstudio(Model model, @ModelAttribute("puesto") Puesto_Docente estudio) {
        parameterService.savePuesto(estudio);
        return "redirect:/admin";
    }

    @GetMapping("/param_esp/{id}")
    public String viewNewParamEsp(@PathVariable Integer id, Model model) {
        model.addAttribute("puesto", parameterService.findOne(id));
        model.addAttribute("param", new Parameter_Especialidad());
        model.addAttribute("especialidades", parameterService.listEspecialidad());
        return "registerParamEsp";
    }
    @PostMapping("/save/param_esp/{id}")
    public String saveParamEsp(@PathVariable Integer id,Model model, @ModelAttribute Parameter_Especialidad especialidad) {
        parameterService.saveParamEsp(especialidad,id);
        return "redirect:/admin/puestoTrabajo/get/"+id;
    }

    @GetMapping("/param_tit/{id}")
    public String viewNewParamTit(@PathVariable Integer id, Model model) {
        model.addAttribute("puesto", parameterService.findOne(id));
        model.addAttribute("param", new Parameter_Titulo());
        model.addAttribute("titulos", parameterService.listTitulo());
        return "registerParamTit";
    }
    @PostMapping("/save/param_tit/{id}")
    public String saveParamTit(@PathVariable Integer id,Model model, @ModelAttribute Parameter_Titulo titulo) {
        parameterService.saveParamTit(titulo,id);
        return "redirect:/admin/puestoTrabajo/get/"+id;
    }

    @GetMapping("/results/{id}")
    public String endResults(@PathVariable Integer id,Model model) {
        model.addAttribute("allUserlist", parameterService.getAllUsers(id));
        return "listResults";
    }
}
