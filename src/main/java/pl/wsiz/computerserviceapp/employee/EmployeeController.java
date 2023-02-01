package pl.wsiz.computerserviceapp.employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.client.ClientService;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /*@GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }*/
    @GetMapping("/index/employees")
    public String getAllEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }

    @PostMapping("/index/employees/addNew")
    public String addEmployee(Employee employee) {
/*        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setPermissionType(employee.getPermissionType());
        newEmployee.setPassword(employee.getPassword());
        newEmployee.setDateOfEmployment(employee.getDateOfEmployment());*/
        employeeService.addEmployee(employee);
        return "redirect:/index/employees";
    }
    @GetMapping("/index/employees/getEmployee/{id}")
    @ResponseBody
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @RequestMapping(value="/index/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateEmployee(Employee employee, Long id) {
        employeeService.updateEmployee(employee);
        return "redirect:/index/employees";
    }
    @RequestMapping(value="/index/employees/delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable(name="id") Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/index/employees";
    }
}
