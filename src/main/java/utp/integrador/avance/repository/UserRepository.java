package utp.integrador.avance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.integrador.avance.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String Email);
}

