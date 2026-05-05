package sportstore.sportstoreapi.controller;

import sportstore.sportstoreapi.model.Vendedor;
import sportstore.sportstoreapi.service.VendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/vendedores")
@RequiredArgsConstructor
public class VendedorController {

    private final VendedorService vendedorService;

    @GetMapping
    public List<Vendedor> getAll() {
        return vendedorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> getById(@PathVariable Integer id) {
        return vendedorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vendedor create(@RequestBody Vendedor vendedor) {
        return vendedorService.save(vendedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> update(@PathVariable Integer id, @RequestBody Vendedor vendedor) {
        return vendedorService.findById(id).map(existing -> {
            vendedor.setIdVendedor(id);
            return ResponseEntity.ok(vendedorService.save(vendedor));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        vendedorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
