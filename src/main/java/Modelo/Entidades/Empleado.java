package Modelo.Entidades;

import java.time.LocalDateTime;

public class Empleado {

    private int idEmpleado;
    private String nombre;
    private String apellido;
    private Modelo.Entidades.Categoria Categoria;
    private String estado;
    private LocalDateTime fechaEstado;
    private String celular;
    private int totalIncidentes;
    private int promedioRespuesta;
    private int id_usuario;
    //private boolean disponibilidad=false;if(disponibilidad==true){ autoasignaciondeTicketcs()}
    

    public Empleado(int idEmpleado, String nombre, String apellido, Modelo.Entidades.Categoria Categoria, String estado, LocalDateTime fechaEstado, int id_usuario) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Categoria = Categoria;
        this.estado = estado;
        this.fechaEstado = fechaEstado;
        this.id_usuario=id_usuario;
    }

    public Empleado(int idEmpleado, String nombre) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
    }

    public Empleado(int idEmpleado, String nombre, String apellido) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Empleado(int idEmpleado, String nombre, String apellido, String estado, String celular) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.estado = estado;
        this.celular = celular;
    }

    public Empleado(int idEmpleado, String nombre, String apellido, String estado, String celular, int totalIncidentes, int promedioRespuesta) {
        this(idEmpleado, nombre, apellido, estado, celular);
        this.totalIncidentes = totalIncidentes;
        this.promedioRespuesta = promedioRespuesta;
    }

    public Empleado() {
    }
    

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public Modelo.Entidades.Categoria getCategoria() {
        return Categoria;
    }

    public void setCategoria(Modelo.Entidades.Categoria Categoria) {
        this.Categoria = Categoria;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(LocalDateTime fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getTotalIncidentes() {
        return totalIncidentes;
    }

    public void setTotalIncidentes(int totalIncidentes) {
        this.totalIncidentes = totalIncidentes;
    }

    public int getPromedioRespuesta() {
        return promedioRespuesta;
    }

    public void setPromedioRespuesta(int promedioRespuesta) {
        this.promedioRespuesta = promedioRespuesta;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

}
