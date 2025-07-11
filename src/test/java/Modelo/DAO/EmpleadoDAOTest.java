package Modelo.DAO;

import Modelo.Entidades.Categoria;
import Modelo.Entidades.Empleado;
import Modelo.Entidades.Usuario;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoDAOTest {
    
    private EmpleadoDAO empleadoDAO;
    private int idEmpleadoCreado;
    private Usuario usuarioTest; // Usuario de prueba

    @BeforeEach
    public void setUp() {
        // Configurar usuario de prueba
        usuarioTest = new Usuario();
        usuarioTest.setId(1); // ID ficticio para pruebas
        
        empleadoDAO = new EmpleadoDAO();
        idEmpleadoCreado = 0;
        
        // Inyectar usuario de prueba (depende de tu implementación)
        inyectarUsuarioEnMain(usuarioTest);
    }

    @AfterEach
    public void tearDown() {
        if (idEmpleadoCreado > 0) {
            empleadoDAO.eliminarEmpleado(idEmpleadoCreado);
        }
        empleadoDAO.close();
    }

    private void inyectarUsuarioEnMain(Usuario usuario) {
        // Esto depende de cómo tengas estructurado tu proyecto
        // Si Main.usuario es estático, podrías hacer:
        try {
            Class<?> mainClass = Class.forName("proyectoFinal.gestionTickets.Main");
            java.lang.reflect.Field field = mainClass.getDeclaredField("usuario");
            field.setAccessible(true);
            field.set(null, usuario);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo inyectar el usuario de prueba", e);
        }
    }

    @Test
    public void testCrearEmpleado() {
        Empleado nuevo = new Empleado();
        nuevo.setNombre("Jorge");
        nuevo.setApellido("Vigo");
        nuevo.setCategoria(new Categoria(1, "Test"));
        nuevo.setEstado("disponible");
        nuevo.setFechaEstado(LocalDateTime.now());
        nuevo.setCelular("999888777");
        
        boolean resultado = empleadoDAO.crearEmpleado(nuevo);
        assertTrue(resultado);
        
        List<Empleado> empleados = empleadoDAO.obtenerTodosEmpleados();
        assertFalse(empleados.isEmpty());
        
        Empleado encontrado = empleados.stream()
            .filter(e -> e.getNombre().equals("Test"))
            .findFirst()
            .orElse(null);
            
        assertNotNull(encontrado);
        idEmpleadoCreado = encontrado.getIdEmpleado();
    }

    @Test
    public void testLeerEmpleado() {
        testCrearEmpleado();
        
        Empleado empleado = empleadoDAO.obtenerEmpleadoPorId(idEmpleadoCreado);
        assertNotNull(empleado);
        assertEquals("Test", empleado.getNombre());
    }

    @Test
    public void testActualizarEmpleado() {
        testCrearEmpleado();
        
        Empleado empleado = empleadoDAO.obtenerEmpleadoPorId(idEmpleadoCreado);
        empleado.setEstado("ocupado");
        empleado.setFechaEstado(LocalDateTime.now());
        
        boolean resultado = empleadoDAO.actualizarEmpleado(empleado);
        assertTrue(resultado);
        
        Empleado actualizado = empleadoDAO.obtenerEmpleadoPorId(idEmpleadoCreado);
        assertEquals("ocupado", actualizado.getEstado());
    }

    @Test
    public void testEliminarEmpleado() {
        testCrearEmpleado();
        
        boolean resultado = empleadoDAO.eliminarEmpleado(idEmpleadoCreado);
        assertTrue(resultado);
        
        Empleado eliminado = empleadoDAO.obtenerEmpleadoPorId(idEmpleadoCreado);
        assertNull(eliminado);
        idEmpleadoCreado = 0;
    }
}