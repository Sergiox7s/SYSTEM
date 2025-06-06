package Modelo.Entidades;

public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String rol;

    public Usuario(int id, String nombre, String apellido, String correo, String contrasena, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public Usuario(String nombre, String apellido, String correo, String contrasena, String rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Usuario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Usuario(String contrasena) {
        this.contrasena = contrasena;
    }
    public Usuario(int id, String nombre, String apellido) {
    this.id = id;
    this.nombre = (nombre != null) ? nombre : "Nombre no disponible";  // Asignar un valor por defecto si es null
    this.apellido = (apellido != null) ? apellido : "Apellido no disponible";  // Asignar un valor por defecto si es null
}

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", contrasena=" + contrasena + ", rol=" + rol + '}';
    }
}
