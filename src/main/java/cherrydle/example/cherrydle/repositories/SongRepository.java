package cherrydle.example.cherrydle.repositories;

import cherrydle.example.cherrydle.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository <Song, Integer> {
}
