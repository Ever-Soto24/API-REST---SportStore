package sportstore.sportstoreapi.service;

import sportstore.sportstoreapi.model.Producto;
import sportstore.sportstoreapi.repository.ProductoRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

// servicio de spring
@Service
// inyectamos dependencias
@RequiredArgsConstructor
public class ProductoService {

    // repositorio de productos
    private final ProductoRepository productoRepository;

    // traemos todos los productos
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    // buscar productos por id
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }

    // guardar y/o actualizar productos
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    // eliminar productos por su id
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }
}






