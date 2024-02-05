package sid.org.facturationservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;
import sid.org.facturationservice.entities.Facture;
import sid.org.facturationservice.entities.ProduitFacture;
import sid.org.facturationservice.feign.ClientRestClient;
import sid.org.facturationservice.feign.ProduitFactureRestClient;
import sid.org.facturationservice.model.Client;
import sid.org.facturationservice.model.Produit;
import sid.org.facturationservice.repositories.FactureRepository;
import sid.org.facturationservice.repositories.ProduitFactureRepository;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class FacturationServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(FacturationServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(FactureRepository factureRepository,
							ProduitFactureRepository produitFactureRepository,
							ClientRestClient clientRestClient ,
							ProduitFactureRestClient produitFactureRestClient
							){
		return args -> {

			Client client = clientRestClient.getClientById(1L);
			Facture facture1 = factureRepository.save(new Facture(null,new Date(),null,client.getId(),null));
			PagedModel<Produit> produitPagedModel = produitFactureRestClient.pageProduits();
			produitPagedModel.forEach(p->{
				ProduitFacture produitFacture = new ProduitFacture();
				produitFacture.setPrix(p.getPrix());
				produitFacture.setQuantite(1+new Random().nextInt(100));
				produitFacture.setFacture(facture1);
				produitFacture.setProduitID(p.getId());
				produitFactureRepository.save(produitFacture);
			});
		};
	}
}
