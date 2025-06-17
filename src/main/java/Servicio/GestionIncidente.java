package Servicio;

import Modelo.Entidades.Incidente;
import Modelo.DAO.IncidenteDAO;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

    public List<Incidente> obtenerIncidentesFinalizadosPorUsuario(int idUsuario) {
        return incidenteDAO.obtenerIncidentesFinalizadosPorUsuario(idUsuario);
    }

    public void mostrarIncidentesFinalizadosEnTabla(int idUsuario, JTable tabla) {
        // Obtener la lista de incidentes finalizados
        List<Incidente> incidentesFinalizados = obtenerIncidentesFinalizadosPorUsuario(idUsuario);

        // Crear el modelo de tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Categoria");
        model.addColumn("Descripción");
        model.addColumn("Aula");
        model.addColumn("Contacto");
        model.addColumn("Estado");
        model.addColumn("Solicitante");
        model.addColumn("Fecha Reporte");
        model.addColumn("Hora Reporte");
        model.addColumn("Fecha Finalización");

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        for (Incidente incidente : incidentesFinalizados) {
            String nombreCompletoSolicitante = incidente.getSolicita().getNombre();
            if (incidente.getSolicita().getApellido() != null) {
                nombreCompletoSolicitante += " " + incidente.getSolicita().getApellido();
            }

            String horaFormateada = incidente.getHoraReporte().format(timeFormatter);
            String fechaFinalizacion = "Fecha finalización"; // Reemplazar con el campo real si lo tienes

            model.addRow(new Object[]{
                incidente.getIdTicket(),
                incidente.getCategoria().getNombre(),
                incidente.getDescripcion(),
                incidente.getAula(),
                incidente.getCelular(),
                incidente.getEstado(),
                nombreCompletoSolicitante,
                incidente.getFechaReporte(),
                horaFormateada,
                incidente.getFechaFinalizacionFormateada() != null
                ? incidente.getFechaFinalizacionFormateada() : "No finalizado"
            });
        }

        tabla.setModel(model);
    }

    
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

    public Map<Integer, Integer> obtenerEstadisticasPorMes(int año, int idUsuario) {
        return incidenteDAO.obtenerIncidentesFinalizadosPorMes(año, idUsuario);
    }
}
