package utp.integrador.avance.service;

import utp.integrador.avance.entity.Especialidad;
import utp.integrador.avance.entity.Estudio;
import utp.integrador.avance.entity.Titulo;
import utp.integrador.avance.entity.Trabajo;

import java.util.List;

public interface RegisterExperienceService {

    List<Trabajo> getAllTrabajo(String email);
    void save(Trabajo trabajo,String email);
    void update(Trabajo trabajo,String email);
    Trabajo getById(Integer id);
    void deleteViaId(Integer id);
}

