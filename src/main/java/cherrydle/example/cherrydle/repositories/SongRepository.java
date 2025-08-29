package cherrydle.example.cherrydle.repositories;

import cherrydle.example.cherrydle.model.Songs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface SongRepository extends JpaRepository<Songs, Integer> {

    // Buscar música pelo nome exato
    Optional<Songs> findByNameIgnoreCase(String name);

    // Sortear uma música aleatória
    @Query(value = "SELECT * FROM songs ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Songs findRandomSong();
}
