package antuan.mcsv_backend_legacy.maestros.model.articulos;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "articulos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Articulos implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ArticulosId id;

    @Column(name = "Descripcion", nullable = false, length = 60)
    private String descripcion;

    @Column(name = "Comentario", length = 50)
    private String comentario;

    @Column(name = "Moneda_Compra")
    private Integer monedaCompra;

    @Column(name = "Moneda_venta")
    private Integer monedaVenta;

    @Column(name = "Unidad_Medida", length = 10)
    private String unidadMedida;

    @Column(name = "Precio_Venta")
    private Integer precioVenta;

    @Column(name = "Ubicación", length = 50)
    private String ubicacion;

    @Column(name = "Costo")
    private Integer costo;

    @Column(name = "Costo_Ult_Compra")
    private Integer costoUltCompra;

    @Column(name = "Fecha_Ult_Compra")
    private LocalDateTime fechaUltCompra;

    @Column(name = "Stock_Minimo")
    private Integer stockMinimo;

    @Column(name = "Stock_Maximo")
    private Integer stockMaximo;

    @Column(name = "Medida_Alternativa", length = 50)
    private String medidaAlternativa;

    @Column(name = "Factor")
    private Integer factor;

    @Column(name = "Procedencia", length = 1)
    private String procedencia;

    @Column(name = "Lotes")
    private Boolean lotes;

    @Column(name = "Seriales")
    private Boolean seriales;

    @Column(name = "Compras")
    private Boolean compras;

    @Column(name = "Comision")
    private Integer comision;

    @Column(name = "ControlaStock")
    private Boolean controlaStock;

    @Column(name = "Plantilla")
    private Integer plantilla;

    @Column(name = "CodigoBarra", length = 50)
    private String codigoBarra;

    @Column(name = "Activo")
    private Boolean activo;
}
