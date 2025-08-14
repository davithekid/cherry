package cherrydle.example.cherrydle.dto.user;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank String username,
        @NotBlank String password
) {}
