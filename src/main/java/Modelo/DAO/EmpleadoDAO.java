package Modelo.DAO;

import Modelo.Entidades.Empleado;
import Modelo.Conexion.Conexiondb;
import Modelo.Entidades.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static proyectoFinal.gestionTickets.Main.usuario;

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

    public Empleado obtenerEmpleadoPorUsuario(int idUsuario) {
        Empleado empleado = null;
        Conexiondb conexion = new Conexiondb();
        Connection con = conexion.establecerConexion();

        String query = "SELECT id_empleado, nombre, apellido, id_categoria, estado FROM empleado WHERE id_usuario = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("id_empleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setEstado(rs.getString("estado"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexion.cerrarConexion();
        }

        return empleado;
    }

    public void close() {
        cerrarConexion();
    }

    public boolean crearEmpleado(Empleado empleado) {
        String query = "INSERT INTO empleado (nombre, apellido, id_categoria, estado, fecha_estado, id_usuario, celular) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setInt(3, empleado.getCategoria().getIdCategoria());
            ps.setString(4, empleado.getEstado());
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(empleado.getFechaEstado()));
            ps.setInt(6, usuario.getId());
            ps.setString(7, empleado.getCelular());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear empleado: " + e.getMessage());
            return false;
        }
    }

    /**
     * Actualiza los datos de un empleado existente
     *
     * @param empleado Objeto Empleado con los datos actualizados
     * @return true si se actualizó correctamente, false si hubo error
     */
    public boolean actualizarEmpleado(Empleado empleado) {
        String query = "UPDATE empleado SET nombre = ?, apellido = ?, id_categoria = ?, estado = ?, "
                + "fecha_estado = ?, id_usuario = ?, celular = ? WHERE id_empleado = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setInt(3, empleado.getCategoria().getIdCategoria());
            ps.setString(4, empleado.getEstado());
            ps.setTimestamp(5, java.sql.Timestamp.valueOf(empleado.getFechaEstado()));
            ps.setInt(6, usuario.getId());
            ps.setString(7, empleado.getCelular());
            ps.setInt(8, empleado.getIdEmpleado());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar empleado: " + e.getMessage());
            return false;
        }
    }

    /**
     * Elimina un empleado de la base de datos
     *
     * @param idEmpleado ID del empleado a eliminar
     * @return true si se eliminó correctamente, false si hubo error
     */
    public boolean eliminarEmpleado(int idEmpleado) {
        String query = "DELETE FROM empleado WHERE id_empleado = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idEmpleado);

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar empleado: " + e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene todos los empleados de la base de datos
     *
     * @return Lista de empleados
     */
    public List<Empleado> obtenerTodosEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleado";

        try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        new Categoria(rs.getInt("id_categoria"), ""), // Necesitarás implementar Categoria
                        rs.getString("estado"),
                        rs.getTimestamp("fecha_estado").toLocalDateTime(),
                        rs.getInt("id_usuario")
                );
                empleado.setCelular(rs.getString("celular"));
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener empleados: " + e.getMessage());
        }

        return empleados;
    }

    /**
     * Busca un empleado por su ID
     *
     * @param idEmpleado ID del empleado a buscar
     * @return Objeto Empleado si se encuentra, null si no existe
     */
    public Empleado obtenerEmpleadoPorId(int idEmpleado) {
        String query = "SELECT * FROM empleado WHERE id_empleado = ?";
        Empleado empleado = null;

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idEmpleado);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                empleado = new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        new Categoria(rs.getInt("id_categoria"), ""), // Necesitarás implementar Categoria
                        rs.getString("estado"),
                        rs.getTimestamp("fecha_estado").toLocalDateTime(),
                        rs.getInt("id_usuario")
                );
                empleado.setCelular(rs.getString("celular"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener empleado: " + e.getMessage());
        }

        return empleado;
    }
    
    public List<Empleado> buscarEmpleados(String criterio) {
    List<Empleado> empleados = new ArrayList<>();
    String query = "SELECT * FROM empleado WHERE nombre LIKE ? OR apellido LIKE ?";
    
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setString(1, "%" + criterio + "%");
        ps.setString(2, "%" + criterio + "%");
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Empleado empleado = new Empleado(
                rs.getInt("id_empleado"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                new Categoria(rs.getInt("id_categoria"), ""),
                rs.getString("estado"),
                rs.getTimestamp("fecha_estado").toLocalDateTime(),
                rs.getInt("id_usuario")
            );
            empleado.setCelular(rs.getString("celular"));
            empleados.add(empleado);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al buscar empleados: " + e.getMessage());
    }
    
    return empleados;
}

/**
 * Cambia el estado de un empleado
 * @param idEmpleado ID del empleado
 * @param nuevoEstado Nuevo estado ("disponible" o "ocupado")
 * @return true si se actualizó correctamente
 */
public boolean cambiarEstadoEmpleado(int idEmpleado, String nuevoEstado) {
    String query = "UPDATE empleado SET estado = ?, fecha_estado = CURRENT_TIMESTAMP WHERE id_empleado = ?";
    
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setString(1, nuevoEstado);
        ps.setInt(2, idEmpleado);
        
        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cambiar estado del empleado: " + e.getMessage());
        return false;
    }
}

/**
 * Obtiene empleados por estado
 * @param estado Estado a filtrar ("disponible" o "ocupado")
 * @return Lista de empleados con ese estado
 */
public List<Empleado> obtenerEmpleadosPorEstado(String estado) {
    List<Empleado> empleados = new ArrayList<>();
    String query = "SELECT * FROM empleado WHERE estado = ?";
    
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setString(1, estado);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Empleado empleado = new Empleado(
                rs.getInt("id_empleado"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                new Categoria(rs.getInt("id_categoria"), ""),
                rs.getString("estado"),
                rs.getTimestamp("fecha_estado").toLocalDateTime(),
                rs.getInt("id_usuario")
            );
            empleado.setCelular(rs.getString("celular"));
            empleados.add(empleado);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener empleados por estado: " + e.getMessage());
    }
    
    return empleados;
}

/**
 * Verifica si un empleado existe por su ID
 * @param idEmpleado ID del empleado
 * @return true si existe, false si no
 */
public boolean existeEmpleado(int idEmpleado) {
    String query = "SELECT COUNT(*) FROM empleado WHERE id_empleado = ?";
    
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ps.setInt(1, idEmpleado);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al verificar empleado: " + e.getMessage());
    }
    
    return false;
}

/**
 * Obtiene el número total de empleados
 * @return Cantidad total de empleados
 */
public int contarEmpleados() {
    String query = "SELECT COUNT(*) FROM empleado";
    
    try (PreparedStatement ps = con.prepareStatement(query)) {
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al contar empleados: " + e.getMessage());
    }
    
    return 0;
}
    
    
}
