package utp.integrador.avance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "puesto_docente")
@Getter
@Setter
@NoArgsConstructor
public class Puesto_Docente {

    @Id
    @GeneratedValue
    private Long id;
    private String descripcion;
    private String estado;
}
