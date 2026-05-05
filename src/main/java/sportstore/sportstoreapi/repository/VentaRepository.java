package sportstore.sportstoreapi.repository;

import sportstore.sportstoreapi.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Repositorio de venta
// hereda métodos CRUD de JpaRepository para gestionar las ventas
public interface VentaRepository extends JpaRepository<Venta, Integer> {
}