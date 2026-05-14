package antuan.mcsv_backend_legacy.clientes.controller;

import antuan.mcsv_backend_legacy.clientes.dto.ClientesRequestDTO;
import antuan.mcsv_backend_legacy.clientes.dto.ClientesResponseDTO;
import antuan.mcsv_backend_legacy.clientes.service.ClientesService;
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
@RequestMapping("api/v1/clientes")
@RequiredArgsConstructor
@Tag(name = "Clientes Legacy", description = "API para consultar, registrar, actualizar y "
        + "eliminar clientes en el sistema legacy SISPRO.")
public class ClientesController {

    private final ClientesService clientesService;

    @Operation(summary = "Listar todos los clientes", description = "Obtiene el listado completo de clientes registrados en la tabla legacy 'clientes'.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    })
    @GetMapping
    public ResponseEntity<List<ClientesResponseDTO>> listarTodas() {
        return ResponseEntity.ok(clientesService.listarTodas());
    }

    @Operation(summary = "Obtener cliente por empresa y RUT", description = "Busca un cliente específico por el código de empresa y su RUT.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content)
    })
    @GetMapping("/{empresa}/{rutCliente}")
    public ResponseEntity<ClientesResponseDTO> obtenerPorEmpresaYRut(
            @Parameter(description = "Código de la empresa", example = "01") @PathVariable String empresa,
            @Parameter(description = "RUT del cliente (sin DV)", example = "12345678") @PathVariable int rutCliente
    ) {
        return clientesService.obtenerPorEmpresaYRut(empresa, rutCliente)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Obtener clientes por empresa", description = "Obtiene el listado de clientes asociados a una empresa específica.")
    @GetMapping("/empresa/{empresa}")
    public ResponseEntity<List<ClientesResponseDTO>> obtenerPorEmpresa(
            @Parameter(description = "Código de la empresa", example = "01") @PathVariable String empresa
    ) {
        return ResponseEntity.ok(clientesService.obtenerPorEmpresa(empresa));
    }

    @Operation(summary = "Buscar clientes por razón social", description = "Realiza una búsqueda parcial de clientes por su nombre o razón social.")
    @GetMapping("/buscar")
    public ResponseEntity<List<ClientesResponseDTO>> buscarPorRazonSocial(
            @Parameter(description = "Nombre o razón social a buscar") @RequestParam String razonSocial
    ) {
        return ResponseEntity.ok(clientesService.buscarPorRazonSocial(razonSocial));
    }

    @Operation(summary = "Obtener clientes por vendedor", description = "Obtiene el listado de clientes asignados a un código de vendedor.")
    @GetMapping("/vendedor/{codigoVendedor}")
    public ResponseEntity<List<ClientesResponseDTO>> obtenerPorCodigoVendedor(
            @Parameter(description = "Código del vendedor") @PathVariable Integer codigoVendedor
    ) {
        return ResponseEntity.ok(clientesService.obtenerPorCodigoVendedor(codigoVendedor));
    }

    @Operation(summary = "Crear un nuevo cliente", description = "Registra un nuevo cliente en el sistema legacy.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos", content = @Content)
    })
    @PostMapping
    public ResponseEntity<ClientesResponseDTO> crear(@Valid @RequestBody ClientesRequestDTO request) {
        ClientesResponseDTO response = clientesService.crear(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Actualizar un cliente existente", description = "Actualiza los datos de un cliente identificado por empresa y RUT.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content)
    })
    @PutMapping("/{empresa}/{rutCliente}")
    public ResponseEntity<ClientesResponseDTO> actualizar(
            @PathVariable String empresa,
            @PathVariable int rutCliente,
            @Valid @RequestBody ClientesRequestDTO request
    ) {
        return ResponseEntity.ok(clientesService.actualizar(empresa, rutCliente, request));
    }

    @Operation(summary = "Eliminar un cliente", description = "Elimina un cliente del sistema legacy por su empresa y RUT.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content)
    })
    @DeleteMapping("/{empresa}/{rutCliente}")
    public ResponseEntity<Void> eliminar(@PathVariable String empresa, @PathVariable int rutCliente) {
        clientesService.eliminar(empresa, rutCliente);
        return ResponseEntity.noContent().build();
    }
}