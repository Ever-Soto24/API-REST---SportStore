package sportstore.sportstoreapi.service;

import sportstore.sportstoreapi.model.Vendedor;
import sportstore.sportstoreapi.repository.VendedorRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VendedorService {

    private final VendedorRepository vendedorRepository;

    public List<Vendedor> findAll() {
        return vendedorRepository.findAll();
    }

    public Optional<Vendedor> findById(Integer id) {
        return vendedorRepository.findById(id);
    }

    public Vendedor save(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public void deleteById(Integer id) {
        vendedorRepository.deleteById(id);
    }
}