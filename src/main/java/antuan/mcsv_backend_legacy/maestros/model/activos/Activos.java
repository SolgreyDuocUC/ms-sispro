package antuan.mcsv_backend_legacy.maestros.model.activos;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "activos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activos {

    @EmbeddedId
    private ActivosId id;

    @Column(name = "DESCRIPCION", length = 50)
    private String descripcion;
}
