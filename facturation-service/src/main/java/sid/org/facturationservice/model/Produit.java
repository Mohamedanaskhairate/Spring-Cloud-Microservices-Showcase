package sid.org.facturationservice.model;

import lombok.Data;

@Data
public class Produit {
    private Long id ;
    private String nom ;
    private double prix ;
    private double quantité ;
}
