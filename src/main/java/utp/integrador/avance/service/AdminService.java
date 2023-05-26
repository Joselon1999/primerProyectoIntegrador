package utp.integrador.avance.service;

import utp.integrador.avance.entity.*;

import java.util.List;

public interface AdminService {

    List<User> getAllUsers();

    Datos_Personales getUserDatosPersonales(int userId);

    List<Estudio> findAllByUserEmail(String email);

    List<Trabajo> getAllTrabajo(String email);

    void updateUserStatus(String email,String status);
}

