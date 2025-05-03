package Modelo.DAO;

import Modelo.Entidades.Usuario;
import Modelo.Conexion.Conexiondb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private final Conexiondb cn = new Conexiondb();

    public void registrarUsuario(String nombre, String apellido, String correo, String contrasena, String rol) {
        String sql = "INSERT INTO usuario (nombre, apellido, correo, contrasena, rol) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = cn.establecerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, correo);
            ps.setString(4, contrasena);
            ps.setString(5, rol);
            ps.executeUpdate();
            System.out.println("Usuario registrado con éxito.");
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.err.println("Error durante el registro del usuario: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error durante el registro del usuario: " + e.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Usuario verificarUsuario(String correo, String contrasena) {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE correo = ?";

        try {
            con = cn.establecerConexion();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, correo);
                rs = ps.executeQuery();

                if (rs.next()) {
                    String contrasenaGuardada = rs.getString("contrasena");

                    if (contrasena.equals(contrasenaGuardada)) {
                        usuario = new Usuario();
                        usuario.setId(rs.getInt("id_usuario"));
                        usuario.setNombre(rs.getString("nombre"));
                        usuario.setApellido(rs.getString("apellido"));
                        usuario.setCorreo(rs.getString("correo"));
                        usuario.setRol(rs.getString("rol"));
                        usuario.setContrasena(contrasenaGuardada);
                    } else {
                        System.out.println("Contraseña incorrecta.");

                    }
                } else {
                    System.out.println("No se encontró ningún usuario con ese correo.");

                }
            } else {
                System.err.println("No se pudo establecer conexión con la base de datos.");

            }
        } catch (SQLException e) {
            System.err.println("Error durante la obtención del usuario: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Error durante la obtención del usuario: " + e.getMessage(), "Error de base de datos", JOptionPane.ERROR_MESSAGE);
        } finally {
            cn.cerrarConexion();
        }
        return usuario;
    }

}
