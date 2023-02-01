package pl.wsiz.computerserviceapp.client;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wsiz.computerserviceapp.servicerequest.ServiceRequest;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    public List<Client> findByCompanyClientId(Long CompanyClientID);
    @Query(value="SELECT MAX(ID) FROM [dbo].Client", nativeQuery = true)
    public Long findBiggestId();

}
