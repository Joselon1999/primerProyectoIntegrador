package utp.integrador.avance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import utp.integrador.avance.entity.Est_Profesional;
import utp.integrador.avance.entity.Estudio;

import java.util.List;

public interface EstProfesionRepository extends JpaRepository<Est_Profesional, Integer> {

    List<Est_Profesional> findAllByUserEmail(String email);

    Est_Profesional findByEstudioId(Integer id);

    //@Modifying
    //@Query("delete from Est_Profesional b where b.estudio.id=:id")
    //void deleteEstudios(@Param("id") Integer id);
}

