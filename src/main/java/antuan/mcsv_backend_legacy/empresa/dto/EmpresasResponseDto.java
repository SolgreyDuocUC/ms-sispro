package antuan.mcsv_backend_legacy.empresa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmpresasResponseDto {

    private Integer rutEmpresa;
    private String digito;
    private String nombreEmpresa;
    private String codigo;
    private String sigla;
    private String giro;
    private Integer rutRepresen;
    private String dvRepresen;
    private String nombreRepresen;
    private String direccion;
    private String comuna;
    private String ciudad;
    private String telefono;
    private String fax;
    private String correo;
    private String codigoActividad;
}
