package cherrydle.example.cherrydle.repositories;

import cherrydle.example.cherrydle.model.SongOfDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongOfDayRepository extends JpaRepository<SongOfDay, Integer> {
}
