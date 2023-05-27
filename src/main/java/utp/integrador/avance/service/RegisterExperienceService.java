package utp.integrador.avance.service;

import utp.integrador.avance.model.Trabajo;

import java.util.List;

public interface RegisterExperienceService {

    List<Trabajo> getAllTrabajo(String email);
    void save(Trabajo trabajo,String email);
    void update(Trabajo trabajo,String email);
    Trabajo getById(Integer id);
    void deleteViaId(Integer id);
}

