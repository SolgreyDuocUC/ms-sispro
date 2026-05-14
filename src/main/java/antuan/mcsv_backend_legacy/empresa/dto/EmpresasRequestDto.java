package antuan.mcsv_backend_legacy.empresa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class EmpresasRequestDto {

    @NotNull(message = "El RUT de la empresa es obligatorio")
    private Integer rutEmpresa;

    @NotBlank(message = "El dígito es obligatorio")
    @Size(max = 1, message = "El dígito no puede superar 1 carácter")
    private String digito;

    @Size(max = 50, message = "El nombre de empresa no puede superar 50 caracteres")
    private String nombreEmpresa;

    @Size(max = 3, message = "El código no puede superar 3 caracteres")
    private String codigo;

    @Size(max = 50, message = "La sigla no puede superar 50 caracteres")
    private String sigla;

    @Size(max = 80, message = "El giro no puede superar 80 caracteres")
    private String giro;

    private Integer rutRepresen;

    @Size(max = 1, message = "El DV del representante no puede superar 1 carácter")
    private String dvRepresen;

    @Size(max = 50, message = "El nombre del representante no puede superar 50 caracteres")
    private String nombreRepresen;

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

    @Size(max = 30, message = "El código de actividad no puede superar 30 caracteres")
    private String codigoActividad;
}
