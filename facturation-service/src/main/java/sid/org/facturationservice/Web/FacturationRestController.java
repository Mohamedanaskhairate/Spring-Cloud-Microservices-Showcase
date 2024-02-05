package sid.org.facturationservice.Web;


import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sid.org.facturationservice.entities.Facture;
import sid.org.facturationservice.feign.ClientRestClient;
import sid.org.facturationservice.feign.ProduitFactureRestClient;
import sid.org.facturationservice.model.Client;
import sid.org.facturationservice.model.Produit;
import sid.org.facturationservice.repositories.FactureRepository;
import sid.org.facturationservice.repositories.ProduitFactureRepository;

@RestController
public class FacturationRestController {
    private FactureRepository factureRepository;
    private ProduitFactureRepository produitFactureRepository;
    private ClientRestClient clientRestClient ;
    private ProduitFactureRestClient produitFactureRestClient ;

    public FacturationRestController(FactureRepository factureRepository,ProduitFactureRepository produitFactureRepository,ClientRestClient clientRestClient,ProduitFactureRestClient produitFactureRestClient) {
        this.factureRepository = factureRepository;
        this.produitFactureRepository =produitFactureRepository;
        this.clientRestClient =clientRestClient;
        this.produitFactureRestClient =produitFactureRestClient;
    }

    @GetMapping(path = "fullFacture/{id}")
    public Facture getFacture(@PathVariable Long id){
     Facture facture = factureRepository.findById(id).get();
     Client client =clientRestClient.getClientById(facture.getClientID());
     facture.setClient(client);
     facture.getProduitFacture().forEach(pf->{
         Produit produit =produitFactureRestClient.getProduitById(pf.getProduitID());
         //pf.setProduit(produit);
         pf.setNomProduit(produit.getNom());
             });
     return facture;
    }
}
