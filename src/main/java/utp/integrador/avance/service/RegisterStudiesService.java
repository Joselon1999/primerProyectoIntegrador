package utp.integrador.avance.service;

import utp.integrador.avance.entity.Especialidad;
import utp.integrador.avance.entity.Estudio;
import utp.integrador.avance.entity.Titulo;

import java.util.List;

public interface RegisterStudiesService {

    List<Estudio> getAllEstudio();
    void save(Estudio estudio);
    Estudio getById(Integer id);
    void deleteViaId(Integer id);
    List<Titulo> listTitulos();
    List<Especialidad> listEspecialidades();
}

