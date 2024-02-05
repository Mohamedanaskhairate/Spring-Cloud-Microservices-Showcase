package sid.org.facturationservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sid.org.facturationservice.entities.ProduitFacture;

import java.util.Collection;


@RepositoryRestResource
public interface ProduitFactureRepository extends JpaRepository<ProduitFacture,Long> {
public Collection<ProduitFacture> findByFactureId(Long id);

}
