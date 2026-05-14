package antuan.mcsv_backend_legacy.clientes.dto;

import lombok.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientesResponseDTO {

    private String empresa;
    private int rutCliente;
    private String dvRut;
    private String razonSocial;
    private String sigla;
    private String giro;
    private String direccion;
    private String comuna;
    private String ciudad;
    private String telefono;
    private String fax;
    private String correo;
    private Integer codigoVendedor;
    private Integer condicionPago;
    private Integer listaPrecio;
    private String contacto;
    private String rutComprador;
    private String nombreComprador;
    private Double credMaximo;
    private Timestamp vigenCredito;
    private Integer porDeuda;
    private Integer maxRetro;
    private Timestamp ultCompra;
    private Integer bodega;

}
