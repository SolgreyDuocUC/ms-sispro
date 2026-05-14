package antuan.mcsv_backend_legacy.maestros.repository;

import antuan.mcsv_backend_legacy.maestros.model.articulos.Articulos;
import antuan.mcsv_backend_legacy.maestros.model.articulos.ArticulosId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticulosRepository extends JpaRepository<Articulos, ArticulosId> {

    List<Articulos> findByIdEmpresa(String empresa);
    List<Articulos> findByDescripcionContainingIgnoreCase(String descripcion);

}
