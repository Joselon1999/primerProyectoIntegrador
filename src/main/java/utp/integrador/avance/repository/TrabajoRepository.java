package utp.integrador.avance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.entity.Estudio;
import utp.integrador.avance.entity.Trabajo;

public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {

    Trabajo findById(Long id);
}

