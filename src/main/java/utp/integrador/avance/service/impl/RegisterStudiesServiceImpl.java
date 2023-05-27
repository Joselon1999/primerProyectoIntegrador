package utp.integrador.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.integrador.avance.model.*;
import utp.integrador.avance.dao.*;
import utp.integrador.avance.service.RegisterStudiesService;

import java.util.ArrayList;
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

    @Autowired
    private EstProfesionRepository profesionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Estudio> getAllEstudio(String email) {
        List<Estudio> lista = new ArrayList<>();
        List<Long> estudios = new ArrayList<>();
        List<Est_Profesional> p = profesionRepository.findAllByUserEmail(email);
        for (int i = 0; i<p.size(); i++) {
            estudios.add(p.get(i).getEstudio().getId());
        }
        for (int j = 0; j<p.size(); j++) {
            lista.add(estudioRepository.findById(estudios.get(j)));
        }

        return lista;
    }

    @Override public void save(Estudio estudio,String email) {
        Est_Profesional profesional = new Est_Profesional();
        Estudio estudio1 = estudioRepository.save(estudio);
        User user = userRepository.findByEmail(email).orElse(null);
        profesional.setEstudio(estudio1);
        profesional.setUser(user);
        profesionRepository.save(profesional);
    }

    @Override public void update(Estudio estudio,String email) {
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
        Est_Profesional est = profesionRepository.findByEstudioId(id);
        profesionRepository.delete(est);
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

