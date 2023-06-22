package utp.integrador.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.model.Puesto_Docente;

import java.util.List;

public interface PuestoRepository extends JpaRepository<Puesto_Docente, Integer> {

    List<Puesto_Docente> findAllByOrderByEstadoAsc();

}

