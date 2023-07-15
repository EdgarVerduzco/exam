package exam.everduzco.springboot.app.everduzco;

import exam.everduzco.springboot.app.everduzco.models.User;
import exam.everduzco.springboot.app.everduzco.repository.UserRepository;
import exam.everduzco.springboot.app.everduzco.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    void testCrearUsuario() {
        // Datos de ejemplo
        User usuario = new User(1L, "Edgar", "Verduzco", "edgar@gmail.com", LocalDate.of(1990, 1, 1));

        // Mock del repositorio para simular el guardado del usuario
        when(userRepository.save(any(User.class))).thenReturn(usuario);

        // Crear el usuario
        User nuevoUsuario = userService.createUser(usuario);

        // Verificar que el usuario se haya guardado correctamente
        Assertions.assertEquals(usuario, nuevoUsuario);
        verify(userRepository, times(1)).save(usuario);
    }

    @Test
    void testObtenerUsuarioPorId() {
        // Datos de ejemplo
        User usuario = new User(1L, "Edgar", "Verduzco", "edgar@gmail.com", LocalDate.of(1990, 1, 1));

        // Mock del repositorio para simular la obtención del usuario por ID
        when(userRepository.findById(1L)).thenReturn(Optional.of(usuario));

        // Obtener el usuario por ID
        Optional<User> resultado = Optional.ofNullable(userService.getUserById(1L));

        // Verificar que el usuario se haya obtenido correctamente
        Assertions.assertTrue(resultado.isPresent());
        Assertions.assertEquals(usuario, resultado.get());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testActualizarUsuario() {
        // Datos de ejemplo
        User usuario = new User(1L, "Edgar", "Verduzco", "edgar@gmail.com", LocalDate.of(1990, 1, 1));

        // Mock del repositorio para simular la actualización del usuario
        when(userRepository.save(any(User.class))).thenReturn(usuario);

        // Actualizar el usuario
        User usuarioActualizado = userService.updateUser(usuario);

        // Verificar que el usuario se haya actualizado correctamente
        Assertions.assertEquals(usuario, usuarioActualizado);
        verify(userRepository, times(1)).save(usuario);
    }

    @Test
    void testEliminarUsuario() {
        // Datos de ejemplo
        User usuario = new User(1L, "Edgar", "Verduzco", "edgar@gmail.com", LocalDate.of(1990, 1, 1));

        // Eliminar el usuario
        userService.deleteUSer(usuario.getId());

        // Verificar que el usuario se haya eliminado correctamente
        verify(userRepository, times(1)).delete(usuario);
    }

    @Test
    void testListarUsuarios() {
        // Datos de ejemplo
        List<User> usuarios = new ArrayList<>();
        usuarios.add(new User(1L, "Edgar", "Verduzco", "edgar@gmail.com", LocalDate.of(1990, 1, 1)));
        usuarios.add(new User(2L, "Eduardo", "Reyes", "eduardo@gmail.com", LocalDate.of(1995, 5, 10)));

        // Mock del repositorio para simular la obtención de usuarios
        when(userRepository.findAll()).thenReturn(usuarios);

        // Obtener la lista de usuarios
        List<User> resultado = userService.getAllUsers();

        // Verificar que la lista de usuarios se haya obtenido correctamente
        Assertions.assertEquals(usuarios.size(), resultado.size());
        Assertions.assertEquals(usuarios, resultado);
        verify(userRepository, times(1)).findAll();
    }

}
