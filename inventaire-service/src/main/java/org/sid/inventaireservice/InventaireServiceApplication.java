package org.sid.inventaireservice;

import org.sid.inventaireservice.entities.Produit;
import org.sid.inventaireservice.repositories.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventaireServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(InventaireServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ProduitRepository produitRepository,RepositoryRestConfiguration restConfiguration){
		restConfiguration.exposeIdsFor(Produit.class);
		return args -> {
           produitRepository.save(new Produit(null,"Ordinateur ",9500,25));
		   produitRepository.save(new Produit(null,"Téléphone ",2400,70));
		   produitRepository.save(new Produit(null,"Ecouteur  ",150,1000));
		   produitRepository.save(new Produit(null,"Télévision ",3400,60));
		   produitRepository.findAll().forEach(p ->{
			   System.out.println(p.toString());
		   } );
		};
	}
}
