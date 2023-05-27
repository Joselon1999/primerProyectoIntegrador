package utp.integrador.avance.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exp_laboral")
@Getter
@Setter
@NoArgsConstructor
public class Exp_Laboral {

    @Id
    @GeneratedValue
    private Long experiencia_id;

    @OneToOne
    private User user;

    @ManyToOne
    private Trabajo trabajo;
}
