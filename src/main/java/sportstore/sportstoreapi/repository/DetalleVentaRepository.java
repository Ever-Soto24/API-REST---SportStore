package sportstore.sportstoreapi.repository;

import sportstore.sportstoreapi.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Repositorio de detalle ventas
// hereda métodos CRUD de JpaRepository para gestionar los detalles de ventas
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
}