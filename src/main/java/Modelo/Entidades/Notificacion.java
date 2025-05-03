package Modelo.Entidades;

import java.time.LocalDateTime;

public class Notificacion {

    private int idNotificacion; // o Long idNotificacion;
    private Incidente incidente;
    private Usuario usuario;
    private String mensaje;
    private LocalDateTime fechaEnvio;
    private String estado;

    public Notificacion(int idNotificacion, Incidente incidente, Usuario usuario, String mensaje, LocalDateTime fechaEnvio, String estado) {
        this.idNotificacion = idNotificacion;
        this.incidente = incidente;
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.estado = estado;
    }

    public int getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(int idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public Incidente getIncidente() {
        return incidente;
    }

    public void setIncidente(Incidente incidente) {
        this.incidente = incidente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
