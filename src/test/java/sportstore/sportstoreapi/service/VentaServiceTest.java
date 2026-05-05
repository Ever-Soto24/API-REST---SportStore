package sportstore.sportstoreapi.service;

import sportstore.sportstoreapi.model.Venta;
import sportstore.sportstoreapi.model.Cliente;
import sportstore.sportstoreapi.model.Vendedor;
import sportstore.sportstoreapi.repository.VentaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VentaServiceTest {

    // Mock del repositorio para simular la base de datos 
    @Mock
    private VentaRepository ventaRepository;

    // Instancia del servicio con el mock
    @InjectMocks
    private VentaService ventaService;

    // Test 1: 
    // Verificar que findAll() retorne la lista completa de ventas
    @Test
    void testFindAll() {
        Venta v = new Venta();
        v.setIdVenta(1);
        v.setFecha(LocalDate.now());
        v.setTotal(new BigDecimal("150000"));

        when(ventaRepository.findAll()).thenReturn(Arrays.asList(v));
        List<Venta> result = ventaService.findAll();
        assertEquals(1, result.size());
        verify(ventaRepository, times(1)).findAll();
    }

    // Test 2: 
    // Verificar que findById() retorne la venta correcta por ID
    @Test
    void testFindById() {
        Venta v = new Venta();
        v.setIdVenta(1);
        v.setTotal(new BigDecimal("150000"));

        when(ventaRepository.findById(1)).thenReturn(Optional.of(v));
        Optional<Venta> result = ventaService.findById(1);
        assertTrue(result.isPresent());
        assertEquals(new BigDecimal("150000"), result.get().getTotal());
    }

    // Test 3: 
    // Verificar que save() guarde una venta con cliente y vendedor asociados
    @Test
    void testSave() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNombre("Carlos Mendoza");

        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(1);
        vendedor.setNombre("Pedro Alvarado");

        Venta v = new Venta();
        v.setFecha(LocalDate.now());
        v.setTotal(new BigDecimal("200000"));
        v.setCliente(cliente); // Asocia cliente a la venta
        v.setVendedor(vendedor); // Asocia vendedor a la venta

        when(ventaRepository.save(v)).thenReturn(v);
        Venta result = ventaService.save(v);
        assertNotNull(result);
        assertEquals("Carlos Mendoza", result.getCliente().getNombre());
        assertEquals("Pedro Alvarado", result.getVendedor().getNombre());
    }

    // Test 4: 
    // Verificar que deleteById() elimine la venta por su ID
    @Test
    void testDeleteById() {
        doNothing().when(ventaRepository).deleteById(1);
        ventaService.deleteById(1);
        verify(ventaRepository, times(1)).deleteById(1);
    }

    // Test 5: 
    // Verificar que findById() retorne vacío cuando la venta no existe
    @Test
    void testFindByIdNotFound() {
        when(ventaRepository.findById(99)).thenReturn(Optional.empty());
        Optional<Venta> result = ventaService.findById(99);
        assertFalse(result.isPresent());
    }
}
