package utp.integrador.avance.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "est_profesional")
@Getter
@Setter
@NoArgsConstructor
public class Est_Profesional {

    @Id
    @GeneratedValue
    private Long profesion_id;

    @OneToOne
    private User user;

    @ManyToOne
    private Estudio estudio;
}
