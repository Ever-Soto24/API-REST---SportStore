package sportstore.sportstoreapi.repository;

import sportstore.sportstoreapi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Repositorio de producto
// hereda métodos CRUD de JpaRepository para gestionar los productos
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}

