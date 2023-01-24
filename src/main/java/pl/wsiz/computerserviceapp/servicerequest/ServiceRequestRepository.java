package pl.wsiz.computerserviceapp.servicerequest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.companyclient.CompanyClient;

import java.util.List;
@Repository
public interface ServiceRequestRepository extends CrudRepository<ServiceRequest, Long> {
    public List<ServiceRequest> findByClientId(Long ClientID);
    @Query(value="SELECT MAX(ID) FROM [dbo].ServiceRequest", nativeQuery = true)
    public ServiceRequest findTopByid();

}
