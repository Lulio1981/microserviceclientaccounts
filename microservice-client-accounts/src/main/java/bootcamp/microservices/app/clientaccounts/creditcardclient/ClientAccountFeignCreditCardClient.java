package bootcamp.microservices.app.clientaccounts.creditcardclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import bootcamp.microservices.app.clientaccounts.documents.ClientCreditCard;
import reactor.core.publisher.Mono;

@FeignClient(name = "microservice-clients")
public interface ClientAccountFeignCreditCardClient {

	@GetMapping("/idClient/{idClient}")
	public Mono<ClientCreditCard> searchByIdClient(@PathVariable String idClient);
}
