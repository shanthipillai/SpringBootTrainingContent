package feb.training.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import feb.training.springboot.entities.User;
import feb.training.springboot.service.UserRoleService;

@RestController
@RequestMapping("/infiservices")
public class UserRoleController {

	@Autowired
	UserRoleService service;
	@PostMapping("/create_userrole")
	public User createUser(@RequestBody User user)
	{
		return service.createUser(user);
	}
	
	@DeleteMapping("/delete_userrole")
	public void deleteUser(@RequestParam Integer id)
	{
		service.deleteUser(id);
	}
	
}
