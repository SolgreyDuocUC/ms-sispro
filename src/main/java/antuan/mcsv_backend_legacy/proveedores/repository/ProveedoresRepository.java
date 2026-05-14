package antuan.mcsv_backend_legacy.proveedores.repository;

import antuan.mcsv_backend_legacy.proveedores.model.proveedores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import antuan.mcsv_backend_legacy.proveedores.model.ProveedoresId;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedoresRepository extends JpaRepository<proveedores, ProveedoresId> {

    List<proveedores> findByEmpresa(String empresa);

    Optional<proveedores> findByEmpresaAndRutProveedor(String empresa, Integer rutProveedor);

    List<proveedores> findByEmpresaAndRazonSocialContaining(String empresa, String razonSocial);

    List<proveedores> findByEmpresaAndCodigoVendedor(String empresa, Integer codigoVendedor);

    List<proveedores> findByRutProveedor(Integer rutProveedor);

    List<proveedores> findByRazonSocial(String razonSocial);

    List<proveedores> findByCodigoVendedor(Integer codigoVendedor);
}