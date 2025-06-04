package Servicio;

import Modelo.Entidades.Incidente;
import Modelo.DAO.IncidenteDAO;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GestionIncidente {

    private IncidenteDAO incidenteDAO;
    private Queue<Incidente> colaIncidentesPendientes;

    public GestionIncidente() {
        incidenteDAO = new IncidenteDAO();
        colaIncidentesPendientes = new LinkedList<>();
    }

    public Queue<Incidente> cargarIncidenciasPendientes() {
        colaIncidentesPendientes.clear();
        colaIncidentesPendientes = incidenteDAO.cargarIncidentesPendientes();
        return colaIncidentesPendientes;
    }

    public Queue<Incidente> getColaIncidentesPendientes() {
        if (colaIncidentesPendientes.isEmpty()) {
            cargarIncidenciasPendientes();
        }
        return colaIncidentesPendientes;
    }

    public boolean asignarTicketAEmpleado(int ticketID, int empleadoID) {
        boolean asignado = incidenteDAO.asignarTicket(ticketID, empleadoID);
        if (asignado) {
            cargarIncidenciasPendientes();
        }
        return asignado;
    }

    public int obtenerConteoIncidentesAsignados() {
        return incidenteDAO.obtenerConteoIncidentesAsignados();
    }

    public int obtenerConteoIncidentesAsignadosPorUsuario(int idUsuario) {
        return incidenteDAO.obtenerConteoIncidentesAsignadosPorUsuario(idUsuario);
    }

    public List<Incidente> obtenerIncidentesAsignadosPorUsuario(int idUsuario) {
        return incidenteDAO.obtenerIncidentesAsignadosPorUsuario(idUsuario);
    }

    public int obtenerConteoIncidentesFinalizados() {
        return incidenteDAO.obtenerConteoIncidentesFinalizados();
    }

    public Incidente obtenerIncidentePorId(int idTicket) {
        return incidenteDAO.obtenerIncidentePorId(idTicket);
    }

    /**
     * ********* Vista Metricas
     */
    public int obtenerTotalIncidentes() {
        return incidenteDAO.obtenerTotalIncidentes();
    }

    public int obtenerTotalIncidentesDia() {
        return incidenteDAO.obtenerIncidentesDia();
    }

    public int obtenerIncidentesEnCurso() {
        return incidenteDAO.obtenerIncidentesEnCurso();
    }

    public int obtenerEmpleadosDisponibles() {
        return incidenteDAO.obtenerEmpleadosDisponibles();
    }

    public String convertirFormatoTiempo(int segundosTotales) {

        int horas = segundosTotales / 3600;
        int minutos = (segundosTotales % 3600) / 60;
        int segundos = segundosTotales % 60;

        return String.format("%02dH %02dM %02dS", horas, minutos, segundos);
    }

    public String obtenerTiempoPromedio() {
        int tiempoPromedioSegundos = incidenteDAO.obtenerTiempoPromedio();
        String tiempoFormateado = convertirFormatoTiempo(tiempoPromedioSegundos);
        return tiempoFormateado;
    }

}
