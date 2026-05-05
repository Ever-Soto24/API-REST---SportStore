package sportstore.sportstoreapi.controller;

import sportstore.sportstoreapi.model.DetalleVenta;
import sportstore.sportstoreapi.service.DetalleVentaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/detalle-ventas")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final DetalleVentaService detalleVentaService;

    @GetMapping
    public List<DetalleVenta> getAll() {
        return detalleVentaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> getById(@PathVariable Integer id) {
        return detalleVentaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public DetalleVenta create(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.save(detalleVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleVenta> update(@PathVariable Integer id, @RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.findById(id).map(existing -> {
            detalleVenta.setIdDetalle(id);
            return ResponseEntity.ok(detalleVentaService.save(detalleVenta));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        detalleVentaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}