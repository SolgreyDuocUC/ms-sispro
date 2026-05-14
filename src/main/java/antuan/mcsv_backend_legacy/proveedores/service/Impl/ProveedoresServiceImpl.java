package antuan.mcsv_backend_legacy.proveedores.service.Impl;

import org.springframework.stereotype.Service;

import antuan.mcsv_backend_legacy.proveedores.service.ProveedoresService;
import antuan.mcsv_backend_legacy.proveedores.repository.ProveedoresRepository;
import antuan.mcsv_backend_legacy.proveedores.dto.ProveedoresResponseDTO;
import antuan.mcsv_backend_legacy.proveedores.dto.ProveedoresRequestDTO;
import antuan.mcsv_backend_legacy.proveedores.model.proveedores;
import java.util.stream.Collectors;
import java.util.List;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedoresServiceImpl implements ProveedoresService {

    private final ProveedoresRepository proveedoresRepository;

    @Override
    public List<ProveedoresResponseDTO> listarTodos(String empresa) {
        return proveedoresRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProveedoresResponseDTO obtenerPorEmpresaYRut(String empresa, Integer rutProveedor) {
        return proveedoresRepository.findByEmpresaAndRutProveedor(empresa, rutProveedor)
                .map(this::toResponseDTO)
                .orElseThrow(() -> new IllegalStateException(
                        "No se encontró el proveedor con Empresa: " + empresa + " y RUT: " + rutProveedor));
    }

    @Override
    public ProveedoresResponseDTO crear(ProveedoresRequestDTO request) {
        if (proveedoresRepository.findByEmpresaAndRutProveedor(request.getEmpresa(), request.getRutProveedor())
                .isPresent()) {
            throw new IllegalStateException(
                    "Ya existe un proveedor con el RUT: " + request.getRutProveedor());
        }
        proveedores proveedor = new proveedores();
        proveedor.setEmpresa(request.getEmpresa());
        proveedor.setRutProveedor(request.getRutProveedor());
        proveedor.setDvRut(request.getDvRut());
        proveedor.setRazonSocial(request.getRazonSocial());
        proveedor.setDireccion(request.getDireccion());
        proveedor.setComuna(request.getComuna());
        proveedor.setTelefono(request.getTelefono());
        proveedor.setCorreo(request.getCorreo());
        proveedor.setContacto(request.getContacto());
        proveedor.setSigla(request.getSigla());
        proveedor.setGiro(request.getGiro());
        proveedor.setCiudad(request.getCiudad());
        proveedor.setFax(request.getFax());
        proveedor.setCodigoVendedor(request.getCodigoVendedor());
        proveedor.setCondicionPago(request.getCondicionPago());
        proveedor.setListaPrecio(request.getListaPrecio());
        proveedor.setRutComprador(request.getRutComprador());
        proveedor.setNombreComprador(request.getNombreComprador());
        proveedor.setCredMaximo(request.getCredMaximo());
        proveedor.setVigenCredito(request.getVigenCredito());
        proveedor.setPorDeuda(request.getPorDeuda());
        proveedor.setMaxRetraso(request.getMaxRetraso());
        proveedor.setUltCompra(request.getUltCompra());

        proveedores saved = proveedoresRepository.save(proveedor);
        return ProveedoresResponseDTO.builder()
                .empresa(saved.getEmpresa())
                .rutProveedor(saved.getRutProveedor())
                .dvRut(saved.getDvRut())
                .razonSocial(saved.getRazonSocial())
                .direccion(saved.getDireccion())
                .comuna(saved.getComuna())
                .telefono(saved.getTelefono())
                .correo(saved.getCorreo())
                .contacto(saved.getContacto())
                .sigla(saved.getSigla())
                .giro(saved.getGiro())
                .ciudad(saved.getCiudad())
                .fax(saved.getFax())
                .codigoVendedor(saved.getCodigoVendedor())
                .condicionPago(saved.getCondicionPago())
                .listaPrecio(saved.getListaPrecio())
                .rutComprador(saved.getRutComprador())
                .nombreComprador(saved.getNombreComprador())
                .credMaximo(saved.getCredMaximo())
                .vigenCredito(saved.getVigenCredito())
                .porDeuda(saved.getPorDeuda())
                .maxRetraso(saved.getMaxRetraso())
                .ultCompra(saved.getUltCompra())
                .build();
    }

    @Override
    public ProveedoresResponseDTO actualizar(String empresa, Integer rutProveedor, ProveedoresRequestDTO request) {
        proveedores proveedor = proveedoresRepository.findByEmpresaAndRutProveedor(empresa, rutProveedor)
                .orElseThrow(() -> new IllegalStateException(
                        "No se encontró el proveedor con Empresa: " + empresa + " y RUT: " + rutProveedor));
        proveedor.setDvRut(request.getDvRut());
        proveedor.setRazonSocial(request.getRazonSocial());
        proveedor.setDireccion(request.getDireccion());
        proveedor.setComuna(request.getComuna());
        proveedor.setTelefono(request.getTelefono());
        proveedor.setCorreo(request.getCorreo());
        proveedor.setContacto(request.getContacto());
        proveedor.setSigla(request.getSigla());
        proveedor.setGiro(request.getGiro());
        proveedor.setCiudad(request.getCiudad());
        proveedor.setFax(request.getFax());
        proveedor.setCodigoVendedor(request.getCodigoVendedor());
        proveedor.setCondicionPago(request.getCondicionPago());
        proveedor.setListaPrecio(request.getListaPrecio());
        proveedor.setRutComprador(request.getRutComprador());
        proveedor.setNombreComprador(request.getNombreComprador());
        proveedor.setCredMaximo(request.getCredMaximo());
        proveedor.setVigenCredito(request.getVigenCredito());
        proveedor.setPorDeuda(request.getPorDeuda());
        proveedor.setMaxRetraso(request.getMaxRetraso());
        proveedor.setUltCompra(request.getUltCompra());

        proveedores saved = proveedoresRepository.save(proveedor);
        return toResponseDTO(saved);
    }

    @Override
    public void eliminar(String empresa, Integer rutProveedor) {
        proveedores proveedor = proveedoresRepository.findByEmpresaAndRutProveedor(empresa, rutProveedor)
                .orElseThrow(() -> new IllegalStateException(
                        "No se encontró el proveedor con Empresa: " + empresa + " y RUT: " + rutProveedor));
        proveedoresRepository.delete(proveedor);
    }

    @Override
    public List<ProveedoresResponseDTO> obtenerPorRazonSocial(String razonSocial) {
        return proveedoresRepository.findByRazonSocial(razonSocial).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProveedoresResponseDTO> obtenerPorCodigoVendedor(Integer codigoVendedor) {
        return proveedoresRepository.findByCodigoVendedor(codigoVendedor).stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public List<ProveedoresResponseDTO> obtenerPorRutProveedor(Integer rutProveedor) {
        return proveedoresRepository.findByRutProveedor(rutProveedor).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProveedoresResponseDTO> obtenerPorEmpresa(String empresa) {
        return proveedoresRepository.findByEmpresa(empresa).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProveedoresResponseDTO toResponseDTO(proveedores proveedor) {
        return ProveedoresResponseDTO.builder()
                .empresa(proveedor.getEmpresa())
                .rutProveedor(proveedor.getRutProveedor())
                .dvRut(proveedor.getDvRut())
                .razonSocial(proveedor.getRazonSocial())
                .direccion(proveedor.getDireccion())
                .comuna(proveedor.getComuna())
                .telefono(proveedor.getTelefono())
                .correo(proveedor.getCorreo())
                .contacto(proveedor.getContacto())
                .sigla(proveedor.getSigla())
                .giro(proveedor.getGiro())
                .ciudad(proveedor.getCiudad())
                .fax(proveedor.getFax())
                .codigoVendedor(proveedor.getCodigoVendedor())
                .condicionPago(proveedor.getCondicionPago())
                .listaPrecio(proveedor.getListaPrecio())
                .rutComprador(proveedor.getRutComprador())
                .nombreComprador(proveedor.getNombreComprador())
                .credMaximo(proveedor.getCredMaximo())
                .vigenCredito(proveedor.getVigenCredito())
                .porDeuda(proveedor.getPorDeuda())
                .maxRetraso(proveedor.getMaxRetraso())
                .ultCompra(proveedor.getUltCompra())
                .build();
    }

}
