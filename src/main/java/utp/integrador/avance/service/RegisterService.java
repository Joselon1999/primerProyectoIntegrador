package utp.integrador.avance.service;

import utp.integrador.avance.entity.User;

public interface RegisterService {

    User loginUser(User user);

    User registerUser(User user);
}
