package cherrydle.example.cherrydle.repositories;

import cherrydle.example.cherrydle.model.Guesses;
import cherrydle.example.cherrydle.model.SongOfDay;
import cherrydle.example.cherrydle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GuessesRepository extends JpaRepository<Guesses, Integer> {

    int countByGameAndUser(SongOfDay game, User user);

    List<Guesses> findByGame(SongOfDay game);

    Optional<Guesses> findByGameAndUserAndId(SongOfDay game, User user, Integer guessId);
}
