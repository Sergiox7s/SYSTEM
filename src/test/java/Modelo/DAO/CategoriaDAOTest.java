
package Modelo.DAO;

import Modelo.Entidades.Categoria;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Usuario
 */
public class CategoriaDAOTest {
    
    private CategoriaDAO categoriaDAO;
    private Categoria categoriaTest;
    
    @BeforeEach
    public void setUp() {
        categoriaDAO = new CategoriaDAO();
        categoriaTest = new Categoria();
        categoriaTest.setNombre("Categoria de Prueba " + System.currentTimeMillis());
    }
    
    @AfterEach
    public void tearDown() {
        if (categoriaTest.getIdCategoria() > 0) {
            categoriaDAO.eliminarCategoria(categoriaTest.getIdCategoria());
        }
    }

    @Test
    public void testAgregarCategoria() {
        boolean resultado = categoriaDAO.agregarCategoria(categoriaTest);
        assertTrue(resultado, "Debería retornar true al agregar correctamente");
        assertTrue(categoriaTest.getIdCategoria() > 0, "Debería asignar un ID");
    }

    @Test
public void testObtenerCategoriaPorId() {
    // Arrange - agregar una categoría de prueba
    categoriaDAO.agregarCategoria(categoriaTest);
    int idCategoria = categoriaTest.getIdCategoria();
    
    // Act - obtener la categoría por su ID
    Categoria resultado = categoriaDAO.obtenerCategoriaPorId(idCategoria);
    
    // Assert - verificar que se obtuvo correctamente
    assertNotNull(resultado, "Debería encontrar la categoría recién creada");
    assertEquals(idCategoria, resultado.getIdCategoria(), "El ID debería coincidir");
    assertEquals(categoriaTest.getNombre(), resultado.getNombre(), "El nombre debería coincidir");
    
    // Prueba adicional con ID inexistente
    Categoria noExistente = categoriaDAO.obtenerCategoriaPorId(-1);
    assertNull(noExistente, "Debería retornar null para un ID que no existe");
}

    /*@Test
    public void testObtenerTodasCategorias() {
        int countInicial = categoriaDAO.obtenerTodasCategorias().size();
        categoriaDAO.agregarCategoria(categoriaTest);
        List<Categoria> categorias = categoriaDAO.obtenerTodasCategorias();
        assertEquals(countInicial + 1, categorias.size(), "Debería aumentar el conteo");
    }*/

    @Test
    public void testActualizarCategoria() {
        categoriaDAO.agregarCategoria(categoriaTest);
        categoriaTest.setNombre("Nombre Modificado");
        boolean resultado = categoriaDAO.actualizarCategoria(categoriaTest);
        assertTrue(resultado, "Debería retornar true al actualizar");
    }

    @Test
    public void testEliminarCategoria() {
        categoriaDAO.agregarCategoria(categoriaTest);
        boolean resultado = categoriaDAO.eliminarCategoria(categoriaTest.getIdCategoria());
        assertTrue(resultado, "Debería retornar true al eliminar");
    }
    
    
    
}
