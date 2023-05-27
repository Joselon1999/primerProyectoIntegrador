package utp.integrador.avance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "datos_personales")
@Getter
@Setter
@NoArgsConstructor
public class Datos_Personales {

    @Id
    @GeneratedValue
    private Long personales_id;

    @ManyToOne
    private Documento documento;

    private String numero_documento;

    private String nombres;

    private String paterno;

    private String materno;

    @ManyToOne
    private Sexo sexo;

    private String telef_fijo;

    private String celular;

    @OneToOne
    private User user;

    @Override
    public String toString() {
        return documento.getDescripcion()+ " " + sexo.getDescripcion();
    }
}
