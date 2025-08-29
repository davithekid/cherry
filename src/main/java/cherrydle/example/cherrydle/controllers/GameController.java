package cherrydle.example.cherrydle.controllers;

import cherrydle.example.cherrydle.model.SongOfDay;
import cherrydle.example.cherrydle.model.User;
import cherrydle.example.cherrydle.services.GameService;
import cherrydle.example.cherrydle.services.GuessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/game") // rota base do game
public class GameController {

    @Autowired
    private GameService gameService; // service que controla a criação do jogo

    @Autowired
    private GuessService guessService; // service que processa os chutes

    // criar um novo jogo
    @PostMapping("/new")
    public Map<String, Object> newGame(@AuthenticationPrincipal User user) {
        // chama o service pra criar o jogo e pegar a musica do dia
        SongOfDay game = gameService.startNewGame();

        // retorna o id do jogo e mensagem pro usuário
        return Map.of(
                "gameId", game.getId(),
                "message", "Jogo iniciado, você tem 10 tentativas"
        );
    }

    // enviar um chute
    @PostMapping("/{gameId}/guess")
    public Map<String, Object> guess(
            @PathVariable Integer gameId, // id do jogo atual
            @RequestBody Map<String, String> payload, // chute enviado pelo usuário
            @AuthenticationPrincipal User user // usuário logado
    ) throws Exception {
        // pega o jogo pelo id
        SongOfDay game = gameService.getGame(gameId);

        // pega o nome da música chutada
        String nameGuess = payload.get("name");

        // chama o service que processa o chute e retorna resultado
        return guessService.processGuess(game, user, nameGuess);
    }
}
