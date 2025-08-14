package cherrydle.example.cherrydle.dto.user;

import cherrydle.example.cherrydle.model.User;
import cherrydle.example.cherrydle.roles.UserRole;

import java.util.UUID;

public record RequestDTO (UUID id, String username, String password, Integer score, Integer total_score, String img_url, UserRole role) {
    public RequestDTO(User user) {
        this(user.getId(), user.getUsername(), user.getPassword(), user.getScore(), user.getTotal_score(), user.getImg_url(), user.getRole());
    }
}


