package bootcamp.microservices.app.clientaccounts.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import bootcamp.microservices.app.clientaccounts.documents.Client;
import reactor.core.publisher.Mono;

@FeignClient(name = "microservice-clients")
public interface ClientAccountFeignClient {

	@GetMapping("/id/{id}")
	public Mono<Client> searchById(@PathVariable String id);

}
