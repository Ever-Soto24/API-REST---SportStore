package sportstore.sportstoreapi.controller;

import sportstore.sportstoreapi.model.Cliente;
import sportstore.sportstoreapi.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    // Listar todos los clientes registrados
    @GetMapping
    public List<Cliente> getAll() {
        return clienteService.findAll();
    }

    // Obtener detalles de un cliente específico
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        return clienteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo perfil de cliente
    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    // Modificar datos de un cliente por ID
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return clienteService.findById(id).map(existing -> {
            cliente.setIdCliente(id);
            return ResponseEntity.ok(clienteService.save(cliente));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Dar de baja a un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}