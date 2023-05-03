package utp.integrador.avance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sexo")
@Getter
@Setter
@AllArgsConstructor
public class Sexo {


    @Id
    @GeneratedValue
    private Long sexo_id;
    private String descripcion;
}
