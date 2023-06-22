package utp.integrador.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.integrador.avance.model.*;
import utp.integrador.avance.dao.*;
import utp.integrador.avance.service.AdminService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired UserRepository userRepository;
    @Autowired DatosPersonalesRepository datosPersonalesRepository;
    @Autowired EstProfesionRepository profesionRepository;
    @Autowired EstudioRepository estudioRepository;
    @Autowired ExpLaboralRepository laboralRepository;
    @Autowired TrabajoRepository trabajoRepository;


    @Autowired private PuestoRepository repository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Datos_Personales getUserDatosPersonales(int userId) {
        return datosPersonalesRepository.findByUserUserId(userId);
    }

    @Override
    public List<Estudio> findAllByUserEmail(String email) {
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

    @Override
    public void updateUserStatus(String email, String status) {
        User user = userRepository.findByEmail(email).orElse(new User());
        user.setStatus(status);
        userRepository.save(user);
    }

    @Override
    public List<Puesto_Docente> listPuestos() {
        return repository.findAllByOrderByEstadoAsc();
    }
}

