package cherrydle.example.cherrydle.dto.user;

import cherrydle.example.cherrydle.roles.UserRole;

public record RegisterDTO(
        String username,
        String password,
        Integer score,
        Integer totalScore,
        String imgUrl,
        UserRole role
) {
}

