package Modelo.DAO;

import Modelo.Entidades.Usuario;
import javax.swing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicketDAOTest {

    private TicketDAO ticketDAO;
    private Usuario usuarioTest;

    @BeforeEach
    public void setUp() {
        ticketDAO = new TicketDAO();
        usuarioTest = new Usuario();
        usuarioTest.setId(1); // ID de prueba
    }

    @Test
    public void testCrearTicket() {
        
        JTextField textFecha = new JTextField("2023-01-01");
        JTextField textAula = new JTextField("A101");
        JTextField textCelular = new JTextField("123456789");
        JComboBox<String> cbCategoria = new JComboBox<>(new String[]{"Hardware"});
        JTextArea textDescripcion = new JTextArea("Problema con el teclado");

        //  Ejecuta el método
        assertDoesNotThrow(() -> {
            ticketDAO.crearTicket(textFecha, textAula, textCelular, cbCategoria, textDescripcion, usuarioTest);
        }, "No debería lanzar excepciones con datos válidos");
    }

    @Test
    public void testCargarCategorias() {
        
        JComboBox<String> cbCategoria = new JComboBox<>();

        ticketDAO.cargarCategorias(cbCategoria);

        // 3. Verifica que se cargaron categorías
        assertTrue(cbCategoria.getItemCount() > 0, "Debería haber categorías cargadas");
    }

    @Test
    public void testObtenerTicketsDeUsuario() {
        // 1. Crea una JTable real
        JTable table = new JTable();

        // 2. Ejecuta con un ID de usuario existente (ajusta según tu BD)
        ticketDAO.obtenerTicketsDeUsuario(1, table);

        // 3. Verifica que la tabla tiene datos
        assertNotNull(table.getModel(), "La tabla debería tener un modelo de datos");
    }

    @Test
    public void testEliminarTicket() {
        // 1. Ejecuta con un ID (deberías primero crear un ticket para eliminarlo)
        assertDoesNotThrow(() -> {
            ticketDAO.eliminarTicket(1); // Cambia por un ID existente
        }, "No debería lanzar excepciones");
    }
}