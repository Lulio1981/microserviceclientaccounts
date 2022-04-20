package bootcamp.microservices.app.clientaccounts.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bootcamp.microservices.app.clientaccounts.clients.ClientAccountFeignClient;
import bootcamp.microservices.app.clientaccounts.documents.Client;
import bootcamp.microservices.app.clientaccounts.repository.AccountRepository;
import reactor.core.publisher.Mono;

@Component
public class Validation {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ClientAccountFeignClient clientAccountFeignClient;

	public Boolean createAccountValidation(String idClient) {
		Boolean createAccount = false;
		Client client = new Client();
		client = clientAccountFeignClient.searchById(idClient).block();

		if (client.getProfile().equals("VIP")) {

			createAccount = true;
		} else {
			Long accountQuaty = accountRepository.findByIdClient(idClient).count().block();
			if (Long.compare(accountQuaty, 0L) == 0) {
				createAccount = true;
			}
		}

		return createAccount;
	}
}
