package bootcamp.microservices.app.clientaccounts.utils;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bootcamp.microservices.app.clientaccounts.clients.ClientAccountFeignClient;
import bootcamp.microservices.app.clientaccounts.creditcardclient.ClientAccountFeignCreditCardClient;
import bootcamp.microservices.app.clientaccounts.documents.Client;
import bootcamp.microservices.app.clientaccounts.documents.ClientCreditCard;
import bootcamp.microservices.app.clientaccounts.repository.AccountRepository;
import reactor.core.publisher.Mono;

@Component
public class Validation {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ClientAccountFeignClient clientAccountFeignClient;

	@Autowired
	private ClientAccountFeignCreditCardClient clientAccountFeignCreditCardClient;

	public Boolean createAccountValidation(String idClient) {
		Boolean createAccount = false;
		Client client = new Client();
		client = clientAccountFeignClient.searchById(idClient).block();
		Long accountQuaty = accountRepository.findByIdClient(idClient).count().block();

		if (Long.compare(accountQuaty, 0L) == 0) {
			if (client.getProfile().equals("VIP")) {
				Optional<ClientCreditCard> creditCardQuanty = clientAccountFeignCreditCardClient
						.searchByIdClient(idClient).blockOptional();
				if (!creditCardQuanty.isEmpty()) {
					createAccount = true;
				} else {
					createAccount = false;
				}
			} else {
				createAccount = false;
			}
		}
		return createAccount;
	}
}
