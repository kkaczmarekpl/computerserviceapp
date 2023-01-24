package pl.wsiz.computerserviceapp.employee;

import org.springframework.data.repository.CrudRepository;
import pl.wsiz.computerserviceapp.requesttype.RequestType;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
