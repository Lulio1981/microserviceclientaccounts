package bootcamp.microservices.app.clientaccounts.services;

import bootcamp.microservices.app.clientaccounts.documents.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {

	public Flux<Account> findAll();

	public Mono<Account> findById(String id);

	public Mono<Account> save(Account account);

	public Mono<Account> update(Account account);

	public Mono<Void> deleteNonLogic(Account account);

	public Mono<Account> deleteLogic(Account account);

	public Mono<Long> countNumberOfAccount(String idClient);

	public Flux<Account> findByIdClient(String idClient);

}
