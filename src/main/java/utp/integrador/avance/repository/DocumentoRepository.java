package utp.integrador.avance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.entity.Documento;
import utp.integrador.avance.entity.User;

import java.util.List;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

}

