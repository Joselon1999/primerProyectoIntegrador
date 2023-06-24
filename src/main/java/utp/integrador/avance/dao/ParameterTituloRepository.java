package utp.integrador.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.model.Parameter_Titulo;

import java.util.List;

public interface ParameterTituloRepository extends JpaRepository<Parameter_Titulo, Integer> {

    List<Parameter_Titulo> findAllByPuestoDocenteId(Integer id);
}

