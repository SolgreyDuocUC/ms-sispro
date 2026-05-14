package antuan.mcsv_backend_legacy.maestros.service;

import antuan.mcsv_backend_legacy.maestros.dto.articulosDTO.ArticulosRequestDto;
import antuan.mcsv_backend_legacy.maestros.dto.articulosDTO.ArticulosResponseDto;

import java.util.List;

public interface ArticulosService {

    List<ArticulosResponseDto> listarTodos();

    ArticulosResponseDto obtenerPorId(String empresa, String codigoArticulo);

    List<ArticulosResponseDto> listarPorEmpresa(String empresa);

    List<ArticulosResponseDto> buscarPorDescripcion(String descripcion);

    ArticulosResponseDto crear(ArticulosRequestDto request);

    ArticulosResponseDto actualizar(String empresa, String codigoArticulo, ArticulosRequestDto request);

    void eliminar(String empresa, String codigoArticulo);
}
