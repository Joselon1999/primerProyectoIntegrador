package utp.integrador.avance.service;

import utp.integrador.avance.entity.Estudio;

import java.util.List;

public interface RegisterStudiesService {

    List<Estudio> getAllEstudio();
    void save(Estudio estudio);
    Estudio getById(Integer id);
    void deleteViaId(Integer id);
}

