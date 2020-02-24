package com.acteda.dev;

import com.acteda.dev.Repository.CustomerRepository;
import com.acteda.dev.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GameApiApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(GameApiApplication.class, args);

	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		// create test customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		System.out.println("Customers found with findAll():");

		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}

		System.out.println(repository.findByFirstName("Alice"));
		System.out.println(repository.findByLastName("Smith"));
	}
}
