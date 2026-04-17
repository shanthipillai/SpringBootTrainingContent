package feb.training.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import feb.training.springboot.entities.User;


@Controller
public class LoginController {

    // Show login page
    @GetMapping("/login")
    public String showLoginPage(Model model) {

        // Empty object → form binding
        model.addAttribute("user", new User());

        return "login";
    }

    // Handle form submit
    @PostMapping("/login")
    public String processLogin(@ModelAttribute("user") User user, Model model) {

        if ("admin".equals(user.getUsername()) && "1234".equals(user.getPassword())) {
        	
        	
            model.addAttribute("message", "Welcome " + user.getUsername());
            model.addAttribute("list",List.of("Madhuri", "Ramya","Karthik"));
            return "success";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
}