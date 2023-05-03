package utp.integrador.avance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_sede")
@Getter
@Setter
@AllArgsConstructor
public class User_Sede {

    @Id
    @GeneratedValue
    private Long id;

    private Sede sede;

    private User user;

    private Procedencia procedencia;
}
