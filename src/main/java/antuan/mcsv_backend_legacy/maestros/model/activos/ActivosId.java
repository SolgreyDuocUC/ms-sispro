package antuan.mcsv_backend_legacy.maestros.model.activos;

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
public class ActivosId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "EMPRESA", nullable = false, length = 3)
    private String empresa;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;
}
