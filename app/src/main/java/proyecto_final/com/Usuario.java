package proyecto_final.com;

public class Usuario {

    String nombre, apellido, correo, contraseña;

    public Usuario(String nombre, String apellido, String correo, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() { return correo;
    }

    public String getContraseña() {
        return contraseña;
    }
}
