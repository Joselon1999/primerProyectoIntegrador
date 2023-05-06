package utp.integrador.avance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "procedencia")
@Getter
@Setter
@NoArgsConstructor
public class Procedencia {

    @Id
    @GeneratedValue
    private Long procedencia_id;

    private String descripcion;
}
