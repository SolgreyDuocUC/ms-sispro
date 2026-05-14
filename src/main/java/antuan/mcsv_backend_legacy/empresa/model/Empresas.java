package antuan.mcsv_backend_legacy.empresa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empresas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empresas {

    @Id
    @Column(name = "RUT_EMPRESA", nullable = false)
    private Integer rutEmpresa;

    @Column(name = "DIGITO", nullable = false, length = 1)
    private String digito;

    @Column(name = "NOMBRE_EMPRESA", length = 50)
    private String nombreEmpresa;

    @Column(name = "CODIGO", length = 3)
    private String codigo;

    @Column(name = "SIGLA", length = 50)
    private String sigla;

    @Column(name = "GIRO", length = 80)
    private String giro;

    @Column(name = "RUT_REPRESEN")
    private Integer rutRepresen;

    @Column(name = "DV_REPRESEN", length = 1)
    private String dvRepresen;

    @Column(name = "NOMBRE_REPRESEN", length = 50)
    private String nombreRepresen;

    @Column(name = "DIRECCION", length = 50)
    private String direccion;

    @Column(name = "COMUNA", length = 20)
    private String comuna;

    @Column(name = "CIUDAD", length = 20)
    private String ciudad;

    @Column(name = "TELEFONO", length = 20)
    private String telefono;

    @Column(name = "FAX", length = 20)
    private String fax;

    @Column(name = "CORREO", length = 30)
    private String correo;

    @Column(name = "CODIGO_ACTIVIDAD", length = 30)
    private String codigoActividad;
}
