package antuan.mcsv_backend_legacy.shared.integration.traductor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "traductorClient", url = "${integration.traductor.url}")
public interface TraductorClient {

    @GetMapping("/api/v1/integracion/estado")
    String verificarEstado();
}
