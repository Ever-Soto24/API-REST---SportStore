package sportstore.sportstoreapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ventas")
public class Venta {

    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Integer idVenta;

    // FECHA DE LA VENTA
    @Column(name = "fecha")
    private LocalDate fecha;

    // TOTAL DE LA VENTA
    @Column(name = "total")
    private BigDecimal total;

    // ID DEL CLIENTE AL QUE SE REALIZÓ LA VENTA
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    // ID DEL VENDEDOR QUE REALIZÓ LA VENTA
    @ManyToOne
    @JoinColumn(name = "id_vendedor", nullable = false)
    private Vendedor vendedor;
}
