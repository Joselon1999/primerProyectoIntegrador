package utp.integrador.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.integrador.avance.entity.Datos_Personales;
import utp.integrador.avance.entity.Documento;
import utp.integrador.avance.entity.Sexo;
import utp.integrador.avance.entity.User;
import utp.integrador.avance.repository.DatosPersonalesRepository;
import utp.integrador.avance.repository.DocumentoRepository;
import utp.integrador.avance.repository.SexoRepository;
import utp.integrador.avance.repository.UserRepository;
import utp.integrador.avance.service.RegisterService;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    DocumentoRepository documentoRepository;
    @Autowired
    SexoRepository sexoRepository;
    @Autowired
    DatosPersonalesRepository datosPersonalesRepository;

    @Override
    public User loginUser(User user) {
        return null;
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Documento registerDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    @Override
    public List<Documento> listDocumentos() {
        return documentoRepository.findAll();
    }

    @Override
    public Sexo registerSexo(Sexo sexo) {
        return sexoRepository.save(sexo);
    }

    @Override
    public List<Sexo> listSexo() {
        return sexoRepository.findAll();
    }

    @Override
    public Datos_Personales registerDatosPersonales(Datos_Personales personales) {
        return datosPersonalesRepository.save(personales);
    }

    @Override
    public User findUser(String email) {
        return userRepository.findByEmail(email)
                .orElse(new User());
    }
}
