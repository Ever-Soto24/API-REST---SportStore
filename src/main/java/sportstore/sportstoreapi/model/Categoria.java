package sportstore.sportstoreapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categorias")
public class Categoria {

    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    // NOMBRE DE LA CATEGORÍA
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    // DESCRIPCIÓN DE LA CATEGORÍA
    @Column(name = "descripcion", length = 100)
    private String descripcion;
}