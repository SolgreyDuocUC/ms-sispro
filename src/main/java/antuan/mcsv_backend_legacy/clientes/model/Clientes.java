package antuan.mcsv_backend_legacy.clientes.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import jakarta.persistence.IdClass;

import java.sql.Timestamp;

@Entity
@Table(name = "clientes")
@IdClass(ClientesId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Clientes {

    @Id
    @Column(name = "EMPRESA", nullable = false, length = 3)
    private String empresa;

    @Id
    @Column(name = "RUT_CLIENTE", nullable = false, length = 11)
    private int rutCliente;

    @Column(name = "DV_RUT", nullable = false, length = 1)
    private String dvRut;

    @Column(name = "RAZON_SOCIAL", nullable = true, length = 100)
    private String razonSocial;

    @Column(name = "SIGLA", nullable = true, length = 60)
    private String sigla;

    @Column(name = "GIRO", nullable = true, length = 50)
    private String giro;

    @Column(name = "DIRECCION", nullable = true, length = 100)
    private String direccion;

    @Column(name = "COMUNA", nullable = true, length = 50)
    private String comuna;

    @Column(name = "CIUDAD", nullable = true, length = 50)
    private String ciudad;

    @Column(name = "TELEFONO", nullable = true, length = 15)
    private String telefono;

    @Column(name = "FAX", nullable = true, length = 15)
    private String fax;

    @Column(name = "CORREO", nullable = true, length = 50)
    private String correo;

    @Column(name = "CODIGO_VENDEDOR", nullable = true, length = 11)
    private Integer codigoVendedor;

    @Column(name = "CONDICION_PAGO", nullable = true, length = 11)
    private Integer condicionPago;

    @Column(name = "LISTA_PRECIO", nullable = true, length = 11)
    private Integer listaPrecio;

    @Column(name = "CONTACTO", nullable = true, length = 50)
    private String contacto;

    @Column(name = "RUT_COMPRADOR", nullable = true, length = 12)
    private String rutComprador;

    @Column(name = "NOMBRE_COMPRADOR", nullable = true, length = 50)
    private String nombreComprador;

    @Column(name = "CRED_MAXIMO", nullable = true)
    private Double credMaximo;

    @Column(name = "VIGEN_CREDITO", nullable = true)
    private Timestamp vigenCredito;

    @Column(name = "POR_DEUDA", nullable = true, length = 11)
    private Integer porDeuda;

    @Column(name = "MAX_RETRASO", nullable = true, length = 11)
    private Integer maxRetro;

    @Column(name = "ULT_COMPRA", nullable = true)
    private Timestamp ultCompra;

    @Column(name = "BODEGA", nullable = true, length = 11)
    private Integer bodega;

}
