package cherrydle.example.cherrydle.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Table(name = "guesses")
@Entity
public class Guesses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relacionamento com SongOfDay / partida
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id", nullable = false)
    private SongOfDay game;

    // Usuário que fez o chute
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Música que o usuário chutou
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "song_guess_id", nullable = false)
    private Songs songGuess;

    // Resultado do chute (cores: GREEN, YELLOW, RED)
    @Column(columnDefinition = "JSON")
    private String result;

    // Timestamp da tentativa
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SongOfDay getGame() {
        return game;
    }

    public void setGame(SongOfDay game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Songs getSongGuess() {
        return songGuess;
    }

    public void setSongGuess(Songs songGuess) {
        this.songGuess = songGuess;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
