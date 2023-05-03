package utp.integrador.avance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "exp_laboral")
@Getter
@Setter
@AllArgsConstructor
public class Exp_Laboral {

    private String experiencia_id;

    private User user;

    private Estudio estudio;
}
