package sportstore.sportstoreapi.model;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

// generar setters, getters y constructores
@Data

// esta clase es una entidad JPA
@Entity

// mapear clase según tabla productos
@Table(name = "productos")
public class Producto {

    // clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;

    // nombre del producto
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // precio del producto
    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    // stock
    @Column(name = "stock", nullable = false)
    private Integer stock;

    // relación uno a muchos con tabla categorías
    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
}



