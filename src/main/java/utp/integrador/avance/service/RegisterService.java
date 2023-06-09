package utp.integrador.avance.service;

import utp.integrador.avance.model.Datos_Personales;
import utp.integrador.avance.model.Documento;
import utp.integrador.avance.model.Sexo;
import utp.integrador.avance.model.User;

import java.util.List;

public interface RegisterService {

    User loginUser(User user);

    User registerUser(User user);

    Documento registerDocumento(Documento documento);

    List<Documento> listDocumentos();

    Sexo registerSexo(Sexo sexo);

    List<Sexo> listSexo();

    Datos_Personales registerDatosPersonales(Datos_Personales personales);

    User findUser(String email);
}
