package pl.wsiz.computerserviceapp.hardware;

import org.springframework.data.repository.CrudRepository;
import pl.wsiz.computerserviceapp.companyclient.CompanyClient;

public interface HardwareRepository extends CrudRepository<Hardware, Long> {
}
