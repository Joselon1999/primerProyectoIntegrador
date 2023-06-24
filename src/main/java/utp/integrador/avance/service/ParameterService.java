package utp.integrador.avance.service;

import utp.integrador.avance.model.*;

import java.util.List;

public interface ParameterService {

    List<Puesto_Docente> listPuestos();
    Puesto_Docente findOne(Integer id);

    List<Parameter_Especialidad> listEspecialidadById(Integer id);

    List<Parameter_Titulo> listTituloById(Integer id);

    Puesto_Docente savePuesto(Puesto_Docente puestoDocente);

    List<Especialidad> listEspecialidad();

    List<Titulo> listTitulo();

    Parameter_Especialidad saveParamEsp(Parameter_Especialidad especialidad, Integer id);

    Parameter_Titulo saveParamTit(Parameter_Titulo titulo, Integer id);
}
