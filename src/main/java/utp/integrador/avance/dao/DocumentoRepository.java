package utp.integrador.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

}

