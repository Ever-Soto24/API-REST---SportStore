package sportstore.sportstoreapi.controller;

import sportstore.sportstoreapi.model.Venta;
import sportstore.sportstoreapi.service.VentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService;

    // Recuperar historial de todas las ventas
    @GetMapping
    public List<Venta> getAll() {
        return ventaService.findAll();
    }

    // Buscar una transacción de venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Venta> getById(@PathVariable Integer id) {
        return ventaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Registrar una nueva transacción de venta
    @PostMapping
    public Venta create(@RequestBody Venta venta) {
        return ventaService.save(venta);
    }

    // Editar datos de una venta realizada
    @PutMapping("/{id}")
    public ResponseEntity<Venta> update(@PathVariable Integer id, @RequestBody Venta venta) {
        return ventaService.findById(id).map(existing -> {
            venta.setIdVenta(id);
            return ResponseEntity.ok(ventaService.save(venta));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Anular o eliminar registro de venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ventaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}