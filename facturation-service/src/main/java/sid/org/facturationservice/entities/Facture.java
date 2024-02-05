package sid.org.facturationservice.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sid.org.facturationservice.model.Client;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Facture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;
    private Date factureDate ;
    @OneToMany(mappedBy = "facture")
    private Collection<ProduitFacture> produitFacture ;
    private Long clientID ;
    @Transient
     private Client client ;

}
