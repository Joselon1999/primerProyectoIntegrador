package utp.integrador.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.integrador.avance.entity.Especialidad;
import utp.integrador.avance.entity.Estudio;
import utp.integrador.avance.entity.Titulo;
import utp.integrador.avance.repository.EspecialidadRepository;
import utp.integrador.avance.repository.EstudioRepository;
import utp.integrador.avance.repository.TituloRepository;
import utp.integrador.avance.service.RegisterStudiesService;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterStudiesServiceImpl implements RegisterStudiesService {


    @Autowired
    private EstudioRepository estudioRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Autowired
    private TituloRepository tituloRepository;

    @Override public List<Estudio> getAllEstudio()
    {
        return estudioRepository.findAll();
    }

    @Override public void save(Estudio estudio)
    {
        estudioRepository.save(estudio);
    }

    @Override public Estudio getById(Integer id)
    {
        Optional<Estudio> optional = estudioRepository.findById(id);
        Estudio estudio = null;
        if (optional.isPresent())
            estudio = optional.get();
        else
            throw new RuntimeException(
                    "Estudio not found for id : " + id);
        return estudio;
    }

    @Override public void deleteViaId(Integer id)
    {
        estudioRepository.deleteById(id);
    }

    @Override
    public List<Titulo> listTitulos() {
        return tituloRepository.findAll();
    }

    @Override
    public List<Especialidad> listEspecialidades() {
        return especialidadRepository.findAll();
    }
}

