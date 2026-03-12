package feb.training.springboot.controller;

import java.io.Serial;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feb.training.springboot.entity.User;
import feb.training.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
	UserService service;
    @PostMapping("/createlist")
	public List<User> createEmp(@RequestBody List<User> userslist)
	{
    	log.info("In User Controller Controller Class");
    	if(userslist==null)
    		log.warn("User Entered invaid list");
		return service.createEmp(userslist);
		
	}
	
	@GetMapping("/getall")
	public List<User> getEmpDetails()
	{
		return service.getEmpDetails();
	}
}
