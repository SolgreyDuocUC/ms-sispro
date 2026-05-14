package antuan.mcsv_backend_legacy.clientes.service.Impl;

import antuan.mcsv_backend_legacy.clientes.service.ClientesService;
import antuan.mcsv_backend_legacy.clientes.repository.ClientesRepository;
import antuan.mcsv_backend_legacy.clientes.dto.ClientesResponseDTO;
import antuan.mcsv_backend_legacy.clientes.dto.ClientesRequestDTO;
import antuan.mcsv_backend_legacy.clientes.model.Clientes;
import antuan.mcsv_backend_legacy.clientes.model.ClientesId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClientesService {

    private final ClientesRepository clientesRepository;

    @Override
    public List<ClientesResponseDTO> listarTodas() {
        return clientesRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClientesResponseDTO> obtenerPorEmpresaYRut(String empresa, int rutCliente) {
        return clientesRepository.findById(new ClientesId(empresa, rutCliente))
                .map(this::toDto);
    }

    @Override
    public List<ClientesResponseDTO> obtenerPorEmpresa(String empresa) {
        return clientesRepository.findByEmpresa(empresa).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientesResponseDTO> buscarPorRazonSocial(String razonSocial) {
        return clientesRepository.findByRazonSocialContaining(razonSocial).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ClientesResponseDTO> obtenerPorCodigoVendedor(Integer codigoVendedor) {
        return clientesRepository.findByCodigoVendedor(codigoVendedor).stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientesResponseDTO crear(ClientesRequestDTO request) {
        if (clientesRepository.findById(new ClientesId(request.getEmpresa(), request.getRutCliente())).isPresent()) {
            throw new IllegalStateException(
                    "Ya existe un cliente con el ID: " + request.getRutCliente());
        }

        Clientes cliente = toEntity(request);
        Clientes saved = clientesRepository.save(cliente);
        return toDto(saved);
    }

    @Override
    public ClientesResponseDTO actualizar(String empresa, int rutCliente, ClientesRequestDTO request) {
        Clientes cliente = clientesRepository.findById(new ClientesId(empresa, rutCliente))
                .orElseThrow(() -> new IllegalStateException(
                        "No se encontró el cliente con Empresa: " + empresa + " y RUT: " + rutCliente));

        cliente.setRazonSocial(request.getRazonSocial());
        cliente.setDireccion(request.getDireccion());
        cliente.setComuna(request.getComuna());
        cliente.setTelefono(request.getTelefono());
        cliente.setCorreo(request.getCorreo());
        cliente.setDvRut(request.getDvRut());
        cliente.setSigla(request.getSigla());
        cliente.setGiro(request.getGiro());
        cliente.setCiudad(request.getCiudad());
        cliente.setFax(request.getFax());
        cliente.setCodigoVendedor(request.getCodigoVendedor());
        cliente.setCondicionPago(request.getCondicionPago());
        cliente.setListaPrecio(request.getListaPrecio());
        cliente.setContacto(request.getContacto());
        cliente.setRutComprador(request.getRutComprador());
        cliente.setNombreComprador(request.getNombreComprador());
        cliente.setCredMaximo(request.getCredMaximo());
        cliente.setVigenCredito(request.getVigenCredito());
        cliente.setPorDeuda(request.getPorDeuda());
        cliente.setMaxRetro(request.getMaxRetro());
        cliente.setUltCompra(request.getUltCompra());
        cliente.setBodega(request.getBodega());
        Clientes updated = clientesRepository.save(cliente);
        return toDto(updated);
    }

    @Override
    public void eliminar(String empresa, int rutCliente) {
        if (!clientesRepository.findById(new ClientesId(empresa, rutCliente)).isPresent()) {
            throw new IllegalStateException(
                    "No se encontró el cliente con ID: " + rutCliente);
        }
        clientesRepository.deleteById(new ClientesId(empresa, rutCliente));
    }

    private ClientesResponseDTO toDto(Clientes cliente) {
        return new ClientesResponseDTO(
                cliente.getEmpresa(),
                cliente.getRutCliente(),
                cliente.getDvRut(),
                cliente.getRazonSocial(),
                cliente.getSigla(),
                cliente.getGiro(),
                cliente.getDireccion(),
                cliente.getComuna(),
                cliente.getCiudad(),
                cliente.getTelefono(),
                cliente.getFax(),
                cliente.getCorreo(),
                cliente.getCodigoVendedor(),
                cliente.getCondicionPago(),
                cliente.getListaPrecio(),
                cliente.getContacto(),
                cliente.getRutComprador(),
                cliente.getNombreComprador(),
                cliente.getCredMaximo(),
                cliente.getVigenCredito(),
                cliente.getPorDeuda(),
                cliente.getMaxRetro(),
                cliente.getUltCompra(),
                cliente.getBodega());
    }

    private Clientes toEntity(ClientesRequestDTO request) {
        return new Clientes(
                request.getEmpresa(),
                request.getRutCliente(),
                request.getDvRut(),
                request.getRazonSocial(),
                request.getSigla(),
                request.getGiro(),
                request.getDireccion(),
                request.getComuna(),
                request.getCiudad(),
                request.getTelefono(),
                request.getFax(),
                request.getCorreo(),
                request.getCodigoVendedor(),
                request.getCondicionPago(),
                request.getListaPrecio(),
                request.getContacto(),
                request.getRutComprador(),
                request.getNombreComprador(),
                request.getCredMaximo(),
                request.getVigenCredito(),
                request.getPorDeuda(),
                request.getMaxRetro(),
                request.getUltCompra(),
                request.getBodega());
    }

}
