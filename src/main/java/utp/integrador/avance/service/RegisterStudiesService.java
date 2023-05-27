package utp.integrador.avance.service;

import utp.integrador.avance.model.Especialidad;
import utp.integrador.avance.model.Estudio;
import utp.integrador.avance.model.Titulo;

import java.util.List;

public interface RegisterStudiesService {

    List<Estudio> getAllEstudio(String email);
    void save(Estudio estudio,String email);
    void update(Estudio estudio,String email);
    Estudio getById(Integer id);
    void deleteViaId(Integer id);
    List<Titulo> listTitulos();
    List<Especialidad> listEspecialidades();
}

