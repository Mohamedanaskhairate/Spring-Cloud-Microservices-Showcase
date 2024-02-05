package org.sid.clientservice;

import org.sid.clientservice.entities.Client;
import org.sid.clientservice.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ClientServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ClientServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start (ClientRepository clientRepository, RepositoryRestConfiguration restConfiguration ){
		restConfiguration.exposeIdsFor(Client.class);
		return args -> {
			clientRepository.save(new Client(null,"Mohamed Anas","mohamedanas.khairate@gmail.com"));
			clientRepository.save(new Client(null,"Mustapha","Mustapha.pr@gmail.com"));
			clientRepository.save(new Client(null,"Kawtar","Kawtar.Doc@gmail.com"));
			clientRepository.save(new Client(null,"Mouad","Mouad.Fn@gmail.com"));
			clientRepository.save(new Client(null,"Saadia","Saadia.Mor@gmail.com"));
			clientRepository.findAll().forEach(c->{
				System.out.println(c.toString());
			} );
		};
	}
}

