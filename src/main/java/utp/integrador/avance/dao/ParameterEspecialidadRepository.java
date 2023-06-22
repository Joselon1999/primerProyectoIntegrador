package utp.integrador.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.model.Parameter_Especialidad;

import java.util.List;

public interface ParameterEspecialidadRepository extends JpaRepository<Parameter_Especialidad, Integer> {

    List<Parameter_Especialidad> findAllById(Integer id);
}

