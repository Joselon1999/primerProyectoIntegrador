package utp.integrador.avance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import utp.integrador.avance.entity.Datos_Personales;
import utp.integrador.avance.entity.User;

import java.util.List;

public interface DatosPersonalesRepository extends JpaRepository<Datos_Personales, Integer> {

    //@Query("select s from datos_personales s where s.userId = ?1")
    List<Datos_Personales> findByUserUserId(int id);
}

