package sportstore.sportstoreapi.service;

import sportstore.sportstoreapi.model.Vendedor;
import sportstore.sportstoreapi.repository.VendedorRepository;
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
class VendedorServiceTest {

    // Mock del repositorio para simular la base de datos    
    @Mock
    private VendedorRepository vendedorRepository;

    // Instancia del servicio con el mock
    @InjectMocks
    private VendedorService vendedorService;

    // Test 1: 
    // Verificar que findAll() retorne la lista completa de vendedores
    @Test
    void testFindAll() {
        Vendedor v = new Vendedor();
        v.setIdVendedor(1);
        v.setNombre("Pedro Alvarado");

        when(vendedorRepository.findAll()).thenReturn(Arrays.asList(v));
        List<Vendedor> result = vendedorService.findAll();
        assertEquals(1, result.size());
        verify(vendedorRepository, times(1)).findAll();
    }

    // Test 2: 
    // Verificar que findById() retorne el vendedor correcto por ID
    @Test
    void testFindById() {
        Vendedor v = new Vendedor();
        v.setIdVendedor(1);
        v.setNombre("Pedro Alvarado");
        
        when(vendedorRepository.findById(1)).thenReturn(Optional.of(v));
        Optional<Vendedor> result = vendedorService.findById(1);
        assertTrue(result.isPresent());
        assertEquals("Pedro Alvarado", result.get().getNombre());
    }

    // Test 3: 
    // Verificar que save() guarde y retorne el vendedor correctamente
    @Test
    void testSave() {
        Vendedor v = new Vendedor();
        v.setNombre("Luisa Mora");
        v.setSalario(new BigDecimal("1500000"));

        when(vendedorRepository.save(v)).thenReturn(v);
        Vendedor result = vendedorService.save(v);
        assertNotNull(result);
        assertEquals("Luisa Mora", result.getNombre());
    }

    // Test 4: 
    // Verificar que deleteById() elimine el vendedor por su ID
    @Test
    void testDeleteById() {
        doNothing().when(vendedorRepository).deleteById(1);
        vendedorService.deleteById(1);
        verify(vendedorRepository, times(1)).deleteById(1);
    }

    // Test 5: 
    // Verificar que findById() retorne vacío cuando el vendedor no exista
    @Test
    void testFindByIdNotFound() {
        when(vendedorRepository.findById(99)).thenReturn(Optional.empty());
        Optional<Vendedor> result = vendedorService.findById(99);
        assertFalse(result.isPresent());
    }
}
