package antuan.mcsv_backend_legacy.proveedores.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

import antuan.mcsv_backend_legacy.proveedores.dto.ProveedoresRequestDTO;
import antuan.mcsv_backend_legacy.proveedores.dto.ProveedoresResponseDTO;
import antuan.mcsv_backend_legacy.proveedores.service.ProveedoresService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/proveedores")
@RequiredArgsConstructor
@Tag(name = "Proveedores Legacy", description = "API para consultar, registrar, actualizar y "
                + "eliminar proveedores en el sistema legacy SISPRO.")
public class ProveedoresController {

        private final ProveedoresService proveedoresService;

        @Operation(summary = "Listar todos los proveedores", description = "Obtiene el listado completo de proveedores registrados en la tabla legacy 'proveedores'.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
        })
        @GetMapping
        public ResponseEntity<List<ProveedoresResponseDTO>> listarTodas() {
                return ResponseEntity.ok(proveedoresService.listarTodos(null));
        }

        @Operation(summary = "Obtener proveedor por empresa y RUT", description = "Busca un proveedor específico por el código de empresa y su RUT.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Proveedor encontrado"),
                        @ApiResponse(responseCode = "404", description = "Proveedor no encontrado", content = @Content)
        })
        @GetMapping("/{empresa}/{rutProveedor}")
        public ResponseEntity<ProveedoresResponseDTO> obtenerPorEmpresaYRut(
                        @Parameter(description = "Código de la empresa", example = "01") @PathVariable String empresa,
                        @Parameter(description = "RUT del proveedor (sin DV)", example = "12345678") @PathVariable int rutProveedor) {
                return ResponseEntity.ok(proveedoresService.obtenerPorEmpresaYRut(empresa, rutProveedor));
        }

        @Operation(summary = "Obtener proveedores por empresa", description = "Obtiene el listado de proveedores asociados a una empresa específica.")
        @GetMapping("/empresa/{empresa}")
        public ResponseEntity<List<ProveedoresResponseDTO>> obtenerPorEmpresa(
                        @Parameter(description = "Código de la empresa", example = "01") @PathVariable String empresa) {
                return ResponseEntity.ok(proveedoresService.obtenerPorEmpresa(empresa));
        }

        @Operation(summary = "Buscar proveedores por razón social", description = "Realiza una búsqueda parcial de proveedores por su nombre o razón social.")
        @GetMapping("/buscar")
        public ResponseEntity<List<ProveedoresResponseDTO>> buscarPorRazonSocial(
                        @Parameter(description = "Nombre o razón social a buscar") @RequestParam String razonSocial) {
                return ResponseEntity.ok(proveedoresService.obtenerPorRazonSocial(razonSocial));
        }

        @Operation(summary = "Obtener proveedores por vendedor", description = "Obtiene el listado de proveedores asignados a un código de vendedor.")
        @GetMapping("/vendedor/{codigoVendedor}")
        public ResponseEntity<List<ProveedoresResponseDTO>> obtenerPorCodigoVendedor(
                        @Parameter(description = "Código del vendedor") @PathVariable Integer codigoVendedor) {
                return ResponseEntity.ok(proveedoresService.obtenerPorCodigoVendedor(codigoVendedor));
        }

        @Operation(summary = "Crear un nuevo proveedor", description = "Registra un nuevo proveedor en el sistema legacy.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Proveedor creado correctamente"),
                        @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content)
        })
        @PostMapping
        public ResponseEntity<ProveedoresResponseDTO> crear(@Valid @RequestBody ProveedoresRequestDTO request) {
                ProveedoresResponseDTO response = proveedoresService.crear(request);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        @Operation(summary = "Actualizar un proveedor existente", description = "Actualiza los datos de un proveedor identificado por empresa y RUT.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Proveedor actualizado correctamente"),
                        @ApiResponse(responseCode = "404", description = "Proveedor no encontrado", content = @Content)
        })
        @PutMapping("/{empresa}/{rutProveedor}")
        public ResponseEntity<ProveedoresResponseDTO> actualizar(
                        @PathVariable String empresa,
                        @PathVariable int rutProveedor,
                        @Valid @RequestBody ProveedoresRequestDTO request) {
                return ResponseEntity.ok(proveedoresService.actualizar(empresa, rutProveedor, request));
        }

        @Operation(summary = "Eliminar un proveedor", description = "Elimina un proveedor del sistema legacy por su empresa y RUT.")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "204", description = "Proveedor eliminado correctamente"),
                        @ApiResponse(responseCode = "404", description = "Proveedor no encontrado", content = @Content)
        })
        @DeleteMapping("/{empresa}/{rutProveedor}")
        public ResponseEntity<Void> eliminar(@PathVariable String empresa, @PathVariable int rutProveedor) {
                proveedoresService.eliminar(empresa, rutProveedor);
                return ResponseEntity.noContent().build();
        }
}
