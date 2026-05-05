package sportstore.sportstoreapi.service;

import sportstore.sportstoreapi.model.Producto;
import sportstore.sportstoreapi.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {


    // Mock del repositorio para simular la base de datos
    @Mock
    private ProductoRepository productoRepository;

    // Instancia del servicio con el mock
    @InjectMocks
    private ProductoService productoService;

    // Test 1: 
    // Verificar que findAll() retorne la lista completa de productos
    @Test
    void testFindAll() {
        Producto p1 = new Producto();
        p1.setIdProducto(1);
        p1.setNombre("Balón de fútbol");
        p1.setPrecio(new BigDecimal("85000"));

        when(productoRepository.findAll()).thenReturn(Arrays.asList(p1));

        List<Producto> result = productoService.findAll();

        assertEquals(1, result.size());
        verify(productoRepository, times(1)).findAll();
    }

    // Test 2: 
    // Verificar que findById() retorne el producto correcto por su ID
    @Test
    void testFindById() {
        Producto p = new Producto();
        p.setIdProducto(1);
        p.setNombre("Balón de fútbol");

        when(productoRepository.findById(1)).thenReturn(Optional.of(p));

        Optional<Producto> result = productoService.findById(1);

        assertTrue(result.isPresent());
        assertEquals("Balón de fútbol", result.get().getNombre());
    }

    // Test 3: 
    // Verificar que save() guarde y retorne el producto correctamente
    @Test
    void testSave() {
        Producto p = new Producto();
        p.setNombre("Guayos");
        p.setPrecio(new BigDecimal("150000"));

        when(productoRepository.save(p)).thenReturn(p);

        Producto result = productoService.save(p);

        assertNotNull(result);
        assertEquals("Guayos", result.getNombre());
    }

    // Test 4: 
    // Verificar que deleteById() elimine el producto por su ID
    @Test
    void testDeleteById() {
        doNothing().when(productoRepository).deleteById(1);
        productoService.deleteById(1);
        verify(productoRepository, times(1)).deleteById(1);
    }

    // Test 5: 
    // Verificar que findById() retorne vacío cuando el producto no exista
    @Test
    void testFindByIdNotFound() {
        when(productoRepository.findById(99)).thenReturn(Optional.empty());
        Optional<Producto> result = productoService.findById(99);
        assertFalse(result.isPresent());
    }
}

