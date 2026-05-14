package antuan.mcsv_backend_legacy.proveedores.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProveedoresId implements Serializable {

    private String empresa;
    private Integer rutProveedor;

}
