package sportstore.sportstoreapi.service;

import sportstore.sportstoreapi.model.Cliente;
import sportstore.sportstoreapi.repository.ClienteRepository;
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
class ClienteServiceTest {

    // Mock del repositorio para simular la base de datos
    @Mock
    private ClienteRepository clienteRepository;

    // Instancia del servicio con el mock
    @InjectMocks
    private ClienteService clienteService;

    // Test 1: 
    // Verificar que findAll() retorne la lista completa de clientes
    @Test
    void testFindAll() {
        Cliente c = new Cliente();
        c.setIdCliente(1);
        c.setNombre("Carlos Mendoza");
        when(clienteRepository.findAll()).thenReturn(Arrays.asList(c));
        List<Cliente> result = clienteService.findAll();
        assertEquals(1, result.size());
        verify(clienteRepository, times(1)).findAll();
    }

    // Test 2: 
    // Verificar que findById() retorne el cliente correcto por su ID
    @Test
    void testFindById() {
        Cliente c = new Cliente();
        c.setIdCliente(1);
        c.setNombre("Carlos Mendoza");
        when(clienteRepository.findById(1)).thenReturn(Optional.of(c));
        Optional<Cliente> result = clienteService.findById(1);
        assertTrue(result.isPresent());
        assertEquals("Carlos Mendoza", result.get().getNombre());
    }

    // Test 3: 
    // Verificar que save() guarde y retorne el cliente correctamente
    @Test
    void testSave() {
        Cliente c = new Cliente();
        c.setNombre("Laura Perez");
        when(clienteRepository.save(c)).thenReturn(c);
        Cliente result = clienteService.save(c);
        assertNotNull(result);
        assertEquals("Laura Perez", result.getNombre());
    }

    // Test 4: 
    // Verificar que deleteById() elimine el cliente por su ID
    @Test
    void testDeleteById() {
        doNothing().when(clienteRepository).deleteById(1);
        clienteService.deleteById(1);
        verify(clienteRepository, times(1)).deleteById(1);
    }

    // Test 5: 
    // Verificar que findById() retorne vacío cuando el cliente no exista
    @Test
    void testFindByIdNotFound() {
        when(clienteRepository.findById(99)).thenReturn(Optional.empty());
        Optional<Cliente> result = clienteService.findById(99);
        assertFalse(result.isPresent());
    }
}