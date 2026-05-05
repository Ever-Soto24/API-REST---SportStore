package sportstore.sportstoreapi.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "vendedores")
public class Vendedor {

    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor")
    private Integer idVendedor;


    // NOMBRE
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    //TELEFONO
    @Column(name = "telefono", length = 20)
    private String telefono;

    //SALARIO
    @Column(name = "salario")
    private BigDecimal salario;

    //FECHA DE INGRESO
    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;
}