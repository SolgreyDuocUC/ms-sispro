package antuan.mcsv_backend_legacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class McsvBackendLegacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvBackendLegacyApplication.class, args);
	}

}
