package pl.wsiz.computerserviceapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wsiz.computerserviceapp.employee.Employee;
import pl.wsiz.computerserviceapp.employee.EmployeeService;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /*@GetMapping("/index/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }*/
    @GetMapping("/index/users")
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

/*    @RequestMapping(value="/index/users/addNew", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }*/

    @PostMapping("/index/users/addNew")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/index/users";
    }
    @GetMapping("/index/users/getUser/{id}")
    @ResponseBody
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value="/index/users/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateUser(User user, Long id) {
        userService.updateUser(user);
        return "redirect:/index/users";
    }
    @RequestMapping(value="/index/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable(name="id") Long id) {
        userService.deleteUser(id);
        return "redirect:/index/users";
    }
}
