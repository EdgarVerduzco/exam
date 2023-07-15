package exam.everduzco.springboot.app.everduzco.models;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

class UsuarioTest {
    User usuario;

    @Test
    @BeforeEach
    void generarUsuario(){
        // Crear un usuario de ejemplo
         usuario = new User(1L, "Edgar", "Verduzco", "edgar@gmailcom", LocalDate.of(1990, 1, 1));
    }

    @Test
    @Tag("accessors")
    void getId() {
        // Verificar que el ID sea correcto
        assertEquals(1L, usuario.getId());
    }

    @Test
    @Tag("accessors")
    void setId() {
        // Configurar el ID
        usuario.setId(1L);

        // Verificar que el ID se haya configurado correctamente
        assertEquals(1L, usuario.getId());
    }

    @Test
    @Tag("accessors")
    void getNombre() {
        // Verificar que el nombre sea correcto
        assertEquals("Edgar", usuario.getNombre());
    }

    @Test
    @Tag("accessors")
    void setNombre() {
        // Configurar el nombre
        usuario.setNombre("Edgar");

        // Verificar que el nombre se haya configurado correctamente
        assertEquals("Edgar", usuario.getNombre());
    }

    @Test
    void getApellido() {
        // Verificar que el apellido sea correcto
        assertEquals("Verduzco", usuario.getApellido());
    }

    @Test
    void setApellido() {
        // Configurar el apellido
        usuario.setApellido("Verduzco");

        // Verificar que el apellido se haya configurado correctamente
        assertEquals("Verduzco", usuario.getApellido());
    }

    @Test
    void getCorreoElectronico() {
        // Verificar que el correo electrónico sea correcto
        assertEquals("edgar@gmailcom", usuario.getCorreoElectronico());
    }

    @Test
    void setCorreoElectronico() {
        // Configurar el correo electrónico
        usuario.setCorreoElectronico("edgar@gmailcom");

        // Verificar que el correo electrónico se haya configurado correctamente
        assertEquals("edgar@gmailcom", usuario.getCorreoElectronico());
    }

    @Test
    void getFechaNacimiento() {
        LocalDate fechaNacimiento = LocalDate.of(1990, 1, 1);
        // Verificar que la fecha de nacimiento sea correcta
        assertEquals(fechaNacimiento, usuario.getFechaNacimiento());
    }

    @Test
    void setFechaNacimiento() {
        // Configurar la fecha de nacimiento
        LocalDate fechaNacimiento = LocalDate.of(1990, 1, 1);
        usuario.setFechaNacimiento(fechaNacimiento);

        // Verificar que la fecha de nacimiento se haya configurado correctamente
        assertEquals(fechaNacimiento, usuario.getFechaNacimiento());
    }

    @RepeatedTest(3)
    @Tag("repeated")
    void setIdRepeat() {
        // Incrementar el contador de ID
        long newId = getNextId();

        // Establecer el nuevo ID en el usuario
        usuario.setId(newId);

        // Verificar que el ID se haya establecido correctamente
        Assertions.assertEquals(newId, usuario.getId());
    }

    // Variable de contador de ID
    private static long idCounter = 1;

    // Método para obtener un nuevo ID único
    private synchronized long getNextId() {
        return ++idCounter + 'L';
    }
}