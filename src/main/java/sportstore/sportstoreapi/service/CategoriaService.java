package sportstore.sportstoreapi.service;

import sportstore.sportstoreapi.model.Categoria;
import sportstore.sportstoreapi.repository.CategoriaRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    // MUESTRA la lista de todas las categorías disponibles
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    // Busca una categoría específica mediante su identificador
    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }

    // Procesa el registro o actualización de una categoría
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Gestiona la eliminación física de una categoría por ID
    public void deleteById(Integer id) {
        categoriaRepository.deleteById(id);
    }
}