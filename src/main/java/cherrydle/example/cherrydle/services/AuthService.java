package cherrydle.example.cherrydle.services;

import cherrydle.example.cherrydle.dto.user.AuthenticationDTO;
import cherrydle.example.cherrydle.dto.user.LoginResponseDTO;
import cherrydle.example.cherrydle.dto.user.RegisterDTO;
import cherrydle.example.cherrydle.infra.security.TokenService;
import cherrydle.example.cherrydle.model.User;
import cherrydle.example.cherrydle.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

// arquivo de autenticação de tokens
@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    // service para logar o user
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    // service para registrar um novo user
    public ResponseEntity<?> register(RegisterDTO data) {

        // verifica se o username já existe
        if (repository.findByUsername(data.username()) != null) {
            return ResponseEntity.badRequest().body("Username já existe");
        }

        // criptografa a senha
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());

        // cria o usuário
        User newUser = new User(
                data.username(),
                encryptedPassword,
                data.role(),
                data.score(),
                data.totalScore(),
                data.imgUrl()
        );
        repository.save(newUser);

        return ResponseEntity.ok("Usuário cadastrado com sucesso");
    }


}
