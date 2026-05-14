package antuan.mcsv_backend_legacy.maestros.dto.articulosDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticulosRequestDto {

    @NotBlank(message = "La empresa es obligatoria")
    @Size(max = 3, message = "La empresa no puede superar 3 caracteres")
    private String empresa;

    @NotBlank(message = "El código del artículo es obligatorio")
    @Size(max = 20, message = "El código del artículo no puede superar 20 caracteres")
    private String codigoArticulo;

    @NotBlank(message = "La descripción es obligatoria")
    @Size(max = 60, message = "La descripción no puede superar 60 caracteres")
    private String descripcion;

    @Size(max = 50, message = "El comentario no puede superar 50 caracteres")
    private String comentario;

    @PositiveOrZero(message = "La moneda de compra no puede ser negativa")
    private Integer monedaCompra;

    @PositiveOrZero(message = "La moneda de venta no puede ser negativa")
    private Integer monedaVenta;

    @Size(max = 10, message = "La unidad de medida no puede superar 10 caracteres")
    private String unidadMedida;

    @PositiveOrZero(message = "El precio de venta no puede ser negativo")
    private Integer precioVenta;

    @Size(max = 50, message = "La ubicación no puede superar 50 caracteres")
    private String ubicacion;

    @PositiveOrZero(message = "El costo no puede ser negativo")
    private Integer costo;

    @PositiveOrZero(message = "El costo de última compra no puede ser negativo")
    private Integer costoUltCompra;

    private LocalDateTime fechaUltCompra;

    @PositiveOrZero(message = "El stock mínimo no puede ser negativo")
    private Integer stockMinimo;

    @PositiveOrZero(message = "El stock máximo no puede ser negativo")
    private Integer stockMaximo;

    @Size(max = 50, message = "La medida alternativa no puede superar 50 caracteres")
    private String medidaAlternativa;

    @PositiveOrZero(message = "El factor no puede ser negativo")
    private Integer factor;

    @Size(max = 1, message = "La procedencia no puede superar 1 carácter")
    private String procedencia;

    private Boolean lotes;
    private Boolean seriales;
    private Boolean compras;

    @PositiveOrZero(message = "La comisión no puede ser negativa")
    private Integer comision;

    private Boolean controlaStock;

    @PositiveOrZero(message = "La plantilla no puede ser negativa")
    private Integer plantilla;

    @Size(max = 50, message = "El código de barra no puede superar 50 caracteres")
    private String codigoBarra;

    private Boolean activo;
}
