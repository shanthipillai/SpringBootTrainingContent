package feb.training.springboot.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import feb.training.springboot.entities.Roles;
import feb.training.springboot.entities.User;
import feb.training.springboot.repo.UserRoleRepo;

@Service
public class UserRoleService {

	@Autowired
	UserRoleRepo userrepo;
	public User createUser(User user) {
		// TODO Auto-generated method stub
		ArrayList<Roles> roleslist=new ArrayList<>();
		for(Roles role:user.getRoles())
		{
			roleslist.add(role);
		}
		user.setRoles(roleslist);
		return userrepo.save(user);
	}
	public void deleteUser(Integer id) {
		userrepo.deleteById(id);
		
	}

}
