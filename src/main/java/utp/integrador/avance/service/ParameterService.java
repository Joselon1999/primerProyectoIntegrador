package utp.integrador.avance.service;

import utp.integrador.avance.model.Parameter_Especialidad;
import utp.integrador.avance.model.Parameter_Titulo;
import utp.integrador.avance.model.Puesto_Docente;

import java.util.List;

public interface ParameterService {

    List<Puesto_Docente> listPuestos();
    Puesto_Docente findOne(Integer id);

    List<Parameter_Especialidad> listEspecialidadById(Integer id);

    List<Parameter_Titulo> listTituloById(Integer id);
}
