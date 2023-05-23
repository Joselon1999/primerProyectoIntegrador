package utp.integrador.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.integrador.avance.entity.Estudio;
import utp.integrador.avance.repository.EstudioRepository;
import utp.integrador.avance.service.RegisterStudiesService;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterStudiesServiceImpl implements RegisterStudiesService {


    @Autowired
    private EstudioRepository repository;

    @Override public List<Estudio> getAllEstudio()
    {
        return repository.findAll();
    }

    @Override public void save(Estudio estudio)
    {
        repository.save(estudio);
    }

    @Override public Estudio getById(Integer id)
    {
        Optional<Estudio> optional = repository.findById(id);
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
        repository.deleteById(id);
    }
}

