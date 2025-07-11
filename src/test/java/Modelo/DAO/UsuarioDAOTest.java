package Modelo.DAO;

import Modelo.Entidades.Usuario;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioDAOTest {
    
    private UsuarioDAO usuarioDAO;
    private Usuario usuarioTest;
    
    @BeforeEach
    public void setUp() {
        usuarioDAO = new UsuarioDAO();
        usuarioTest = crearUsuarioDePrueba();
        limpiarUsuariosDePrueba();
    }
    
    @AfterEach
    public void tearDown() {
        limpiarUsuariosDePrueba();
    }
    
    private Usuario crearUsuarioDePrueba() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Gomez");
        usuario.setCorreo("test" + System.currentTimeMillis() + "GoMEz@hotmail.com");
        usuario.setContrasena("pG1234564");
        usuario.setRol("usuario");
        return usuario;
    }
    
    private void limpiarUsuariosDePrueba() {
        try {
            List<Usuario> usuarios = usuarioDAO.obtenerTodosUsuarios();
            for (Usuario u : usuarios) {
                if (u.getCorreo().startsWith("test")) {
                    usuarioDAO.eliminarUsuario(u.getId());
                }
            }
        } catch (Exception e) {
            System.err.println("Error limpiando usuarios de prueba: " + e.getMessage());
        }
    }

    @Test
    public void testRegistrarUsuarioConParametros() {
        // Datos de prueba
        String nombre = "Juan";
        String apellido = "Perez";
        String correo = "juan.perez" + System.currentTimeMillis() + "@example.com";
        String contrasena = "mipassword";
        String rol = "usuario";
        
        // Ejecutar método
        usuarioDAO.registrarUsuario(nombre, apellido, correo, contrasena, rol);
        
        // Verificación
        boolean encontrado = usuarioDAO.obtenerTodosUsuarios().stream()
            .anyMatch(u -> u.getCorreo().equals(correo));
        assertTrue(encontrado, "Debería existir el usuario registrado");
    }

    @Test
    public void testVerificarUsuario() {
        // Registrar usuario de prueba
        assertTrue(usuarioDAO.registrarUsuario(usuarioTest), "Precondición: usuario registrado");
        
        // Caso exitoso
        Usuario resultado = usuarioDAO.verificarUsuario(usuarioTest.getCorreo(), usuarioTest.getContrasena());
        assertNotNull(resultado, "Debería verificar el usuario correctamente");
        
        // Casos de error
        assertNull(usuarioDAO.verificarUsuario(usuarioTest.getCorreo(), "wrongpass"), 
            "Debería fallar con contraseña incorrecta");
        assertNull(usuarioDAO.verificarUsuario("noexiste@example.com", "password123"), 
            "Debería fallar con correo inexistente");
    }

    @Test
    public void testRegistrarUsuarioConObjeto() {
        boolean resultado = usuarioDAO.registrarUsuario(usuarioTest);
        assertTrue(resultado, "Debería registrar el usuario correctamente");
        assertTrue(usuarioTest.getId() > 0, "Debería asignar un ID al usuario");
    }

    @Test
    public void testObtenerUsuarioPorId() {
        assertTrue(usuarioDAO.registrarUsuario(usuarioTest), "Precondición: usuario registrado");
        
        Usuario resultado = usuarioDAO.obtenerUsuarioPorId(usuarioTest.getId());
        assertNotNull(resultado, "Debería encontrar el usuario registrado");
        assertEquals(usuarioTest.getCorreo(), resultado.getCorreo(), "El correo debería coincidir");
    }

    @Test
    public void testObtenerTodosUsuarios() {
        int countInicial = usuarioDAO.obtenerTodosUsuarios().size();
        assertTrue(usuarioDAO.registrarUsuario(usuarioTest), "Precondición: usuario registrado");
        
        List<Usuario> usuarios = usuarioDAO.obtenerTodosUsuarios();
        assertEquals(countInicial + 1, usuarios.size(), "Debería aumentar el número de usuarios");
    }

    @Test
    public void testActualizarUsuario() {
        assertTrue(usuarioDAO.registrarUsuario(usuarioTest), "Precondición: usuario registrado");
        
        usuarioTest.setNombre("Nombre Actualizado");
        boolean resultado = usuarioDAO.actualizarUsuario(usuarioTest);
        assertTrue(resultado, "Debería actualizar el usuario correctamente");
    }

    @Test
    public void testEliminarUsuario() {
        assertTrue(usuarioDAO.registrarUsuario(usuarioTest), "Precondición: usuario registrado");
        
        boolean resultado = usuarioDAO.eliminarUsuario(usuarioTest.getId());
        assertTrue(resultado, "Debería eliminar el usuario correctamente");
    }
}