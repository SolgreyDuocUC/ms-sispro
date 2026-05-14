package antuan.mcsv_backend_legacy.maestros.controller;

import antuan.mcsv_backend_legacy.maestros.dto.articulosDTO.ArticulosRequestDto;
import antuan.mcsv_backend_legacy.maestros.dto.articulosDTO.ArticulosResponseDto;
import antuan.mcsv_backend_legacy.maestros.service.ArticulosService;
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
@RequestMapping("/api/v1/articulos")
@RequiredArgsConstructor
@Tag(
        name = "Artículos Legacy",
        description = "API para consultar, registrar, actualizar y eliminar artículos del sistema legacy SISPRO. " +
                "Esta tabla actúa como puente para exponer información al sistema antiguo mientras se realiza la migración al ERP."
)
public class ArticulosController {

    private final ArticulosService articulosService;

    @Operation(
            summary = "Listar todos los artículos",
            description = "Obtiene el listado completo de artículos registrados en la tabla legacy 'articulos'."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    })
    @GetMapping
    public ResponseEntity<List<ArticulosResponseDto>> listarTodos() {
        return ResponseEntity.ok(articulosService.listarTodos());
    }

    @Operation(
            summary = "Obtener un artículo por clave compuesta",
            description = "Busca un artículo específico utilizando la clave compuesta: EMPRESA + Codigo_Articulo."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Artículo encontrado"),
            @ApiResponse(responseCode = "404", description = "Artículo no encontrado", content = @Content)
    })
    @GetMapping("/{empresa}/{codigoArticulo}")
    public ResponseEntity<ArticulosResponseDto> obtenerPorId(
            @Parameter(description = "Código de empresa del artículo", example = "001")
            @PathVariable String empresa,

            @Parameter(description = "Código único del artículo", example = "TELA001")
            @PathVariable String codigoArticulo
    ) {
        return ResponseEntity.ok(articulosService.obtenerPorId(empresa, codigoArticulo));
    }

    @Operation(
            summary = "Listar artículos por empresa",
            description = "Obtiene todos los artículos asociados a una empresa específica."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    })
    @GetMapping("/empresa/{empresa}")
    public ResponseEntity<List<ArticulosResponseDto>> listarPorEmpresa(
            @Parameter(description = "Código de empresa", example = "001")
            @PathVariable String empresa
    ) {
        return ResponseEntity.ok(articulosService.listarPorEmpresa(empresa));
    }

    @Operation(
            summary = "Buscar artículos por descripción",
            description = "Permite buscar artículos cuyo nombre o descripción contenga un texto determinado."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Búsqueda realizada correctamente")
    })
    @GetMapping("/buscar")
    public ResponseEntity<List<ArticulosResponseDto>> buscarPorDescripcion(
            @Parameter(description = "Texto a buscar dentro de la descripción", example = "tela")
            @RequestParam String descripcion
    ) {
        return ResponseEntity.ok(articulosService.buscarPorDescripcion(descripcion));
    }

    @Operation(
            summary = "Crear un nuevo artículo",
            description = "Registra un nuevo artículo en la tabla legacy 'articulos'. " +
                    "Este endpoint permitirá en el futuro recibir información traducida o desnormalizada desde el ERP."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Artículo creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content),
            @ApiResponse(responseCode = "409", description = "Ya existe un artículo con la misma clave", content = @Content)
    })
    @PostMapping
    public ResponseEntity<ArticulosResponseDto> crear(
            @Valid @RequestBody ArticulosRequestDto request
    ) {
        ArticulosResponseDto response = articulosService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
            summary = "Actualizar un artículo existente",
            description = "Actualiza los datos de un artículo existente identificado por EMPRESA + Codigo_Articulo."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Artículo actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content),
            @ApiResponse(responseCode = "404", description = "Artículo no encontrado", content = @Content)
    })
    @PutMapping("/{empresa}/{codigoArticulo}")
    public ResponseEntity<ArticulosResponseDto> actualizar(
            @Parameter(description = "Código de empresa del artículo", example = "001")
            @PathVariable String empresa,

            @Parameter(description = "Código único del artículo", example = "TELA001")
            @PathVariable String codigoArticulo,

            @Valid @RequestBody ArticulosRequestDto request
    ) {
        return ResponseEntity.ok(articulosService.actualizar(empresa, codigoArticulo, request));
    }

    @Operation(
            summary = "Eliminar un artículo",
            description = "Elimina un artículo del sistema legacy según su clave compuesta EMPRESA + Codigo_Articulo."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Artículo eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Artículo no encontrado", content = @Content)
    })
    @DeleteMapping("/{empresa}/{codigoArticulo}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "Código de empresa del artículo", example = "001")
            @PathVariable String empresa,

            @Parameter(description = "Código único del artículo", example = "TELA001")
            @PathVariable String codigoArticulo
    ) {
        articulosService.eliminar(empresa, codigoArticulo);
        return ResponseEntity.noContent().build();
    }
}
