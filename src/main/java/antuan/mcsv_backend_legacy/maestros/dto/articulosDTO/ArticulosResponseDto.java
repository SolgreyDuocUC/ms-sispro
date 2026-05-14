package antuan.mcsv_backend_legacy.maestros.dto.articulosDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticulosResponseDto {

    private String empresa;
    private String codigoArticulo;
    private String descripcion;
    private String comentario;
    private Integer monedaCompra;
    private Integer monedaVenta;
    private String unidadMedida;
    private Integer precioVenta;
    private String ubicacion;
    private Integer costo;
    private Integer costoUltCompra;
    private LocalDateTime fechaUltCompra;
    private Integer stockMinimo;
    private Integer stockMaximo;
    private String medidaAlternativa;
    private Integer factor;
    private String procedencia;
    private Boolean lotes;
    private Boolean seriales;
    private Boolean compras;
    private Integer comision;
    private Boolean controlaStock;
    private Integer plantilla;
    private String codigoBarra;
    private Boolean activo;
}
