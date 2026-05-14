package antuan.mcsv_backend_legacy.empresa.controller;

import antuan.mcsv_backend_legacy.empresa.dto.EmpresasRequestDto;
import antuan.mcsv_backend_legacy.empresa.dto.EmpresasResponseDto;
import antuan.mcsv_backend_legacy.empresa.service.EmpresasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empresas")
@RequiredArgsConstructor
@Tag(
        name = "Empresas Legacy",
        description = "API para consultar, registrar, actualizar y eliminar empresas en el sistema legacy SISPRO. " +
                "Esta tabla actúa como puente para exponer información al sistema antiguo mientras se realiza la migración al ERP."
)
public class EmpresasController {

    private final EmpresasService empresasService;

    @Operation(
            summary = "Listar todas las empresas",
            description = "Obtiene el listado completo de empresas registradas en la tabla legacy 'empresas'."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    })
    @GetMapping
    public ResponseEntity<List<EmpresasResponseDto>> listarTodas() {
        return ResponseEntity.ok(empresasService.listarTodas());
    }

    @Operation(
            summary = "Obtener empresa por RUT",
            description = "Busca una empresa específica por su RUT."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresa encontrada"),
            @ApiResponse(responseCode = "404", description = "Empresa no encontrada", content = @Content)
    })
    @GetMapping("/{rutEmpresa}")
    public ResponseEntity<EmpresasResponseDto> obtenerPorId(
            @Parameter(description = "RUT de la empresa", example = "12345678")
            @PathVariable Integer rutEmpresa
    ) {
        return ResponseEntity.ok(empresasService.obtenerPorId(rutEmpresa));
    }

    @Operation(
            summary = "Crear una nueva empresa",
            description = "Registra una nueva empresa en la tabla legacy 'empresas'."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Empresa creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content),
            @ApiResponse(responseCode = "409", description = "Ya existe una empresa con el mismo RUT", content = @Content)
    })
    @PostMapping
    public ResponseEntity<EmpresasResponseDto> crear(
            @Valid @RequestBody EmpresasRequestDto request
    ) {
        EmpresasResponseDto response = empresasService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Actualizar una empresa existente",
            description = "Actualiza los datos de una empresa existente identificada por RUT."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresa actualizada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Empresa no encontrada", content = @Content)
    })
    @PutMapping("/{rutEmpresa}")
    public ResponseEntity<EmpresasResponseDto> actualizar(
            @Parameter(description = "RUT de la empresa", example = "12345678")
            @PathVariable Integer rutEmpresa,

            @Valid @RequestBody EmpresasRequestDto request
    ) {
        return ResponseEntity.ok(empresasService.actualizar(rutEmpresa, request));
    }

    @Operation(
            summary = "Eliminar una empresa",
            description = "Elimina una empresa del sistema legacy por su RUT."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Empresa eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Empresa no encontrada", content = @Content)
    })
    @DeleteMapping("/{rutEmpresa}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "RUT de la empresa", example = "12345678")
            @PathVariable Integer rutEmpresa
    ) {
        empresasService.eliminar(rutEmpresa);
        return ResponseEntity.noContent().build();
    }
}
