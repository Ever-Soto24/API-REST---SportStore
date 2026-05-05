package sportstore.sportstoreapi.service;

import sportstore.sportstoreapi.model.Categoria;
import sportstore.sportstoreapi.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoriaServiceTest {

    // Mock del repositorio para simular la base de datos
    @Mock
    private CategoriaRepository categoriaRepository;

    // Instancia del servicio con el mock
    @InjectMocks
    private CategoriaService categoriaService;

    // Test 1: 
    // Verificar que findAll() retorne la lista completa de categorías
    @Test
    void testFindAll() {
        Categoria c1 = new Categoria();
        c1.setIdCategoria(1);
        c1.setNombre("Fútbol");
        Categoria c2 = new Categoria();
        c2.setIdCategoria(2);
        c2.setNombre("Baloncesto");
        when(categoriaRepository.findAll()).thenReturn(Arrays.asList(c1, c2));
        List<Categoria> result = categoriaService.findAll();
        assertEquals(2, result.size());
        verify(categoriaRepository, times(1)).findAll();
    }

    // Test 2: 
    // Verificar que findById() retorne la categoría correcta por su ID
    @Test
    void testFindById() {
        Categoria c = new Categoria();
        c.setIdCategoria(1);
        c.setNombre("Fútbol");
        when(categoriaRepository.findById(1)).thenReturn(Optional.of(c));
        Optional<Categoria> result = categoriaService.findById(1);
        assertTrue(result.isPresent());
        assertEquals("Fútbol", result.get().getNombre());
    }

    // Test 3: 
    // Verificar que save() guarde y retorne la categoría correctamente
    @Test
    void testSave() {
        Categoria c = new Categoria();
        c.setNombre("Tenis");
        when(categoriaRepository.save(c)).thenReturn(c);
        Categoria result = categoriaService.save(c);
        assertNotNull(result);
        assertEquals("Tenis", result.getNombre());
    }

    // Test 4: 
    // Verificar que deleteById() eliminr la categoría por su ID
    @Test
    void testDeleteById() {
        doNothing().when(categoriaRepository).deleteById(1);
        categoriaService.deleteById(1);
        verify(categoriaRepository, times(1)).deleteById(1);
    }

    // Test 5: 
    // Verificar que findById() retorne vacío cuando la categoría no exista
    @Test
    void testFindByIdNotFound() {
        when(categoriaRepository.findById(99)).thenReturn(Optional.empty());
        Optional<Categoria> result = categoriaService.findById(99);
        assertFalse(result.isPresent());
    }

}


