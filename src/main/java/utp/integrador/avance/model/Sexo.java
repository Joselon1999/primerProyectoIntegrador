package utp.integrador.avance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sexo")
@Getter
@Setter
@NoArgsConstructor
public class Sexo {


    @Id
    @GeneratedValue
    private Long sexo_id;
    private String descripcion;
}
