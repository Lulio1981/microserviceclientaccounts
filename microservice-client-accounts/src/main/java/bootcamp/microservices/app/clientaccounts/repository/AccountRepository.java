package bootcamp.microservices.app.clientaccounts.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import bootcamp.microservices.app.clientaccounts.documents.Account;
import reactor.core.publisher.Flux;

public interface AccountRepository extends ReactiveMongoRepository<Account, String> {
		
	public Flux<Account> findByIdClient(String idClient);

}
