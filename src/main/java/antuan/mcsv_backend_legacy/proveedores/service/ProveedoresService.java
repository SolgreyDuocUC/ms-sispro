package antuan.mcsv_backend_legacy.proveedores.service;

import antuan.mcsv_backend_legacy.proveedores.dto.ProveedoresResponseDTO;
import antuan.mcsv_backend_legacy.proveedores.dto.ProveedoresRequestDTO;
import antuan.mcsv_backend_legacy.proveedores.model.proveedores;
import java.util.List;

public interface ProveedoresService {

    List<ProveedoresResponseDTO> listarTodos(String empresa);

    ProveedoresResponseDTO obtenerPorEmpresaYRut(String empresa, Integer rutProveedor);

    ProveedoresResponseDTO crear(ProveedoresRequestDTO request);

    ProveedoresResponseDTO actualizar(String empresa, Integer rutProveedor, ProveedoresRequestDTO request);

    void eliminar(String empresa, Integer rutProveedor);

    List<ProveedoresResponseDTO> obtenerPorRazonSocial(String razonSocial);

    List<ProveedoresResponseDTO> obtenerPorCodigoVendedor(Integer codigoVendedor);

    List<ProveedoresResponseDTO> obtenerPorRutProveedor(Integer rutProveedor);

    List<ProveedoresResponseDTO> obtenerPorEmpresa(String empresa);

    ProveedoresResponseDTO toResponseDTO(proveedores proveedor);

}