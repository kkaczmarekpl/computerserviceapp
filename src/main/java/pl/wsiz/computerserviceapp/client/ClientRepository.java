package pl.wsiz.computerserviceapp.client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public List<Client> findByCompanyClientId(Long CompanyClientID);

}
