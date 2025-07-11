package Modelo.DAO;

import Modelo.Entidades.Usuario;
import Modelo.Conexion.Conexiondb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    
    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, apellido, correo, contrasena, rol) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = cn.establecerConexion();
             PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getContrasena());
            ps.setString(5, usuario.getRol());
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        usuario.setId(rs.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage());
        }
        return false;
    }

    // READ - Obtener usuario por ID
    public Usuario obtenerUsuarioPorId(int id) {
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        Usuario usuario = null;
        
        try (Connection con = cn.establecerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id_usuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    usuario.setCorreo(rs.getString("correo"));
                    usuario.setContrasena(rs.getString("contrasena"));
                    usuario.setRol(rs.getString("rol"));
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuario: " + e.getMessage());
        }
        return usuario;
    }

    // READ - Obtener todos los usuarios
    public List<Usuario> obtenerTodosUsuarios() {
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();
        
        try (Connection con = cn.establecerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setRol(rs.getString("rol"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    // UPDATE - Actualizar usuario
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuario SET nombre = ?, apellido = ?, correo = ?, contrasena = ?, rol = ? WHERE id_usuario = ?";
        
        try (Connection con = cn.establecerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getContrasena());
            ps.setString(5, usuario.getRol());
            ps.setInt(6, usuario.getId());
            
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
        }
        return false;
    }

    // DELETE - Eliminar usuario
    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        
        try (Connection con = cn.establecerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setInt(1, id);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
        }
        return false;
    }

    
    
    
}
