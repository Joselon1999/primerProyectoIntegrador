package utp.integrador.avance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.entity.Especialidad;
import utp.integrador.avance.entity.Titulo;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {

}
