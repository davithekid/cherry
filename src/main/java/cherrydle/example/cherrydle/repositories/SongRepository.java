package cherrydle.example.cherrydle.repositories;

import cherrydle.example.cherrydle.model.Songs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository <Songs, Integer> {
}
