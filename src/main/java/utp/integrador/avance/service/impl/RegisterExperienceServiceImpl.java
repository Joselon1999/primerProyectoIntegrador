package utp.integrador.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.integrador.avance.model.*;
import utp.integrador.avance.dao.*;
import utp.integrador.avance.service.RegisterExperienceService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegisterExperienceServiceImpl implements RegisterExperienceService {


    @Autowired
    private TrabajoRepository trabajoRepository;

    @Autowired
    private ExpLaboralRepository laboralRepository;


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Trabajo> getAllTrabajo(String email) {
        List<Trabajo> lista = new ArrayList<>();
        List<Long> exp = new ArrayList<>();
        List<Exp_Laboral> p = laboralRepository.findAllByUserEmail(email);
        for (int i = 0; i<p.size(); i++) {
            exp.add(p.get(i).getTrabajo().getId());
        }
        for (int j = 0; j<p.size(); j++) {
            lista.add(trabajoRepository.findById(exp.get(j)));
        }

        return lista;
    }

    @Override public void save(Trabajo trabajo,String email) {
        Exp_Laboral laboral = new Exp_Laboral();
        Trabajo trabajo1 = trabajoRepository.save(trabajo);
        User user = userRepository.findByEmail(email).orElse(null);
        laboral.setTrabajo(trabajo1);
        laboral.setUser(user);
        laboralRepository.save(laboral);
    }

    @Override public void update(Trabajo trabajo,String email) {
        trabajoRepository.save(trabajo);
    }

    @Override public Trabajo getById(Integer id)
    {
        Optional<Trabajo> optional = trabajoRepository.findById(id);
        Trabajo trabajo = null;
        if (optional.isPresent())
            trabajo = optional.get();
        else
            throw new RuntimeException(
                    "Trabajo not found for id : " + id);
        return trabajo;
    }

    @Override public void deleteViaId(Integer id)
    {
        Exp_Laboral laboral = laboralRepository.findByTrabajoId(id);
        laboralRepository.delete(laboral);
        trabajoRepository.deleteById(id);
    }
}

