package pl.wsiz.computerserviceapp.address;

import org.springframework.data.repository.CrudRepository;
import pl.wsiz.computerserviceapp.client.Client;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
