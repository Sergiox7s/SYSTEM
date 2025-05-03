package Modelo.DAO;

import Modelo.Entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Modelo.Conexion.Conexiondb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TicketDAO {

    private Connection con;

    public TicketDAO() {
        Conexiondb conexiondb = new Conexiondb();
        this.con = conexiondb.establecerConexion();
    }

    public void crearTicket(JTextField textFecha, JTextField textAula, JTextField textCelular,
            JComboBox<String> cbCategoria, JTextArea textDescripcion, Usuario usuario) {

        String fechaHora = textFecha.getText();
        String aula = textAula.getText().trim();
        String celular = textCelular.getText();
        String categoria = (String) cbCategoria.getSelectedItem();
        String descripcion = textDescripcion.getText().trim();
        int idUsuario = usuario.getId();

        int idCategoria = obtenerIdCategoria(categoria);

        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);

        String sql = "INSERT INTO incidente (id_categoria, descripcion, celular, aula, estado, fecha_reporte, hora_reporte, id_usuario) "
                + "VALUES (?, ?, ?, ?, 'pendiente', ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            // Establecer los parámetros de la consulta
            pst.setInt(1, idCategoria);
            pst.setString(2, descripcion);
            pst.setString(3, celular);
            pst.setString(4, aula);
            pst.setDate(5, new java.sql.Date(timestamp.getTime()));
            pst.setTime(6, new java.sql.Time(timestamp.getTime()));
            pst.setInt(7, idUsuario);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Ticket creado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el ticket: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private int obtenerIdCategoria(String categoria) {
        int idCategoria = -1; 
        String sql = "SELECT id_categoria FROM categoria WHERE nombre = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, categoria);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    idCategoria = rs.getInt("id_categoria");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idCategoria;
    }

    public void cargarCategorias(JComboBox<String> cbCategoria) {
  
        Conexiondb conexion = new Conexiondb();
        Connection conn = conexion.establecerConexion();

        String query = "SELECT nombre FROM categoria";

        try {
         
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();


            model.addElement("Seleccionar tipo de incidencia");

            while (rs.next()) {
                String categoria = rs.getString("nombre");
                model.addElement(categoria);
            }

            cbCategoria.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           
            conexion.cerrarConexion();
        }
    }

    public void obtenerTicketsDeUsuario(int idUsuario, JTable table) {
        String sql = "SELECT id_incidente, categoria.nombre AS categoria, descripcion, estado, fecha_reporte, aula "
                + "FROM incidente "
                + "JOIN categoria ON incidente.id_categoria = categoria.id_categoria "
                + "WHERE id_usuario = ?";

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Categoría");
        model.addColumn("Descripción");
        model.addColumn("Estado");
        model.addColumn("Fecha Reporte");
        model.addColumn("Aula");

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, idUsuario); 
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    // Agregar las filas a la tabla con los detalles del ticket
                    Object[] row = new Object[6];
                    row[0] = rs.getInt("id_incidente");
                    row[1] = rs.getString("categoria");
                    row[2] = rs.getString("descripcion");
                    row[3] = rs.getString("estado");
                    row[4] = rs.getDate("fecha_reporte");
                    row[5] = rs.getString("aula");
                    model.addRow(row); 
                }
                table.setModel(model); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los tickets: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void eliminarTicket(int idIncidente) {

        String sqlDelete = "DELETE FROM incidente WHERE id_incidente = ?";
        try (PreparedStatement pstDelete = con.prepareStatement(sqlDelete)) {
            pstDelete.setInt(1, idIncidente);
            int rowsAffected = pstDelete.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Ticket eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el ticket.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el ticket: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}
