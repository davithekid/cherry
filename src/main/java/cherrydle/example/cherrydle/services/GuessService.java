package cherrydle.example.cherrydle.services;

import cherrydle.example.cherrydle.model.Guesses;
import cherrydle.example.cherrydle.model.SongOfDay;
import cherrydle.example.cherrydle.model.Songs;
import cherrydle.example.cherrydle.model.User;
import cherrydle.example.cherrydle.repositories.GuessesRepository;
import cherrydle.example.cherrydle.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GuessService {

    @Autowired
    private GuessesRepository guessesRepo; // repository que salva e busca os chutes

    @Autowired
    private UserRepository userRepo; // repository que atualiza a pontuação do usuário

    // processa um chute do usuário
    public Map<String, Object> processGuess(SongOfDay game, User user, String guessName) throws Exception {
        // pega a música correta do jogo
        Songs songGuess = game.getSong(); // simplificado, pode buscar por name se quiser

        // compara o chute com o nome da música (ignora maiúsculas/minúsculas)
        String resultColor = songGuess.getName().equalsIgnoreCase(guessName) ? "GREEN" : "RED";

        // cria objeto de resultado (vai pro json)
        Map<String,String> result = Map.of("name", resultColor);

        // criar registro da tentativa no banco
        Guesses guess = new Guesses();
        guess.setGame(game);
        guess.setUser(user);
        guess.setSongGuess(songGuess);
        guess.setResult(new ObjectMapper().writeValueAsString(result)); // salva como json
        guessesRepo.save(guess);

        // calcula quantas tentativas ainda restam (10 tentativas por padrão)
        int remainingAttempts = 10 - guessesRepo.countByGameAndUser(game, user);

        // se acertou, atualiza pontuação
        if ("GREEN".equals(resultColor)) {
            user.setScore(user.getScore() + remainingAttempts * 10); // pontuação simples
            user.setTotal_score(user.getTotal_score() + remainingAttempts * 10);
            userRepo.save(user); // salva no banco
        }

        // retorna resultado pro front-end
        return Map.of(
                "result", result,
                "remainingAttempts", remainingAttempts,
                "message", "Tentativa registrada!"
        );
    }
}
