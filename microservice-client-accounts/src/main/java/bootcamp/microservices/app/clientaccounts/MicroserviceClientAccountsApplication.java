package bootcamp.microservices.app.clientaccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MicroserviceClientAccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClientAccountsApplication.class, args);
	}

}
