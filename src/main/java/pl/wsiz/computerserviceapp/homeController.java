package pl.wsiz.computerserviceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.wsiz.computerserviceapp.client.ClientService;
import pl.wsiz.computerserviceapp.user.UserService;

@Controller
public class homeController {
    @Autowired
    ClientService clientService;
    @RequestMapping (value={"/login", "/", "/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String login(Model model) {
        model.addAttribute("nextclientid", clientService.getNextClientId());
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    @GetMapping("/logout-success")
    public static String logoutSuccess(Model model) {
        model.addAttribute("logoutSuccess", true);
        return "login";
    }

    @GetMapping("/403")
    public static String accessDenied() {
        return "accessDenied";
    }


}
