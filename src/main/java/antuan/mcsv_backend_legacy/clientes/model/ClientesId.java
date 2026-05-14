package antuan.mcsv_backend_legacy.clientes.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ClientesId implements Serializable {

    private String empresa;
    private int rutCliente;

}
