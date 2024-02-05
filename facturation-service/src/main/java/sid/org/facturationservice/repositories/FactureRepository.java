package sid.org.facturationservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sid.org.facturationservice.entities.Facture;

@RepositoryRestResource
public interface FactureRepository extends JpaRepository<Facture,Long> {
}
