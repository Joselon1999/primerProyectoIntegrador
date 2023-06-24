package utp.integrador.avance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "parameter_especialidad")
@Getter
@Setter
@NoArgsConstructor
public class Parameter_Especialidad {


    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Especialidad especialidad;

    @ManyToOne
    private Puesto_Docente puestoDocente;

    private double puntaje;
}
