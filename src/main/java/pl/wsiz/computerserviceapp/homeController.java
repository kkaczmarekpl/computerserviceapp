package pl.wsiz.computerserviceapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
    @GetMapping({"/home", "/index", "/"})
    public static String welcome() {
        return "index";
    }

}
