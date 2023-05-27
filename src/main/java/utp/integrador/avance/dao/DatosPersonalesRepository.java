package utp.integrador.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.model.Datos_Personales;

public interface DatosPersonalesRepository extends JpaRepository<Datos_Personales, Integer> {

    Datos_Personales findByUserUserId(int id);
}

