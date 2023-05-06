package utp.integrador.avance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.integrador.avance.entity.User;
import utp.integrador.avance.repository.UserRepository;
import utp.integrador.avance.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User loginUser(User user) {
        return null;
    }

    @Override
    public User registerUser(User user) {
        return null;
    }
}
