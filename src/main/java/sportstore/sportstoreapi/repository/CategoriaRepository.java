package sportstore.sportstoreapi.repository;

import sportstore.sportstoreapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Repositorio de categorías
// hereda métodos CRUD de JpaRepository para gestionar las categorías
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}


