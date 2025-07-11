package Modelo.DAO;

import Modelo.Conexion.Conexiondb;
import Modelo.Entidades.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAO {

    // Consultas SQL
    private final String OBTENER_ID_CATEGORIA = "SELECT id_categoria FROM categoria WHERE nombre = ?";
    private final String LISTAR_CATEGORIAS = "SELECT * FROM categoria";
    private final String OBTENER_CATEGORIA_POR_ID = "SELECT nombre FROM categoria WHERE id_categoria = ?";
    private final String OBTENER_CATEGORIA_POR_EMPLEADO = "SELECT c.nombre FROM categoria c JOIN empleado e ON c.id_categoria = e.id_categoria WHERE e.id_empleado = ?";

    private final Conexiondb conexion;

    public CategoriaDAO() {
        conexion = new Conexiondb();
    }

    // Método para obtener ID de categoría por nombre
    public int obtenerIdCategoriaPorNombre(String nombreCategoria) {
        int idCategoria = -1;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = conexion.establecerConexion();
            stmt = con.prepareStatement(OBTENER_ID_CATEGORIA);
            stmt.setString(1, nombreCategoria);
            rs = stmt.executeQuery();

            if (rs.next()) {
                idCategoria = rs.getInt("id_categoria");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener ID de categoría: " + e.getMessage());
        } finally {
            cerrarRecursos(con, stmt, rs);
        }
        return idCategoria;
    }

    // Método para obtener nombre de categoría por ID
    public String obtenerNombreCategoriaPorId(int idCategoria) {
        String nombre = "";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = conexion.establecerConexion();
            stmt = con.prepareStatement(OBTENER_CATEGORIA_POR_ID);
            stmt.setInt(1, idCategoria);
            rs = stmt.executeQuery();

            if (rs.next()) {
                nombre = rs.getString("nombre");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener nombre de categoría: " + e.getMessage());
        } finally {
            cerrarRecursos(con, stmt, rs);
        }
        return nombre;
    }

    // Método para obtener categoría de un empleado específico
    public String obtenerCategoriaPorEmpleado(int idEmpleado) {
        String categoria = "";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = conexion.establecerConexion();
            stmt = con.prepareStatement(OBTENER_CATEGORIA_POR_EMPLEADO);
            stmt.setInt(1, idEmpleado);
            rs = stmt.executeQuery();

            if (rs.next()) {
                categoria = rs.getString("nombre");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener categoría del empleado: " + e.getMessage());
        } finally {
            cerrarRecursos(con, stmt, rs);
        }
        return categoria;
    }

    // Método para listar todas las categorías
    public List<Categoria> obtenerListaCategorias() {
        List<Categoria> listaCategorias = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            con = conexion.establecerConexion();
            stmt = con.prepareStatement(LISTAR_CATEGORIAS);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));
                listaCategorias.add(categoria);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener lista de categorías: " + e.getMessage());
        } finally {
            cerrarRecursos(con, stmt, rs);
        }
        return listaCategorias;
    }

    // Método para cerrar recursos (sobrecargado)
    private void cerrarRecursos(Connection con, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                conexion.cerrarConexion();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
        }
    }

    private void cerrarRecursos(Connection con, PreparedStatement stmt) {
        cerrarRecursos(con, stmt, null);
    }

    public boolean agregarCategoria(Categoria categoria) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean resultado = false;

        try {
            con = conexion.establecerConexion();
            stmt = con.prepareStatement("INSERT INTO categoria (nombre) VALUES (?)", 
                                       PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, categoria.getNombre());
            
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    categoria.setIdCategoria(rs.getInt(1));
                    resultado = true;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar categoría: " + e.getMessage());
        } finally {
            cerrarRecursos(con, stmt, rs);
        }
        return resultado;
    }

    public boolean actualizarCategoria(Categoria categoria) {
        Connection con = null;
        PreparedStatement stmt = null;
        boolean resultado = false;

        try {
            con = conexion.establecerConexion();
            stmt = con.prepareStatement("UPDATE categoria SET nombre = ? WHERE id_categoria = ?");
            stmt.setString(1, categoria.getNombre());
            stmt.setInt(2, categoria.getIdCategoria());
            
            int affectedRows = stmt.executeUpdate();
            resultado = affectedRows > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar categoría: " + e.getMessage());
        } finally {
            cerrarRecursos(con, stmt);
        }
        return resultado;
    }

    public boolean eliminarCategoria(int id) {
        Connection con = null;
        PreparedStatement stmt = null;
        boolean resultado = false;

        try {
            con = conexion.establecerConexion();
            stmt = con.prepareStatement("DELETE FROM categoria WHERE id_categoria = ?");
            stmt.setInt(1, id);
            
            int affectedRows = stmt.executeUpdate();
            resultado = affectedRows > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar categoría: " + e.getMessage());
        } finally {
            cerrarRecursos(con, stmt);
        }
        return resultado;
    }
    
  
    public Categoria obtenerCategoriaPorId(int id) {
    Categoria categoria = null;
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        con = conexion.establecerConexion();
        stmt = con.prepareStatement("SELECT * FROM categoria WHERE id_categoria = ?");
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        if (rs.next()) {
            categoria = new Categoria();
            categoria.setIdCategoria(rs.getInt("id_categoria"));
            categoria.setNombre(rs.getString("nombre"));
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener categoría: " + e.getMessage());
    } finally {
        cerrarRecursos(con, stmt, rs);
    }
    return categoria;
}
    
    
    
    
}
