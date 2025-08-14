package cherrydle.example.cherrydle.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "top_users")
public class TopUsers {

    @Id
    private Integer id;

    private UUID user_id;
    private String username;
    private Integer total_score;

    public Integer getId() {
        return id;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getTotal_score() {
        return total_score;
    }
}
