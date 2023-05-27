package utp.integrador.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.model.Exp_Laboral;

import java.util.List;

public interface ExpLaboralRepository extends JpaRepository<Exp_Laboral, Integer> {

    List<Exp_Laboral> findAllByUserEmail(String email);

    Exp_Laboral findByTrabajoId(Integer id);

    //@Modifying
    //@Query("delete from Est_Profesional b where b.estudio.id=:id")
    //void deleteEstudios(@Param("id") Integer id);
}

