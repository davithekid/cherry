package cherrydle.example.cherrydle.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "song_of_day")
@Entity
public class SongOfDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relacionamento com a tabela songs
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "song_id", nullable = false)
    private Songs song;

    // Data em que a música foi sorteada (opcional, útil para histórico)
    private LocalDate date = LocalDate.now();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Songs getSong() {
        return song;
    }

    public void setSong(Songs song) {
        this.song = song;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
