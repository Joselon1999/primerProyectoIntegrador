package utp.integrador.avance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "est_profesional")
@Getter
@Setter
@AllArgsConstructor
public class Est_Profesional {

    private String profesion_id;

    private User user;

    private Estudio estudio;
}
