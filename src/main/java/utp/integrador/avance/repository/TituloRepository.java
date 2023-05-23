package utp.integrador.avance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.entity.Sexo;
import utp.integrador.avance.entity.Titulo;

public interface TituloRepository extends JpaRepository<Titulo, Integer> {

}

