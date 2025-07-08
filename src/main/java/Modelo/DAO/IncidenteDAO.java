package Modelo.DAO;

import Modelo.Conexion.Conexiondb;
import Modelo.Entidades.Incidente;
import Modelo.Entidades.Categoria;
import Modelo.Entidades.Empleado;
import Modelo.Entidades.Usuario;

import java.sql.*;
import java.time.LocalTime;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IncidenteDAO {

    public Queue<Incidente> cargarIncidentesPendientes() {
        Queue<Incidente> colaPendientes = new LinkedList<>();
        Conexiondb conexion = new Conexiondb();
        Connection con = conexion.establecerConexion();

        if (con != null) {
            String query = """
        SELECT i.id_incidente, c.id_categoria, c.nombre AS categoria, i.descripcion,
               i.aula, i.celular, i.fecha_reporte, i.hora_reporte, i.estado,
               u.id_usuario, u.nombre, u.apellido,
               e.id_empleado, CONCAT(e.nombre, ' ', e.apellido) AS asignado_a
        FROM incidente i
        JOIN categoria c ON i.id_categoria = c.id_categoria
        JOIN usuario u ON i.id_usuario = u.id_usuario
        LEFT JOIN empleado e ON i.id_empleado_asignado = e.id_empleado
        WHERE i.estado = 'PENDIENTE'
        ORDER BY i.id_incidente ASC;
        """;

            try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

                while (rs.next()) {

                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id_usuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));

                    Empleado empleado = (rs.getInt("id_empleado") != 0)
                            ? new Empleado(rs.getInt("id_empleado"), rs.getString("asignado_a"))
                            : null;

                    String horaFormateada = rs.getTime("hora_reporte").toLocalTime().format(timeFormatter);

                    Incidente incidente = new Incidente(
                            rs.getInt("id_incidente"),
                            new Categoria(rs.getInt("id_categoria"), rs.getString("categoria")),
                            rs.getString("descripcion"),
                            rs.getString("celular"),
                            rs.getString("aula"),
                            rs.getString("estado"),
                            rs.getDate("fecha_reporte").toLocalDate(),
                            LocalTime.parse(horaFormateada, timeFormatter),
                            usuario,
                            empleado
                    );

                    colaPendientes.add(incidente);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarConexion();
            }
        }
        return colaPendientes;
    }

    public boolean asignarTicket(int ticketID, int empleadoID) {
        boolean exito = false;
        Conexiondb conexionDB = new Conexiondb();
        Connection con = null;

        try {
            con = conexionDB.establecerConexion();
            con.setAutoCommit(false);

            String sqlIncidente = "UPDATE incidente SET id_empleado_asignado = ?, estado = 'asignado' WHERE id_incidente = ?";
            PreparedStatement psIncidente = con.prepareStatement(sqlIncidente);
            psIncidente.setInt(1, empleadoID);
            psIncidente.setInt(2, ticketID);
            psIncidente.executeUpdate();

            String sqlActividad = "INSERT INTO actividad_empleado (id_empleado, id_incidente, fecha_asignacion) VALUES (?, ?, NOW())";
            PreparedStatement psActividad = con.prepareStatement(sqlActividad);
            psActividad.setInt(1, empleadoID);
            psActividad.setInt(2, ticketID);
            psActividad.executeUpdate();

            String sqlActualizarEmpleado = "UPDATE empleado SET estado = 'ocupado', fecha_estado = NOW() WHERE id_empleado = ?";
            PreparedStatement psActualizarEmpleado = con.prepareStatement(sqlActualizarEmpleado);
            psActualizarEmpleado.setInt(1, empleadoID);
            psActualizarEmpleado.executeUpdate();

            con.commit();
            exito = true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            conexionDB.cerrarConexion();
        }
        return exito;
    }

    public int obtenerEmpleadoID(String nombreEmpleado) {
        int idEmpleado = -1;
        Conexiondb conexionDB = new Conexiondb();
        Connection con = null;

        try {
            con = conexionDB.establecerConexion();
            String sql = "SELECT id_empleado FROM empleado WHERE CONCAT(nombre, ' ', apellido) = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreEmpleado);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idEmpleado = rs.getInt("id_empleado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionDB.cerrarConexion();
        }

        return idEmpleado;
    }

    public int obtenerConteoIncidentesAsignados() {
        int asignadosCount = 0;
        Conexiondb conexionDB = new Conexiondb();
        Connection con = null;

        try {
            con = conexionDB.establecerConexion();
            if (con != null) {
                String query = "SELECT COUNT(*) AS totalAsignados FROM incidente WHERE estado = 'asignado'";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    asignadosCount = rs.getInt("totalAsignados");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el conteo de incidentes asignados: " + e.getMessage());
        } finally {
            conexionDB.cerrarConexion();
        }

        return asignadosCount;
    }

    public int obtenerConteoIncidentesAsignadosPorUsuario(int idUsuario) {
        int asignadosCount = 0;
        Conexiondb conexionDB = new Conexiondb();
        Connection con = null;

        try {
            con = conexionDB.establecerConexion();
            if (con != null) {
                String query = """
                SELECT COUNT(*) AS totalAsignados 
                FROM incidente i
                JOIN empleado e ON i.id_empleado_asignado = e.id_empleado
                WHERE e.id_usuario = ? AND i.estado = 'asignado'
            """;
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, idUsuario);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    asignadosCount = rs.getInt("totalAsignados");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener conteo de incidentes asignados: " + e.getMessage());
        } finally {
            conexionDB.cerrarConexion();
        }
        return asignadosCount;
    }

    public List<Incidente> obtenerIncidentesAsignadosPorUsuario(int idUsuario) {
        List<Incidente> incidentesAsignados = new ArrayList<>();
        Conexiondb conexionDB = new Conexiondb();
        Connection con = null;

        try {
            con = conexionDB.establecerConexion();
            if (con != null) {
                String query = """
                SELECT i.id_incidente, c.id_categoria, c.nombre AS categoria, i.descripcion,
                       i.aula, i.celular, i.fecha_reporte, i.hora_reporte, i.estado,
                       u.id_usuario, u.nombre, u.apellido,
                       e.id_empleado, CONCAT(e.nombre, ' ', e.apellido) AS asignado_a
                FROM incidente i
                JOIN categoria c ON i.id_categoria = c.id_categoria
                JOIN usuario u ON i.id_usuario = u.id_usuario
                JOIN empleado e ON i.id_empleado_asignado = e.id_empleado
                WHERE e.id_usuario = ? AND i.estado = 'asignado'
                ORDER BY i.fecha_reporte DESC, i.hora_reporte DESC;
            """;

                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, idUsuario);
                ResultSet rs = ps.executeQuery();

                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id_usuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));

                    Empleado empleado = (rs.getInt("id_empleado") != 0)
                            ? new Empleado(rs.getInt("id_empleado"), rs.getString("asignado_a"))
                            : null;

                    String horaFormateada = rs.getTime("hora_reporte").toLocalTime().format(timeFormatter);

                    Incidente incidente = new Incidente(
                            rs.getInt("id_incidente"),
                            new Categoria(rs.getInt("id_categoria"), rs.getString("categoria")),
                            rs.getString("descripcion"),
                            rs.getString("celular"),
                            rs.getString("aula"),
                            rs.getString("estado"),
                            rs.getDate("fecha_reporte").toLocalDate(),
                            LocalTime.parse(horaFormateada, timeFormatter),
                            usuario,
                            empleado
                    );

                    incidentesAsignados.add(incidente);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener incidentes asignados: " + e.getMessage());
        } finally {
            conexionDB.cerrarConexion();
        }

        return incidentesAsignados;
    }

    public int obtenerConteoIncidentesFinalizados() {
        int finalizadosCount = 0;
        Conexiondb conexionDB = new Conexiondb();
        Connection con = null;

        try {
            con = conexionDB.establecerConexion();
            if (con != null) {
                String query = "SELECT COUNT(*) AS totalFinalizados FROM incidente WHERE estado = 'finalizado'";
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    finalizadosCount = rs.getInt("totalFinalizados");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el conteo de incidentes finalizados: " + e.getMessage());
        } finally {
            conexionDB.cerrarConexion();
        }

        return finalizadosCount;
    }

    public List<Incidente> obtenerIncidentesFinalizadosPorUsuario(int idUsuario) {
        List<Incidente> incidentesFinalizados = new ArrayList<>();
        Conexiondb conexionDB = new Conexiondb();
        Connection con = null;

        try {
            con = conexionDB.establecerConexion();
            if (con != null) {
                String query = """
                    SELECT 
                        i.id_incidente, 
                        c.id_categoria, 
                        c.nombre AS categoria, 
                        i.descripcion,
                        i.aula, 
                        i.celular, 
                        i.fecha_reporte, 
                        i.hora_reporte, 
                        i.estado,
                        u.id_usuario, 
                        u.nombre, 
                        u.apellido,
                        e.id_empleado, 
                        CONCAT(e.nombre, ' ', e.apellido) AS asignado_a,
                        DATE_FORMAT(a.fecha_resolucion, '%Y-%m-%d %h:%i %p') AS fecha_finalizacion_formateada,
                        a.fecha_resolucion
                    FROM incidente i
                    JOIN categoria c ON i.id_categoria = c.id_categoria
                    JOIN usuario u ON i.id_usuario = u.id_usuario
                    JOIN empleado e ON i.id_empleado_asignado = e.id_empleado
                    JOIN actividad_empleado a ON i.id_incidente = a.id_incidente
                    WHERE e.id_usuario = ? AND i.estado = 'finalizado'
                    ORDER BY a.fecha_resolucion DESC;
                """;

                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1, idUsuario);
                ResultSet rs = ps.executeQuery();

                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

                while (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("id_usuario"));
                    usuario.setNombre(rs.getString("nombre"));
                    usuario.setApellido(rs.getString("apellido"));

                    Empleado empleado = (rs.getInt("id_empleado") != 0)
                            ? new Empleado(rs.getInt("id_empleado"), rs.getString("asignado_a"))
                            : null;

                    String horaFormateada = rs.getTime("hora_reporte").toLocalTime().format(timeFormatter);

                    Incidente incidente = new Incidente(
                            rs.getInt("id_incidente"),
                            new Categoria(rs.getInt("id_categoria"), rs.getString("categoria")),
                            rs.getString("descripcion"),
                            rs.getString("celular"),
                            rs.getString("aula"),
                            rs.getString("estado"),
                            rs.getDate("fecha_reporte").toLocalDate(),
                            LocalTime.parse(horaFormateada, timeFormatter),
                            usuario,
                            empleado
                    );

                    // Asignar fechas
                    if (rs.getTimestamp("fecha_resolucion") != null) {
                        incidente.setFechaHoraFinalizado(rs.getTimestamp("fecha_resolucion").toLocalDateTime());
                    }
                    incidente.setFechaFinalizacionFormateada(rs.getString("fecha_finalizacion_formateada"));

                    incidentesFinalizados.add(incidente);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener incidentes finalizados: " + e.getMessage());
        } finally {
            conexionDB.cerrarConexion();
        }

        return incidentesFinalizados;
    }
    public Map<Integer, Integer> obtenerIncidentesFinalizadosPorMes(int año, int idEmpleado) {
    Map<Integer, Integer> incidentesPorMes = new HashMap<>();
    Conexiondb conexionDB = new Conexiondb();
    Connection con = null;

    try {
        con = conexionDB.establecerConexion();
        String query = """
            SELECT 
                MONTH(a.fecha_resolucion) as mes,
                COUNT(*) as cantidad
            FROM incidente i
            JOIN actividad_empleado a ON i.id_incidente = a.id_incidente
            JOIN empleado e ON i.id_empleado_asignado = e.id_empleado
            WHERE YEAR(a.fecha_resolucion) = ? 
            AND i.estado = 'finalizado'
            AND e.id_empleado = ?
            GROUP BY MONTH(a.fecha_resolucion)
            ORDER BY mes;
        """;

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, año);
        ps.setInt(2, idEmpleado);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int mes = rs.getInt("mes");
            int cantidad = rs.getInt("cantidad");
            incidentesPorMes.put(mes, cantidad);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error al obtener estadísticas por mes: " + e.getMessage());
    } finally {
        if (con != null) {
            conexionDB.cerrarConexion();
        }
    }

    // Rellenar meses sin incidentes con 0
    for (int mes = 1; mes <= 12; mes++) {
        incidentesPorMes.putIfAbsent(mes, 0);
    }

    return incidentesPorMes;
}
    public Incidente obtenerIncidentePorId(int idTicket) {
        Conexiondb conexion = new Conexiondb();
        Connection con = conexion.establecerConexion();
        Incidente incidente = null;

        if (con != null) {
            String query = """
                SELECT i.id_incidente, c.id_categoria, c.nombre AS categoria, i.descripcion,
                       i.aula, i.celular, i.fecha_reporte, i.hora_reporte, i.estado,
                       u.id_usuario, u.nombre, u.apellido,
                       e.id_empleado, CONCAT(e.nombre, ' ', e.apellido) AS asignado_a
                FROM incidente i
                JOIN categoria c ON i.id_categoria = c.id_categoria
                JOIN usuario u ON i.id_usuario = u.id_usuario
                LEFT JOIN empleado e ON i.id_empleado_asignado = e.id_empleado
                WHERE i.id_incidente = ?;
            """;

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, idTicket);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {

                        Usuario usuario = new Usuario();
                        usuario.setId(rs.getInt("id_usuario"));
                        usuario.setNombre(rs.getString("nombre"));
                        usuario.setApellido(rs.getString("apellido"));

                        Empleado empleado = rs.getInt("id_empleado") != 0
                                ? new Empleado(rs.getInt("id_empleado"), rs.getString("asignado_a"))
                                : null;

                        incidente = new Incidente(
                                rs.getInt("id_incidente"),
                                new Categoria(rs.getInt("id_categoria"), rs.getString("categoria")),
                                rs.getString("descripcion"),
                                rs.getString("celular"),
                                rs.getString("aula"),
                                rs.getString("estado"),
                                rs.getDate("fecha_reporte").toLocalDate(),
                                rs.getTime("hora_reporte").toLocalTime(),
                                usuario,
                                empleado
                        );
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conexion.cerrarConexion();
            }
        }

        return incidente;
    }

    public boolean finalizarTicket(int idTicket) {
        Conexiondb conexion = new Conexiondb();
        Connection con = conexion.establecerConexion();
        boolean finalizado = false;

        if (con != null) {

            String queryIncidente = """
            UPDATE incidente 
            SET estado = 'FINALIZADO', fecha_hora_finalizado = NOW()
            WHERE id_incidente = ?;
        """;

            String queryEmpleado = """
            UPDATE empleado 
            SET estado = 'disponible', fecha_estado = NOW()
            WHERE id_empleado = (
                SELECT id_empleado_asignado 
                FROM incidente 
                WHERE id_incidente = ?
            );
        """;

            String queryActividad = """
            UPDATE actividad_empleado 
            SET fecha_resolucion = NOW() 
            WHERE id_incidente = ?;
        """;

            try {
                con.setAutoCommit(false);

                try (PreparedStatement psIncidente = con.prepareStatement(queryIncidente)) {
                    psIncidente.setInt(1, idTicket);
                    psIncidente.executeUpdate();
                }

                try (PreparedStatement psEmpleado = con.prepareStatement(queryEmpleado)) {
                    psEmpleado.setInt(1, idTicket);
                    psEmpleado.executeUpdate();
                }

                try (PreparedStatement psActividad = con.prepareStatement(queryActividad)) {
                    psActividad.setInt(1, idTicket);
                    psActividad.executeUpdate();
                }

                con.commit();
                finalizado = true;

            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } finally {
                conexion.cerrarConexion();
            }
        }
        return finalizado;
    }

    /**
     * ********* Vista Metricas
     */
    public int obtenerTotalIncidentes() {
        Conexiondb conexion = new Conexiondb();
        Connection conn = conexion.establecerConexion();
        String query = "SELECT COUNT(*) AS total_incidentes FROM incidente";
        int totalIncidentes = 0;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalIncidentes = rs.getInt("total_incidentes");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener total de incidentes: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }

        return totalIncidentes;
    }

    public int obtenerIncidentesDia() {
        Conexiondb conexion = new Conexiondb();
        Connection conn = conexion.establecerConexion();
        String query = "SELECT COUNT(*) AS total_incidentes_dia "
                + "FROM incidente "
                + "WHERE DATE(fecha_reporte) = CURDATE();";

        int totalIncidentesDia = 0;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalIncidentesDia = rs.getInt("total_incidentes_dia");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener incidentes del día: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }

        return totalIncidentesDia;
    }

    public int obtenerIncidentesEnCurso() {
        Conexiondb conexion = new Conexiondb();
        Connection conn = conexion.establecerConexion();
        String query = "SELECT COUNT(*) AS incidentes_asignados FROM incidente WHERE estado = 'asignado'";
        int incidentesAsignados = 0;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                incidentesAsignados = rs.getInt("incidentes_asignados");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener incidentes asignados: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }

        return incidentesAsignados;
    }

    public int obtenerEmpleadosDisponibles() {
        Conexiondb conexion = new Conexiondb();
        Connection conn = conexion.establecerConexion();
        String query = "SELECT COUNT(*) AS empleados_disponibles FROM empleado WHERE estado = 'disponible'";
        int empleadosDisponibles = 0;

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                empleadosDisponibles = rs.getInt("empleados_disponibles");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener empleados disponibles: " + e.getMessage());
        } finally {
            conexion.cerrarConexion();
        }

        return empleadosDisponibles;
    }

    public int obtenerTiempoPromedio() {
        int tiempoPromedio = 0;
        String query = "SELECT AVG(TIMESTAMPDIFF(SECOND, a.fecha_asignacion, a.fecha_resolucion)) AS tiempo_promedio "
                + "FROM actividad_empleado a "
                + "JOIN incidente i ON i.id_incidente = a.id_incidente "
                + "WHERE a.fecha_resolucion IS NOT NULL";

        Conexiondb conexion = new Conexiondb();
        try (Connection conn = conexion.establecerConexion(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                tiempoPromedio = rs.getInt("tiempo_promedio");
            }
        } catch (SQLException e) {
            System.out.println("Error" + e);
        }

        return tiempoPromedio;
    }
    
    /*public Map<Integer, Integer> obtenerIncidentesFinalizadosPorMes(int año, int idUsuario) {
    Map<Integer, Integer> incidentesPorMes = new HashMap<>();
    Conexiondb conexionDB = new Conexiondb();
    Connection con = null;

    try {
        con = conexionDB.establecerConexion();
        String query = """
            SELECT 
                MONTH(a.fecha_resolucion) as mes,
                COUNT(*) as cantidad
            FROM incidente i
            JOIN actividad_empleado a ON i.id_incidente = a.id_incidente
            JOIN empleado e ON i.id_empleado_asignado = e.id_empleado
            WHERE YEAR(a.fecha_resolucion) = ? 
            AND i.estado = 'finalizado'
            AND e.id_usuario = ?
            GROUP BY MONTH(a.fecha_resolucion)
            ORDER BY mes;
        """;

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, año);
        ps.setInt(2, idUsuario);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int mes = rs.getInt("mes");
            int cantidad = rs.getInt("cantidad");
            incidentesPorMes.put(mes, cantidad);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        throw new RuntimeException("Error al obtener estadísticas por mes: " + e.getMessage());
    } finally {
        if (con != null) {
            conexionDB.cerrarConexion();
        }
    }

    // Rellenar meses sin incidentes con 0
    for (int mes = 1; mes <= 12; mes++) {
        incidentesPorMes.putIfAbsent(mes, 0);
    }

    return incidentesPorMes;
}*/
    

}
