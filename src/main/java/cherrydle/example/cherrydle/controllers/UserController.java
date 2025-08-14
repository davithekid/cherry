package cherrydle.example.cherrydle.controllers;

import cherrydle.example.cherrydle.dto.user.RequestDTO;
import cherrydle.example.cherrydle.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<RequestDTO> getAllUsers(){
        return service.getAll();
    }
}
