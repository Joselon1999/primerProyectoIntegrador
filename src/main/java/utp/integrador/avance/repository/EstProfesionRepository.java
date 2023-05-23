package utp.integrador.avance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.entity.Est_Profesional;
import utp.integrador.avance.entity.Estudio;

public interface EstProfesionRepository extends JpaRepository<Est_Profesional, Integer> {

}

