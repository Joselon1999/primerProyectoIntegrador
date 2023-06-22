package utp.integrador.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.integrador.avance.dao.ParameterEspecialidadRepository;
import utp.integrador.avance.dao.ParameterTituloRepository;
import utp.integrador.avance.dao.PuestoRepository;
import utp.integrador.avance.model.Parameter_Especialidad;
import utp.integrador.avance.model.Parameter_Titulo;
import utp.integrador.avance.model.Puesto_Docente;
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
        return especialidadRepository.findAllById(id);
    }

    @Override
    public List<Parameter_Titulo> listTituloById(Integer id) {
        return tituloRepository.findAllById(id);
    }
}
