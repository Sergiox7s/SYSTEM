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
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) conexion.cerrarConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar recursos: " + e.getMessage());
        }
    }

    private void cerrarRecursos(Connection con, PreparedStatement stmt) {
        cerrarRecursos(con, stmt, null);
    }
}