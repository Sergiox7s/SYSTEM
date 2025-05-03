/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.DAO.ActividadEmpleadoDAO;
import Modelo.DAO.CategoriaDAO;
import Modelo.DAO.EmpleadoDAO;
import Modelo.Entidades.Categoria;
import Modelo.Entidades.Empleado;
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
}
