package antuan.mcsv_backend_legacy.empresa.service;

import antuan.mcsv_backend_legacy.empresa.dto.EmpresasRequestDto;
import antuan.mcsv_backend_legacy.empresa.dto.EmpresasResponseDto;

import java.util.List;

public interface EmpresasService {

    List<EmpresasResponseDto> listarTodas();

    EmpresasResponseDto obtenerPorId(Integer rutEmpresa);

    EmpresasResponseDto crear(EmpresasRequestDto request);

    EmpresasResponseDto actualizar(Integer rutEmpresa, EmpresasRequestDto request);

    void eliminar(Integer rutEmpresa);
}
