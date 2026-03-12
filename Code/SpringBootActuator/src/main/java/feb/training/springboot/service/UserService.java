package feb.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import feb.training.springboot.entity.User;
import feb.training.springboot.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserService {
    @Autowired
	UserRepo userrepo;
	public List<User> createEmp(List<User> userslist) {
		log.info("In Service Class");
		userslist.forEach(user->log.debug("",user));
		return userrepo.saveAll(userslist);
	   
	}
	public List<User> getEmpDetails() {
		
		return userrepo.findAll();
	}

	

}
