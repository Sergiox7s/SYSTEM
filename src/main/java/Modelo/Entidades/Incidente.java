package Modelo.Entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Incidente {

    private int idTicket;
    private Categoria categoria;
    private String Descripcion;
    private String celular;
    private String aula;
    private String estado;
    private LocalDate fechaReporte;
    private LocalTime horaReporte;
    private Usuario solicita;
    private Empleado asignadoA;

    public Usuario getSolicita() {
        return solicita;
    }

    public Empleado getAsignadoA() {
        return asignadoA;
    }

    public Incidente() {
    }

    public Incidente(int idTicket, String estado) {
        this.idTicket = idTicket;
        this.estado = estado;
    }

    public Incidente(int idTicket, Categoria categoria, String Descripcion, String celular,
            String aula, String estado, LocalDate fechaReporte, LocalTime horaReporte, Usuario docente, Empleado empleadoAsignado) {

        this.idTicket = idTicket;
        this.categoria = categoria;
        this.Descripcion = Descripcion;
        this.celular = celular;
        this.aula = aula;
        this.estado = estado;
        this.fechaReporte = fechaReporte;
        this.horaReporte = horaReporte.withNano(0);
        this.solicita = docente;
        this.asignadoA = empleadoAsignado;
    }

    public Incidente(int idTicket, Categoria categoria, String Descripcion, String celular,
            String aula, String estado, LocalDate fechaReporte, LocalTime horaReporte,
            Usuario docente) {
        this.idTicket = idTicket;
        this.categoria = categoria;
        this.Descripcion = Descripcion;
        this.celular = celular;
        this.aula = aula;
        this.estado = estado;
        this.fechaReporte = fechaReporte;
        this.horaReporte = horaReporte.withNano(0);
        this.solicita = docente;
        this.asignadoA = null;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public LocalTime getHoraReporte() {
        return horaReporte;
    }

    public void setHoraReporte(LocalTime horaReporte) {
        this.horaReporte = horaReporte;
    }

    public Usuario getDocente() {
        return solicita;
    }

    public void setDocente(Usuario docente) {
        this.solicita = docente;
    }

    public Empleado getEmpleadoAsignado() {
        return asignadoA;
    }

    public void setEmpleadoAsignado(Empleado empleadoAsignado) {
        this.asignadoA = empleadoAsignado;
    }
}
