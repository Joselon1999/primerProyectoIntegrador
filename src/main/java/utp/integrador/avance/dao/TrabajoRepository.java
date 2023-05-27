package utp.integrador.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.model.Trabajo;

public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {

    Trabajo findById(Long id);
}

