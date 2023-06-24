package utp.integrador.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.integrador.avance.dao.*;
import utp.integrador.avance.model.*;
import utp.integrador.avance.service.ParameterService;

import java.util.List;
import java.util.Optional;

@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    private ParameterEspecialidadRepository especialidadRepository;

    @Autowired
    private ParameterTituloRepository tituloRepository;

    @Autowired
    private PuestoRepository repository;

    @Autowired
    private EspecialidadRepository espRepository;

    @Autowired
    private TituloRepository titRepository;

    @Override
    public List<Puesto_Docente> listPuestos() {
        return repository.findAll();
    }

    @Override
    public Puesto_Docente findOne(Integer id) {
        return Optional.of(repository.findById(id)).get().orElse(new Puesto_Docente());
    }

    @Override
    public List<Parameter_Especialidad> listEspecialidadById(Integer id) {
        return especialidadRepository.findAllByPuestoDocenteId(id);
    }

    @Override
    public List<Parameter_Titulo> listTituloById(Integer id) {
        return tituloRepository.findAllByPuestoDocenteId(id);
    }

    @Override
    public Puesto_Docente savePuesto(Puesto_Docente puestoDocente) {
        return repository.save(puestoDocente);
    }

    @Override
    public List<Especialidad> listEspecialidad() {
        return espRepository.findAll();
    }

    @Override
    public List<Titulo> listTitulo() {
        return titRepository.findAll();
    }

    @Override
    public Parameter_Especialidad saveParamEsp(Parameter_Especialidad especialidad, Integer id) {
        Long n = (long) (especialidadRepository.findAllByPuestoDocenteId(id).size() + 1);
        Puesto_Docente puesto = findOne(id);
        especialidad.setId(n);
        especialidad.setPuestoDocente(puesto);
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Parameter_Titulo saveParamTit(Parameter_Titulo titulo, Integer id) {
        Long n = (long) (tituloRepository.findAllByPuestoDocenteId(id).size() + 1);
        Puesto_Docente puesto = findOne(id);
        titulo.setId(n);
        titulo.setPuestoDocente(puesto);
        return tituloRepository.save(titulo);
    }
}
