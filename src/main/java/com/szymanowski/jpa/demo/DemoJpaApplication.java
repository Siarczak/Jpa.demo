package com.szymanowski.jpa.demo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DemoJpaApplication {


	private static final Logger log = LoggerFactory.getLogger(DemoJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (CustomerRepository repository)
	{
		return (args) ->
		{

			repository.save(new Customer("Jan", "Kowalksi"));
			repository.save(new Customer("Robert", "Makłowicz"));
			repository.save(new Customer("Antoni", "Macierewicz"));
			repository.save(new Customer("Jarosław", "Jakimowicz"));
			repository.save(new Customer("Jan", "Kowalksi"));


			log.info("Customers find with findAll():");
			log.info("----------------------------------");
			for (Customer customer : repository.findAll())
			{

				log.info(customer.toString());
			}

			log.info("");

			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");


			log.info("Customer found with findByLastName('Jakimowcz'):");
			log.info("--------------------------------");
			for (Customer customer1 : repository.findByLastName("Jakimowicz"))
			{
				log.info(customer1.toString());

			}

			log.info("");
		};


	}

}
