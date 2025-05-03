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

    private final String OBTENER_ID_CATEGORIA = "SELECT id_categoria FROM categoria WHERE nombre = ?";
    private final String LISTAR_CATEGORIAS = "SELECT * FROM categoria";

    Conexiondb conexion = new Conexiondb();

    public int obtenerIdCategoriaPorNombre(String nombreCategoria) {
        int idCategoria = -1;

        Connection con = conexion.establecerConexion();

        try (PreparedStatement stmt = con.prepareStatement(OBTENER_ID_CATEGORIA)) {
            stmt.setString(1, nombreCategoria);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                idCategoria = rs.getInt("id_categoria");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la categoría: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }
        return idCategoria;
    }

    public List<Categoria> obtenerListaCategorias() {
        List<Categoria> listaCategorias = new ArrayList<>();

        try (Connection con = conexion.establecerConexion(); PreparedStatement ps = con.prepareStatement(LISTAR_CATEGORIAS); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("nombre"));
                listaCategorias.add(categoria);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener categorias: " + e.getMessage());
        }

        return listaCategorias;
    }
}
