package sportstore.sportstoreapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "detalle_ventas")
public class DetalleVenta {

    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Integer idDetalle;

    // DATOS QUE DETALLAN LAS VENTAS

    // CANTIDAD COMPRADA
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;


    // PRECIO DE CADA UNIDAD
    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal precioUnitario;

    // IDENTIFICADOR UNICO PARA LA VENTA
    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

    // AGREGAR ID DE CADA PRODUCTO DE LA VENTA
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;
}