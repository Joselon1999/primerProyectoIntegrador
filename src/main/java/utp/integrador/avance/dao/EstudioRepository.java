package utp.integrador.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.model.Estudio;

public interface EstudioRepository extends JpaRepository<Estudio, Integer> {

    Estudio findById(Long id);
}

