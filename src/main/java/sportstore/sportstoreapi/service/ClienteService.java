package sportstore.sportstoreapi.service;

import sportstore.sportstoreapi.model.Cliente;
import sportstore.sportstoreapi.repository.ClienteRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // Obtiene el listado global de clientes registrados
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    // Localiza a un cliente por su clave primaria
    public Optional<Cliente> findById(Integer id) {
        return clienteRepository.findById(id);
    }

    // Almacena los datos de un cliente en el sistema
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Remueve permanentemente a un cliente del registro
    public void deleteById(Integer id) {
        clienteRepository.deleteById(id);
    }
}