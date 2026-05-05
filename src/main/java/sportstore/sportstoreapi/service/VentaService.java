package sportstore.sportstoreapi.service;

import sportstore.sportstoreapi.model.Venta;
import sportstore.sportstoreapi.repository.VentaRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VentaService {

    private final VentaRepository ventaRepository;

    // Obtiene el histórico de todas las ventas realizadas
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    // Busca una transacción de venta específica
    public Optional<Venta> findById(Integer id) {
        return ventaRepository.findById(id);
    }

    // Guarda la cabecera de una nueva operación de venta
    public Venta save(Venta venta) {
        return ventaRepository.save(venta);
    }

    // Elimina el registro de una venta del historial
    public void deleteById(Integer id) {
        ventaRepository.deleteById(id);
    }
}