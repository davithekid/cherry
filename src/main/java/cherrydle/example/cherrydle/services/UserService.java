package cherrydle.example.cherrydle.services;

import cherrydle.example.cherrydle.dto.user.RequestDTO;
import cherrydle.example.cherrydle.model.User;
import cherrydle.example.cherrydle.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    // método get
    public List<RequestDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(RequestDTO::new)
                .toList();
    }

    // método get por id
    public RequestDTO getUserById(UUID id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new RequestDTO(user);
    }

}
