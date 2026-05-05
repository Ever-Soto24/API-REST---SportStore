package sportstore.sportstoreapi.controller;
import sportstore.sportstoreapi.model.Producto;
import sportstore.sportstoreapi.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController  // controlador rest
@RequestMapping("/api/productos") // ruta base del controlador
@RequiredArgsConstructor // inyección de dependencias
public class ProductoController {

    // servicio de productos
    private final ProductoService productoService;

    // retornar la lista completa de los productos
    @GetMapping
    public List<Producto> getAll() {
        return productoService.findAll();
    }

    // buscar y retornar un producto por su id
    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable Integer id) {
        return productoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // recibir productos en JSON para almacenar en bd
    @PostMapping
    public Producto create(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    // actualizar un producto existente por su id
    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Integer id, @RequestBody Producto producto) {
        return productoService.findById(id).map(existing -> {
            producto.setIdProducto(id);
            // asignar id para evitar duplicados
            return ResponseEntity.ok(productoService.save(producto));
        }).orElse(ResponseEntity.notFound().build()); // error 404 si no existe
    }

    // eliminar producto por su id
    // cuando se elimina el producto retorna 204
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


