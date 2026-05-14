package antuan.mcsv_backend_legacy.proveedores.dto;

import lombok.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProveedoresResponseDTO {

    private String empresa;
    private Integer rutProveedor;
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
    private double credMaximo;
    private Timestamp vigenCredito;
    private Integer porDeuda;
    private Integer maxRetraso;
    private Timestamp ultCompra;

}
