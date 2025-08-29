package cherrydle.example.cherrydle.repositories;

import cherrydle.example.cherrydle.model.TopUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopUsersRepository extends JpaRepository<TopUsers, Integer> {
}
