package utp.integrador.avance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long user_id;

    private String email;

    private String password;

}
