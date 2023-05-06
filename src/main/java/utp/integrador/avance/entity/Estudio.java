package utp.integrador.avance.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "estudio")
@Getter
@Setter
@NoArgsConstructor
public class Estudio {

    @Id
    @GeneratedValue
    private Long estudio_id;

    @ManyToOne
    private Titulo titulo;

    @ManyToOne
    private Especialidad especialidad;

    private String fecha_culmina;

    private String ciudad;
}
