package pl.wsiz.computerserviceapp.companyclient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyClientRepository extends CrudRepository<CompanyClient, Long> {
}
