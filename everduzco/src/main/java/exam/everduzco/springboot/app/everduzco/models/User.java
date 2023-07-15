package exam.everduzco.springboot.app.everduzco.models;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class User {
    private Long id;
    private String nombre;
    private String apellido;

    private String correoElectronico;
    private LocalDate fechaNacimiento;

    public User(Long id, String nombre, String apellido, String correoElectronico, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        if (!esCorreoElectronicoValido(correoElectronico)) {
            throw new IllegalArgumentException("El correo electrónico no es válido");
        }
        this.correoElectronico = correoElectronico;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (!esMayorDeEdad(fechaNacimiento)) {
            throw new IllegalArgumentException("La fecha de nacimiento debe ser mayor a 18 años");
        }
        this.fechaNacimiento = fechaNacimiento;
    }

    private boolean esCorreoElectronicoValido(String correoElectronico) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(correoElectronico).matches();
    }

    private boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaNacimientoMas18 = fechaNacimiento.plusYears(18);
        return fechaNacimientoMas18.isBefore(fechaActual);
    }
}
