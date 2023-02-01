package pl.wsiz.computerserviceapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.wsiz.computerserviceapp.Role;
import pl.wsiz.computerserviceapp.employee.Employee;
import pl.wsiz.computerserviceapp.employee.EmployeeRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> user = new ArrayList<>();
        userRepository.findAll().forEach(user::add);
        return user;
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
    public void updateUser(User user) {
        userRepository.save(user);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
