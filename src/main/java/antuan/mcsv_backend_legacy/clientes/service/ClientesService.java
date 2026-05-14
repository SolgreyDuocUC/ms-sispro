package antuan.mcsv_backend_legacy.clientes.service;

import antuan.mcsv_backend_legacy.clientes.dto.ClientesResponseDTO;
import antuan.mcsv_backend_legacy.clientes.dto.ClientesRequestDTO;

import java.util.List;
import java.util.Optional;

public interface ClientesService {

    List<ClientesResponseDTO> listarTodas();

    Optional<ClientesResponseDTO> obtenerPorEmpresaYRut(String empresa, int rutCliente);

    List<ClientesResponseDTO> obtenerPorEmpresa(String empresa);

    List<ClientesResponseDTO> buscarPorRazonSocial(String razonSocial);

    List<ClientesResponseDTO> obtenerPorCodigoVendedor(Integer codigoVendedor);

    ClientesResponseDTO crear(ClientesRequestDTO dto);

    ClientesResponseDTO actualizar(String empresa, int rutCliente, ClientesRequestDTO dto);

    void eliminar(String empresa, int rutCliente);

}
