package antuan.mcsv_backend_legacy.clientes.repository;

import antuan.mcsv_backend_legacy.clientes.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import antuan.mcsv_backend_legacy.clientes.model.ClientesId;

import java.util.List;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, ClientesId> {

    List<Clientes> findByEmpresa(String empresa);

    List<Clientes> findByRazonSocialContaining(String razonSocial);

    List<Clientes> findByCodigoVendedor(Integer codigoVendedor);
}

