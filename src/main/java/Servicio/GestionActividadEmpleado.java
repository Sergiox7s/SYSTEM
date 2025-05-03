package Servicio;

import Modelo.DAO.ActividadEmpleadoDAO;
import javax.swing.JTable;


public class GestionActividadEmpleado {

    private final ActividadEmpleadoDAO actividadEmpleadoDAO;

    public GestionActividadEmpleado() {
        this.actividadEmpleadoDAO = new ActividadEmpleadoDAO();
    }

    public void actualizarTablaAsignados(JTable tableColaAsignados) {
        actividadEmpleadoDAO.actualizarTablaAsignados(tableColaAsignados);
    }
    
    
}