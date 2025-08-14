package cherrydle.example.cherrydle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "song_of_day")
@Entity
public class SongOfDay {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String album;
    private Integer track;
    private Integer length;
    private Boolean features;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getFeatures() {
        return features;
    }

    public void setFeatures(Boolean features) {
        this.features = features;
    }
}
