package Servicio;

import Modelo.Entidades.Usuario;

public class Session {
    public static Usuario usuarioActual;

    public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }
}