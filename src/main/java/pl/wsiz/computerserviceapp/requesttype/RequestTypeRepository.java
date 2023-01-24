package pl.wsiz.computerserviceapp.requesttype;

import org.springframework.data.repository.CrudRepository;
import pl.wsiz.computerserviceapp.client.Client;

public interface RequestTypeRepository extends CrudRepository<RequestType, Long> {
}
