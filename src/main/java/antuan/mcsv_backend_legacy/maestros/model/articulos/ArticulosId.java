package antuan.mcsv_backend_legacy.maestros.model.articulos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ArticulosId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "EMPRESA", nullable = false, length = 3)
    private String empresa;

    @Column(name = "Codigo_Articulo", nullable = false, length = 20)
    private String codigoArticulo;
}
