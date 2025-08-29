package cherrydle.example.cherrydle.services;

import cherrydle.example.cherrydle.model.SongOfDay;
import cherrydle.example.cherrydle.model.Songs;
import cherrydle.example.cherrydle.repositories.SongOfDayRepository;
import cherrydle.example.cherrydle.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private SongRepository songRepo; // repository que acessa a tabela de músicas

    @Autowired
    private SongOfDayRepository songOfDayRepo; // repository que acessa a música do dia

    // cria um novo jogo com música aleatória
    public SongOfDay startNewGame() {
        // pega uma música aleatória usando método customizado do repository
        Songs randomSong = songRepo.findRandomSong();

        // cria um objeto SongOfDay pra armazenar a música do jogo
        SongOfDay game = new SongOfDay();
        game.setSong(randomSong);

        // salva o jogo no banco
        songOfDayRepo.save(game);

        // retorna o jogo criado
        return game;
    }

    // pega um jogo existente pelo id
    public SongOfDay getGame(Integer gameId) {
        // busca no banco, se não encontrar lança exceção
        return songOfDayRepo.findById(gameId)
                .orElseThrow(() -> new RuntimeException("Game não encontrado"));
    }
}
