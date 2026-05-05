package sportstore.sportstoreapi.repository;

import sportstore.sportstoreapi.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Repositorio de vendedores
// hereda métodos CRUD de JpaRepository para gestionar vendedores
public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {

}