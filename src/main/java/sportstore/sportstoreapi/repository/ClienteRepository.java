package sportstore.sportstoreapi.repository;

import sportstore.sportstoreapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Repositorio de cliente
// hereda métodos CRUD de JpaRepository para gestionar clientes
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}