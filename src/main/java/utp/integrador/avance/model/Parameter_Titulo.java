package utp.integrador.avance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parameter_titulo")
@Getter
@Setter
@NoArgsConstructor
public class Parameter_Titulo {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Titulo titulo;

    @ManyToOne
    private Puesto_Docente puestoDocente;
}
