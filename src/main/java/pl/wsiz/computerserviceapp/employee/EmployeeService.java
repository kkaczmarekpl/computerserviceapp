package pl.wsiz.computerserviceapp.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.wsiz.computerserviceapp.Role;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.client.ClientRepository;
import pl.wsiz.computerserviceapp.user.User;
import pl.wsiz.computerserviceapp.user.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private UserService userService;

    public List<Employee> getAllEmployees() {
        List<Employee> employee = new ArrayList<>();
        employeeRepository.findAll().forEach(employee::add);
        return employee;
    }
    public void addEmployee(Employee employee) {
        User user = new User();
        user.setRole(Role.ADMIN);
        user.setUsername(((employee.getFirstName()+employee.getLastName()).trim()).toLowerCase());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(employee.getPassword());
        user.setPassword(encodedPassword);

        userService.addUser(user);
        employee.setUser(user);
        employeeRepository.save(employee);
    }
    public Optional<Employee> getEmployee(Long id) {
        return employeeRepository.findById(id);
    }
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
