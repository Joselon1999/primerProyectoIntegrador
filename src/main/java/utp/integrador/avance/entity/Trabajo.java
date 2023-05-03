package utp.integrador.avance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "trabajo")
@Getter
@Setter
@AllArgsConstructor
public class Trabajo {

    private String trabajo_id;

    private String cargo;

    private Date tiempo_inicio;

    private Date timpo_final;
}
