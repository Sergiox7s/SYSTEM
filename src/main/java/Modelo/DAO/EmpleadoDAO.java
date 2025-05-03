package Modelo.DAO;

import Modelo.Entidades.Empleado;
import Modelo.Conexion.Conexiondb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmpleadoDAO {

    private Connection con;

    public EmpleadoDAO() {
        Conexiondb conexion = new Conexiondb();
        this.con = conexion.establecerConexion();
    }

    private void cerrarConexion() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public void cargarEmpleadoDisponiblePorCategoria(JComboBox<Empleado> cbEmpleados, int idCategoria) {
        String query = "SELECT id_empleado, CONCAT(nombre, ' ', apellido) AS nombre_completo FROM empleado WHERE id_categoria = ? AND estado = 'disponible'";

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idCategoria);
            ResultSet rs = stmt.executeQuery();

            DefaultComboBoxModel<Empleado> model = new DefaultComboBoxModel<>();
            model.addElement(new Empleado(-1, "Seleccionar empleado", ""));

            while (rs.next()) {
                int idEmpleado = rs.getInt("id_empleado");
                String nombreCompleto = rs.getString("nombre_completo");

                String[] partes = nombreCompleto.split(" ");
                String nombre = partes[0];
                String apellido = partes.length > 1 ? partes[1] : "";

                model.addElement(new Empleado(idEmpleado, nombre, apellido));
            }

            cbEmpleados.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar empleados: " + e.getMessage());
        }
    }

    public String obtenerEstadoEmpleado(int idEmpleado) {
        String query = "SELECT estado FROM empleado WHERE id_empleado = ?";
        String estado = null;

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idEmpleado);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                estado = rs.getString("estado");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el estado del empleado: " + e.getMessage());
        }

        return estado;
    }

    public void mostrarEmpleadosPorCategoria(int idCategoria, JTable tablaEmpleados) {
        String query = """
        SELECT 
            e.nombre, 
            e.apellido, 
            e.estado, 
            IF(e.estado = 'ocupado', 
               (SELECT i.id_incidente 
                FROM actividad_empleado ae 
                JOIN incidente i ON ae.id_incidente = i.id_incidente
                WHERE ae.id_empleado = e.id_empleado
                AND ae.fecha_resolucion IS NULL 
                ORDER BY ae.fecha_asignacion DESC 
                LIMIT 1), 
            '--') AS id_incidente,
            
            IF(e.estado = 'ocupado', 
               (SELECT i.aula 
                FROM actividad_empleado ae 
                JOIN incidente i ON ae.id_incidente = i.id_incidente
                WHERE ae.id_empleado = e.id_empleado
                AND ae.fecha_resolucion IS NULL 
                ORDER BY ae.fecha_asignacion DESC 
                LIMIT 1), 
            '--') AS aula,

            IF(e.estado = 'ocupado', 
               (SELECT ae.fecha_asignacion 
                FROM actividad_empleado ae 
                WHERE ae.id_empleado = e.id_empleado
                AND ae.fecha_resolucion IS NULL
                ORDER BY ae.fecha_asignacion DESC
                LIMIT 1), 
            '--') AS fecha_asignacion
        FROM 
            empleado e
        WHERE 
            e.id_categoria = ?;
        """;

        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setInt(1, idCategoria);
            ResultSet rs = stmt.executeQuery();

            DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
            modelo.setRowCount(0); // Limpiar tabla antes de agregar nuevos datos

            while (rs.next()) {
                String nombreCompleto = rs.getString("nombre") + " " + rs.getString("apellido");
                String estado = rs.getString("estado");
                String idIncidente = rs.getString("id_incidente");
                String aula = rs.getString("aula");
                String fechaAsignacion = rs.getString("fecha_asignacion");

                modelo.addRow(new Object[]{
                    nombreCompleto, estado, idIncidente, aula, fechaAsignacion
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Empleado obtenerDatosEmpleado(String nombre, String apellido) {
        String query = """
            SELECT id_empleado, nombre, apellido, estado, celular
            FROM empleado
            WHERE nombre = ? AND apellido = ?;
        """;

        Empleado empleado = null;

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                empleado = new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("estado"),
                        rs.getString("celular")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error" + e);
        }

        return empleado;
    }


    public void close() {
        cerrarConexion();
    }
}
