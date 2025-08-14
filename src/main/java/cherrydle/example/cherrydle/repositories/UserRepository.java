package cherrydle.example.cherrydle.repositories;

import cherrydle.example.cherrydle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository  extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
