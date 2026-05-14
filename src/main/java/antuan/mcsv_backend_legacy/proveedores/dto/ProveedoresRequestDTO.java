package antuan.mcsv_backend_legacy.proveedores.dto;

import lombok.*;
import java.sql.Timestamp;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProveedoresRequestDTO {

    @NotNull(message = "La empresa es obligatoria")
    @Size(max = 3, message = "La empresa no puede superar 3 caracteres")
    private String empresa;

    @NotNull(message = "El rut del proveedor es obligatorio")
    private Integer rutProveedor;

    @NotNull(message = "El dígito es obligatorio")
    @Size(max = 1, message = "El dígito no puede superar 1 carácter")
    private String dvRut;

    @NotNull(message = "La razón social es obligatoria")
    @Size(max = 50, message = "La razón social no puede superar 50 caracteres")
    private String razonSocial;

    @Size(max = 50, message = "La sigla no puede superar 50 caracteres")
    private String sigla;

    @Size(max = 80, message = "El giro no puede superar 80 caracteres")
    private String giro;

    @Size(max = 50, message = "La dirección no puede superar 50 caracteres")
    private String direccion;

    @Size(max = 20, message = "La comuna no puede superar 20 caracteres")
    private String comuna;

    @Size(max = 20, message = "La ciudad no puede superar 20 caracteres")
    private String ciudad;

    @Size(max = 20, message = "El teléfono no puede superar 20 caracteres")
    private String telefono;

    @Size(max = 20, message = "El fax no puede superar 20 caracteres")
    private String fax;

    @Size(max = 30, message = "El correo no puede superar 30 caracteres")
    private String correo;

    @Size(max = 11, message = "El código de vendedor no puede superar 11 caracteres")
    private Integer codigoVendedor;

    @Size(max = 11, message = "La condición de pago no puede superar 11 caracteres")
    private Integer condicionPago;

    @Size(max = 11, message = "La lista de precios no puede superar 11 caracteres")
    private Integer listaPrecio;

    @Size(max = 50, message = "El contacto no puede superar 50 caracteres")
    private String contacto;

    @Size(max = 12, message = "El rut del comprador no puede superar 12 caracteres")
    private String rutComprador;

    @Size(max = 50, message = "El nombre del comprador no puede superar 50 caracteres")
    private String nombreComprador;

    private double credMaximo;

    private Timestamp vigenCredito;

    @Size(max = 11, message = "El porcentaje de deuda no puede superar 11 caracteres")
    private Integer porDeuda;

    @Size(max = 11, message = "El máximo de retraso no puede superar 11 caracteres")
    private Integer maxRetraso;

    @Size(max = 11, message = "La última compra no puede superar 11 caracteres")
    private Timestamp ultCompra;

}
