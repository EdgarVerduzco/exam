package exam.everduzco.springboot.app.everduzco.services;

import exam.everduzco.springboot.app.everduzco.repository.UserRepository;
import exam.everduzco.springboot.app.everduzco.models.User;
import exam.everduzco.springboot.app.everduzco.models.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public User createUser(@RequestBody User usuario) {
        return userRepository.save(usuario);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con ID: " + id));
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User usuario) {
        User usuarioExistente = userRepository.findById(usuario.getId())
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con ID: " + usuario.getId()));

        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido(usuario.getApellido());
        usuarioExistente.setCorreoElectronico(usuario.getCorreoElectronico());
        usuarioExistente.setFechaNacimiento(usuario.getFechaNacimiento());

        return userRepository.save(usuarioExistente);
    }

    @DeleteMapping("/{id}")
    public void deleteUSer(@PathVariable Long id) {
        User usuario = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con ID: " + id));

        userRepository.delete(usuario);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}