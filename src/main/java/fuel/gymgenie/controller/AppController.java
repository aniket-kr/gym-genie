package fuel.gymgenie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/signup")
    public String index(Model model) {
        return "index";
    }
}
