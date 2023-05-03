package utp.integrador.avance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "datos_personales")
@Getter
@Setter
@AllArgsConstructor
public class Datos_Personales {

    @Id
    @GeneratedValue
    private Long personales_id;

    private Documento documento;

    private String numero_documento;

    private String nombres;

    private String paterno;

    private String materno;

    private Sexo sexo;

    private String telef_fijo;

    private String celular;

    private User user;
}
