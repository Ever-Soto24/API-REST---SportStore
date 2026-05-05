package sportstore.sportstoreapi.controller;

import sportstore.sportstoreapi.model.Categoria;
import sportstore.sportstoreapi.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    // Obtener un listado completo de las categorías
    @GetMapping
    public List<Categoria> getAll() {
        return categoriaService.findAll();
    }

    // Buscar una categoría por su id
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Integer id) {
        return categoriaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Registrar una nueva categoría
    @PostMapping
    public Categoria create(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    // Actualizar una categoría por su id
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria categoria) {
        return categoriaService.findById(id).map(existing -> {
            categoria.setIdCategoria(id);
            return ResponseEntity.ok(categoriaService.save(categoria));
        }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar una categoría del sistema
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
