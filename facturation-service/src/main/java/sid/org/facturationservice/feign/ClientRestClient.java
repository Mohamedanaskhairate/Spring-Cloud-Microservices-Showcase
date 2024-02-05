package sid.org.facturationservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sid.org.facturationservice.model.Client;

@FeignClient(name = "CLIENT-SERVICE")
public interface ClientRestClient {
    @GetMapping(path = "/clients/{id}")
    public Client getClientById (@PathVariable(name = "id") Long id);
}
