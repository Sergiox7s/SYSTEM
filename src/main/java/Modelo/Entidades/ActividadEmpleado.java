package Modelo.Entidades;

import java.time.LocalDateTime;

public class ActividadEmpleado {

    private int idActividad;
    private Empleado empleado;
    private Modelo.Entidades.Incidente incidente;
    private LocalDateTime fechaAsignacion;
    private LocalDateTime fechaResolucion;

    public ActividadEmpleado(int idActividad, Empleado empleado, Modelo.Entidades.Incidente incidente, LocalDateTime fechaAsignacion, LocalDateTime fechaResolucion) {
        this.idActividad = idActividad;
        this.empleado = empleado;
        this.incidente = incidente;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaResolucion = fechaResolucion;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Modelo.Entidades.Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Modelo.Entidades.Incidente incidente) {
        this.incidente = incidente;
    }

    public LocalDateTime getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDateTime fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }
}
