package utp.integrador.avance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "estudio")
@Getter
@Setter
@AllArgsConstructor
public class Estudio {

    @Id
    @GeneratedValue
    private Long estudio_id;

    private Titulo titulo;

    private Especialidad especialidad;

    private Date fecha_culmina;

    private String ciudad;
}
