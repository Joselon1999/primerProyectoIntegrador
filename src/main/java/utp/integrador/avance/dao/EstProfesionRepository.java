package utp.integrador.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.model.Est_Profesional;

import java.util.List;

public interface EstProfesionRepository extends JpaRepository<Est_Profesional, Integer> {

    List<Est_Profesional> findAllByUserEmail(String email);

    Est_Profesional findByEstudioId(Integer id);
}

