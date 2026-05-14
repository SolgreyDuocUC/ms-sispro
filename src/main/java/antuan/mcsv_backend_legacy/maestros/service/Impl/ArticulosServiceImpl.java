package antuan.mcsv_backend_legacy.maestros.service.Impl;

import antuan.mcsv_backend_legacy.maestros.dto.articulosDTO.ArticulosRequestDto;
import antuan.mcsv_backend_legacy.maestros.dto.articulosDTO.ArticulosResponseDto;
import antuan.mcsv_backend_legacy.maestros.model.articulos.Articulos;
import antuan.mcsv_backend_legacy.maestros.model.articulos.ArticulosId;
import antuan.mcsv_backend_legacy.maestros.repository.ArticulosRepository;
import antuan.mcsv_backend_legacy.maestros.service.ArticulosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ArticulosServiceImpl implements ArticulosService {

    private final ArticulosRepository articulosRepository;

    @Override
    public List<ArticulosResponseDto> listarTodos() {
        return articulosRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public ArticulosResponseDto obtenerPorId(String empresa, String codigoArticulo) {
        ArticulosId id = new ArticulosId(empresa, codigoArticulo);

        Articulos articulo = articulosRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Artículo no encontrado con empresa: " + empresa + " y código: " + codigoArticulo
                ));

        return toResponseDto(articulo);
    }

    @Override
    public List<ArticulosResponseDto> listarPorEmpresa(String empresa) {
        return articulosRepository.findByIdEmpresa(empresa)
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public List<ArticulosResponseDto> buscarPorDescripcion(String descripcion) {
        return articulosRepository.findByDescripcionContainingIgnoreCase(descripcion)
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    @Override
    public ArticulosResponseDto crear(ArticulosRequestDto request) {
        ArticulosId id = new ArticulosId(request.getEmpresa(), request.getCodigoArticulo());

        if (articulosRepository.existsById(id)) {
            throw new IllegalStateException(
                    "Ya existe un artículo con empresa: " + request.getEmpresa() +
                            " y código: " + request.getCodigoArticulo()
            );
        }

        Articulos articulo = toEntity(request);
        Articulos guardado = articulosRepository.save(articulo);

        return toResponseDto(guardado);
    }

    @Override
    public ArticulosResponseDto actualizar(String empresa, String codigoArticulo, ArticulosRequestDto request) {
        ArticulosId id = new ArticulosId(empresa, codigoArticulo);

        Articulos articulo = articulosRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Artículo no encontrado con empresa: " + empresa + " y código: " + codigoArticulo
                ));

        // No permitir cambiar PK
        if (!empresa.equals(request.getEmpresa()) || !codigoArticulo.equals(request.getCodigoArticulo())) {
            throw new IllegalStateException(
                    "No se permite modificar la clave primaria del artículo (empresa/código)"
            );
        }

        articulo.setDescripcion(request.getDescripcion());
        articulo.setComentario(request.getComentario());
        articulo.setMonedaCompra(request.getMonedaCompra());
        articulo.setMonedaVenta(request.getMonedaVenta());
        articulo.setUnidadMedida(request.getUnidadMedida());
        articulo.setPrecioVenta(request.getPrecioVenta());
        articulo.setUbicacion(request.getUbicacion());
        articulo.setCosto(request.getCosto());
        articulo.setCostoUltCompra(request.getCostoUltCompra());
        articulo.setFechaUltCompra(request.getFechaUltCompra());
        articulo.setStockMinimo(request.getStockMinimo());
        articulo.setStockMaximo(request.getStockMaximo());
        articulo.setMedidaAlternativa(request.getMedidaAlternativa());
        articulo.setFactor(request.getFactor());
        articulo.setProcedencia(request.getProcedencia());
        articulo.setLotes(request.getLotes());
        articulo.setSeriales(request.getSeriales());
        articulo.setCompras(request.getCompras());
        articulo.setComision(request.getComision());
        articulo.setControlaStock(request.getControlaStock());
        articulo.setPlantilla(request.getPlantilla());
        articulo.setCodigoBarra(request.getCodigoBarra());
        articulo.setActivo(request.getActivo());

        Articulos actualizado = articulosRepository.save(articulo);
        return toResponseDto(actualizado);
    }

    @Override
    public void eliminar(String empresa, String codigoArticulo) {
        ArticulosId id = new ArticulosId(empresa, codigoArticulo);

        Articulos articulo = articulosRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Artículo no encontrado con empresa: " + empresa + " y código: " + codigoArticulo
                ));

        articulosRepository.delete(articulo);
    }

    private ArticulosResponseDto toResponseDto(Articulos articulo) {
        return new ArticulosResponseDto(
                articulo.getId().getEmpresa(),
                articulo.getId().getCodigoArticulo(),
                articulo.getDescripcion(),
                articulo.getComentario(),
                articulo.getMonedaCompra(),
                articulo.getMonedaVenta(),
                articulo.getUnidadMedida(),
                articulo.getPrecioVenta(),
                articulo.getUbicacion(),
                articulo.getCosto(),
                articulo.getCostoUltCompra(),
                articulo.getFechaUltCompra(),
                articulo.getStockMinimo(),
                articulo.getStockMaximo(),
                articulo.getMedidaAlternativa(),
                articulo.getFactor(),
                articulo.getProcedencia(),
                articulo.getLotes(),
                articulo.getSeriales(),
                articulo.getCompras(),
                articulo.getComision(),
                articulo.getControlaStock(),
                articulo.getPlantilla(),
                articulo.getCodigoBarra(),
                articulo.getActivo()
        );
    }

    private Articulos toEntity(ArticulosRequestDto request) {
        Articulos articulo = new Articulos();

        articulo.setId(new ArticulosId(
                request.getEmpresa(),
                request.getCodigoArticulo()
        ));

        articulo.setDescripcion(request.getDescripcion());
        articulo.setComentario(request.getComentario());
        articulo.setMonedaCompra(request.getMonedaCompra());
        articulo.setMonedaVenta(request.getMonedaVenta());
        articulo.setUnidadMedida(request.getUnidadMedida());
        articulo.setPrecioVenta(request.getPrecioVenta());
        articulo.setUbicacion(request.getUbicacion());
        articulo.setCosto(request.getCosto());
        articulo.setCostoUltCompra(request.getCostoUltCompra());
        articulo.setFechaUltCompra(request.getFechaUltCompra());
        articulo.setStockMinimo(request.getStockMinimo());
        articulo.setStockMaximo(request.getStockMaximo());
        articulo.setMedidaAlternativa(request.getMedidaAlternativa());
        articulo.setFactor(request.getFactor());
        articulo.setProcedencia(request.getProcedencia());
        articulo.setLotes(request.getLotes());
        articulo.setSeriales(request.getSeriales());
        articulo.setCompras(request.getCompras());
        articulo.setComision(request.getComision());
        articulo.setControlaStock(request.getControlaStock());
        articulo.setPlantilla(request.getPlantilla());
        articulo.setCodigoBarra(request.getCodigoBarra());
        articulo.setActivo(request.getActivo());

        return articulo;
    }
}
