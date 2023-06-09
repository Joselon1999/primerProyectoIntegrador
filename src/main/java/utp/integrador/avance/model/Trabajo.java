package utp.integrador.avance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "trabajo")
@Getter
@Setter
@NoArgsConstructor
public class Trabajo {

    @Id
    @GeneratedValue
    private Long id;

    private String cargo;

    private String tiempo_inicio;

    private String timpo_final;
}
