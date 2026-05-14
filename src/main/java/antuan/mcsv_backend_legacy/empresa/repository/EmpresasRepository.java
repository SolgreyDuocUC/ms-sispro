package antuan.mcsv_backend_legacy.empresa.repository;

import antuan.mcsv_backend_legacy.empresa.model.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Integer> {
}
