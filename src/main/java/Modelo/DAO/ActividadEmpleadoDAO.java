package Modelo.DAO;

import Modelo.Conexion.Conexiondb;
import Modelo.Entidades.Categoria;
import Modelo.Entidades.Empleado;
import Modelo.Entidades.Incidente;
import Modelo.Entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ActividadEmpleadoDAO {
    

    public void actualizarTablaAsignados(JTable tableColaAsignados) {
        Conexiondb conexionDB = new Conexiondb();
        Connection con = conexionDB.establecerConexion();
        DefaultTableModel model = (DefaultTableModel) tableColaAsignados.getModel();
        model.setRowCount(0);
        String query = """
        SELECT 
            a.id_actividad, 
            e.nombre, 
            e.apellido, 
            i.estado, 
            CONCAT(DATE_FORMAT(a.fecha_asignacion, '%Y-%m-%d'), '      ', DATE_FORMAT(a.fecha_asignacion, '%h:%i:%s %p')) AS fecha_asignacion,
            CASE 
                WHEN i.estado = 'finalizado' THEN 
                    CONCAT(DATE_FORMAT(a.fecha_resolucion, '%Y-%m-%d'), '      ', DATE_FORMAT(a.fecha_resolucion, '%h:%i:%s %p')) 
                ELSE 'N/A'
            END AS fecha_resolucion
        FROM actividad_empleado a
        JOIN empleado e ON a.id_empleado = e.id_empleado
        JOIN incidente i ON a.id_incidente = i.id_incidente
        WHERE i.estado IN ('asignado', 'finalizado');
    """;

        try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {

                String empleado = rs.getString("nombre") + " " + rs.getString("apellido");
                String fechaAsignacion = rs.getString("fecha_asignacion");
                String fechaResolucion = rs.getString("fecha_resolucion");
                Object[] row = {
                    rs.getInt("id_actividad"),
                    empleado, // Nombre del empleado
                    rs.getString("estado"),
                    fechaAsignacion,
                    fechaResolucion
                };
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionDB.cerrarConexion();
        }
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

    public int obtenerTotalIncidentesAsignados(int idEmpleado) {
        Conexiondb conexion = new Conexiondb();
        Connection con = conexion.establecerConexion();
        int totalIncidentes = 0;

        String sql = """
            SELECT COUNT(id_actividad) AS total_incidentes
            FROM actividad_empleado
            WHERE id_empleado = ?;
        """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idEmpleado);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    totalIncidentes = rs.getInt("total_incidentes");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }

        return totalIncidentes;
    }

    public int obtenerTiempoPromedioRespuesta(int idEmpleado) {
        Conexiondb conexion = new Conexiondb();
        Connection con = conexion.establecerConexion();

        int promedioRespuesta = 0;

        String sql = """
            SELECT IFNULL(AVG(TIMESTAMPDIFF(MINUTE, fecha_asignacion, fecha_resolucion)), 0) AS promedio_respuesta
            FROM actividad_empleado
            WHERE id_empleado = ?;
        """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idEmpleado);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    promedioRespuesta = rs.getInt("promedio_respuesta");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
        return promedioRespuesta;
    }

    public int obtenerIdEmpleadoPorNombre(String nombreCompleto) {
        Conexiondb conexion = new Conexiondb();
        Connection conn = conexion.establecerConexion();

        String[] nombreApellido = nombreCompleto.split(" ");
        String nombre = nombreApellido[0];
        String apellido = nombreApellido[1];

        String sql = "SELECT id_empleado FROM empleado WHERE nombre = ? AND apellido = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id_empleado");
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
        return -1;
    }

    public List<Object[]> mostrarHistorialPorEmpleado(int idEmpleado) {
        List<Object[]> incidentes = new ArrayList<>();
        Conexiondb conexion = new Conexiondb();
        Connection conn = conexion.establecerConexion();

        String query = "SELECT i.id_incidente, "
                + "i.estado, "
                + "IFNULL(TIMESTAMPDIFF(MINUTE, ae.fecha_asignacion, ae.fecha_resolucion), '--') AS tiempo_resolucion "
                + "FROM actividad_empleado ae "
                + "JOIN incidente i ON ae.id_incidente = i.id_incidente "
                + "WHERE ae.id_empleado = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idEmpleado);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] incidente = new Object[3];
                incidente[0] = rs.getInt("id_incidente");
                incidente[1] = rs.getString("estado");
                incidente[2] = rs.getObject("tiempo_resolucion");

                incidentes.add(incidente);
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
        return incidentes;
    }
    public List<Map<String, Object>> obtenerTicketsFinalizadosPorEmpleado(int idEmpleado) {
    List<Map<String, Object>> tickets = new ArrayList<>();
    String sql = """
        SELECT 
            i.id_incidente, 
            c.nombre AS categoria,
            i.descripcion, 
            i.aula, 
            DATE_FORMAT(i.fecha_reporte, '%d/%m/%Y') AS fecha_reporte,
            DATE_FORMAT(i.hora_reporte, '%H:%i') AS hora_reporte,
            DATE_FORMAT(a.fecha_resolucion, '%d/%m/%Y %H:%i') AS fecha_resolucion,
            TIMESTAMPDIFF(MINUTE, a.fecha_asignacion, a.fecha_resolucion) AS tiempo_resolucion
        FROM actividad_empleado a
        JOIN incidente i ON a.id_incidente = i.id_incidente
        JOIN categoria c ON i.id_categoria = c.id_categoria
        WHERE a.id_empleado = ? AND a.fecha_resolucion IS NOT NULL
        ORDER BY a.fecha_resolucion DESC
        """;
    
    try (Connection con = new Conexiondb().establecerConexion();
         PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setInt(1, idEmpleado);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Map<String, Object> ticket = new HashMap<>();
            ticket.put("id_incidente", rs.getInt("id_incidente"));
            ticket.put("categoria", rs.getString("categoria"));
            ticket.put("descripcion", rs.getString("descripcion"));
            ticket.put("aula", rs.getString("aula"));
            ticket.put("fecha_reporte", rs.getString("fecha_reporte"));
            ticket.put("hora_reporte", rs.getString("hora_reporte"));
            ticket.put("fecha_resolucion", rs.getString("fecha_resolucion"));
            ticket.put("tiempo_resolucion", rs.getInt("tiempo_resolucion"));
            tickets.add(ticket);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tickets;
}

}
