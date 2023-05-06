package utp.integrador.avance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.entity.Documento;
import utp.integrador.avance.entity.Sexo;

public interface SexoRepository extends JpaRepository<Sexo, Integer> {

}

