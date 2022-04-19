package bootcamp.microservices.app.clientaccounts.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.microservices.app.clientaccounts.documents.Account;
import bootcamp.microservices.app.clientaccounts.services.AccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AccountController {

	@Autowired
	private AccountService service;

	@PostMapping
	public Mono<Account> createAccount(@Valid @RequestBody Account Account) {
		return service.save(Account);
	}

	@GetMapping("/all")
	public Flux<Account> searchAll() {
		return service.findAll();
	}

	@GetMapping("/id/{id}")
	public Mono<Account> searchById(@PathVariable String id) {
		return service.findById(id);
	}

	@GetMapping("/idClient/{idClient}")
	public Flux<Account> searchByIdClient(@PathVariable String idClient) {
		return service.findByIdClient(idClient);
	}

	@PutMapping
	public Mono<Account> updateAccount(@RequestBody Account account) {
		return service.update(account);
	}

	@DeleteMapping
	public Mono<Account> deleteAccount(@Valid @RequestBody Account account) {
		return service.deleteLogic(account);
	}

}
