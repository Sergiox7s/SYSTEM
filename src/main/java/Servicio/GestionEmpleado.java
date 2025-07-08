/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Conexion.Conexiondb;
import Modelo.DAO.ActividadEmpleadoDAO;
import Modelo.DAO.CategoriaDAO;
import Modelo.DAO.EmpleadoDAO;
import Modelo.Entidades.Categoria;
import Modelo.Entidades.Empleado;
import Modelo.Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author rpasc
 */
public class GestionEmpleado {

    CategoriaDAO categoriaDao;
    EmpleadoDAO empleadoDAO;
    ActividadEmpleadoDAO actividadEmpleadoDAO;

    public GestionEmpleado() {
        empleadoDAO = new EmpleadoDAO();
        categoriaDao = new CategoriaDAO();
        actividadEmpleadoDAO = new ActividadEmpleadoDAO();
    }

    public void cargarEmpleadosPorCategoria(JComboBox<Categoria> cbCategoria, JTable tablaEmpleados) {

        Categoria categoriaSeleccionada = (Categoria) cbCategoria.getSelectedItem();

        if (categoriaSeleccionada != null) {
            String nombreCategoria = categoriaSeleccionada.getNombre();
            int idCategoria = categoriaDao.obtenerIdCategoriaPorNombre(nombreCategoria);

            if (idCategoria != -1) {
                empleadoDAO.mostrarEmpleadosPorCategoria(idCategoria, tablaEmpleados);
            }
        }
    }

    public Empleado obtenerDetallesEmpleado(String nombreCompleto) {
        String[] nombreEmpleado = nombreCompleto.split(" ");
        if (nombreEmpleado.length >= 2) {
            String nombre = nombreEmpleado[0];
            String apellido = nombreEmpleado[1];
            Empleado empleado = empleadoDAO.obtenerDatosEmpleado(nombre, apellido);
            if (empleado != null) {

                int totalIncidentes = actividadEmpleadoDAO.obtenerTotalIncidentesAsignados(empleado.getIdEmpleado());
                int promedioRespuesta = actividadEmpleadoDAO.obtenerTiempoPromedioRespuesta(empleado.getIdEmpleado());

                return new Empleado(empleado.getIdEmpleado(), empleado.getNombre(), empleado.getApellido(),
                        empleado.getEstado(), empleado.getCelular(), totalIncidentes, promedioRespuesta);
            }
        }
        return null;
    }

    public List<Object[]> obtenerIncidentesPorEmpleado(String nombreCompleto) {
        int idEmpleado = actividadEmpleadoDAO.obtenerIdEmpleadoPorNombre(nombreCompleto);

        return actividadEmpleadoDAO.mostrarHistorialPorEmpleado(idEmpleado);
    }

    public Usuario obtenerUsuarioPorEmpleado(int idEmpleado) {
        Conexiondb conexion = new Conexiondb();
        Connection con = conexion.establecerConexion();
        Usuario usuario = null;

        if (con != null) {
            String query = "SELECT u.* FROM usuario u JOIN empleado e ON u.id_usuario = e.id_usuario WHERE e.id_empleado = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, idEmpleado);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setId(rs.getInt("id_usuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));
                    // Otros campos necesarios
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarConexion();
            }
        }
        return usuario;
    }

}
