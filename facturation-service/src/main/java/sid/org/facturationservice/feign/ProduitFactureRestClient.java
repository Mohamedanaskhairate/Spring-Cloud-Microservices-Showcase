package sid.org.facturationservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import sid.org.facturationservice.model.Produit;
import javax.ws.rs.QueryParam;

@FeignClient(name = "PRODUIT-SERVICE")
public interface ProduitFactureRestClient {
    @GetMapping(path = "/produits")
    PagedModel<Produit> pageProduits();
    @GetMapping(path = "/produits/{id}")
    Produit getProduitById (@PathVariable Long id);

}
