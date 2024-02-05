package sid.org.facturationservice.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sid.org.facturationservice.model.Produit;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class ProduitFacture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;
    private double quantite ;
    private double prix ;
    private  long produitID;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private  Facture facture ;
    @Transient
    private Produit produit ;
    @Transient
    private String NomProduit;
}
