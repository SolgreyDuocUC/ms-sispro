package antuan.mcsv_backend_legacy.empresa.service.Impl;

import antuan.mcsv_backend_legacy.empresa.dto.EmpresasRequestDto;
import antuan.mcsv_backend_legacy.empresa.dto.EmpresasResponseDto;
import antuan.mcsv_backend_legacy.empresa.model.Empresas;
import antuan.mcsv_backend_legacy.empresa.repository.EmpresasRepository;
import antuan.mcsv_backend_legacy.empresa.service.EmpresasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmpresasServiceImpl implements EmpresasService {

    private final EmpresasRepository empresasRepository;

    @Override
    public List<EmpresasResponseDto> listarTodas() {
        return empresasRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public EmpresasResponseDto obtenerPorId(Integer rutEmpresa) {
        Empresas empresa = empresasRepository.findById(rutEmpresa)
                .orElseThrow(() -> new NoSuchElementException("Empresa no encontrada con RUT: " + rutEmpresa));

        return toResponseDto(empresa);
    }

    @Override
    public EmpresasResponseDto crear(EmpresasRequestDto request) {
        if (empresasRepository.existsById(request.getRutEmpresa())) {
            throw new IllegalStateException(
                    "Ya existe una empresa con el RUT: " + request.getRutEmpresa());
        }

        Empresas empresa = toEntity(request);
        Empresas guardada = empresasRepository.save(empresa);
        return toResponseDto(guardada);
    }

    @Override
    public EmpresasResponseDto actualizar(Integer rutEmpresa, EmpresasRequestDto request) {
        Empresas empresa = empresasRepository.findById(rutEmpresa)
                .orElseThrow(() -> new NoSuchElementException("Empresa no encontrada con RUT: " + rutEmpresa));

        empresa.setDigito(request.getDigito());
        empresa.setNombreEmpresa(request.getNombreEmpresa());
        empresa.setCodigo(request.getCodigo());
        empresa.setSigla(request.getSigla());
        empresa.setGiro(request.getGiro());
        empresa.setRutRepresen(request.getRutRepresen());
        empresa.setDvRepresen(request.getDvRepresen());
        empresa.setNombreRepresen(request.getNombreRepresen());
        empresa.setDireccion(request.getDireccion());
        empresa.setComuna(request.getComuna());
        empresa.setCiudad(request.getCiudad());
        empresa.setTelefono(request.getTelefono());
        empresa.setFax(request.getFax());
        empresa.setCorreo(request.getCorreo());
        empresa.setCodigoActividad(request.getCodigoActividad());

        Empresas actualizada = empresasRepository.save(empresa);
        return toResponseDto(actualizada);
    }

    @Override
    public void eliminar(Integer rutEmpresa) {
        Empresas empresa = empresasRepository.findById(rutEmpresa)
                .orElseThrow(() -> new NoSuchElementException("Empresa no encontrada con RUT: " + rutEmpresa));

        empresasRepository.delete(empresa);
    }

    private EmpresasResponseDto toResponseDto(Empresas empresa) {
        return new EmpresasResponseDto(
                empresa.getRutEmpresa(),
                empresa.getDigito(),
                empresa.getNombreEmpresa(),
                empresa.getCodigo(),
                empresa.getSigla(),
                empresa.getGiro(),
                empresa.getRutRepresen(),
                empresa.getDvRepresen(),
                empresa.getNombreRepresen(),
                empresa.getDireccion(),
                empresa.getComuna(),
                empresa.getCiudad(),
                empresa.getTelefono(),
                empresa.getFax(),
                empresa.getCorreo(),
                empresa.getCodigoActividad());
    }

    private Empresas toEntity(EmpresasRequestDto request) {
        return new Empresas(
                request.getRutEmpresa(),
                request.getDigito(),
                request.getNombreEmpresa(),
                request.getCodigo(),
                request.getSigla(),
                request.getGiro(),
                request.getRutRepresen(),
                request.getDvRepresen(),
                request.getNombreRepresen(),
                request.getDireccion(),
                request.getComuna(),
                request.getCiudad(),
                request.getTelefono(),
                request.getFax(),
                request.getCorreo(),
                request.getCodigoActividad());
    }
}
