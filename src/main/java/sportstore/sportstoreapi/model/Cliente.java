package sportstore.sportstoreapi.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;

    // NOMBRE DEL CLIENTE
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // TELEFONO DEL CLIENTE
    @Column(name = "telefono", length = 20)
    private String telefono;

    // CORREO DEL CLIENTE
    @Column(name = "email", length = 100)
    private String email;

    // CIUDAD DEL CLIENTE
    @Column(name = "ciudad", length = 50)
    private String ciudad;
}