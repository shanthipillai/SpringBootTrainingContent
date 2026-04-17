package feb.training.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import feb.training.springboot.entities.RegisterUser;
import feb.training.springboot.entities.User;

@Controller
public class RegisterController {

	
	  @GetMapping("/register") public 
	  String showRegister(Model model) {
	  
	  model.addAttribute("registerUser", new RegisterUser()); 
	  
	  return  "redirect:/welcome"; 
	  }
	  
	  @GetMapping("/welcome") public String showWelcome() { 
		  return "welcome"; //
	  }
	  
	  
	  //welcome.html 
	  
	 

	/*
	 * @GetMapping("/register") public String showRegister(Model model) {
	 * 
	 * model.addAttribute("registerUser", new RegisterUser()); return "register"; }
	 * 
	 * 
	 * 
	 * 
	 * @PostMapping("/register") public String
	 * processRegister(@ModelAttribute("registerUser") RegisterUser registerUser,
	 * Model model) {
	 * 
	 * // send data to next page model.addAttribute("registerUser", registerUser);
	 * 
	 * return "result"; }
	 * 
	 * 
	 * 
	 * 
	 * @PostMapping("/register") public ModelAndView processRegister(@ModelAttribute
	 * RegisterUser user) {
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * 
	 * mv.addObject("user", user); // model data mv.setViewName("result"); // view
	 * 
	 * 
	 * return mv; }
	 * 
	 * 
	 * 
	 * 
	 * @GetMapping("/users") public String getUsers(Model model) {
	 * 
	 * List<RegisterUser> users = new ArrayList<>();
	 * 
	 * users.add(new RegisterUser("Shanthi", "shanthi@gmail.com", "123"));
	 * users.add(new RegisterUser("Ravi", "ravi@gmail.com", "123")); users.add(new
	 * RegisterUser("Anu", "anu@gmail.com", "123"));
	 * 
	 * model.addAttribute("users", users);
	 * 
	 * return "users"; }
	 */
}
