package feb.training.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import feb.training.springboot.entities.QueryTab;
import feb.training.springboot.service.QueryService;

@RestController
@RequestMapping("/query")
public class QueryController {
    @Autowired
	QueryService service;
	@GetMapping("/getall")
	public List<QueryTab> getAllQueries()
	{
		return service.getAllQueries();
	}
	
	
	
	@GetMapping("/getNativeQuery")
	public QueryTab getNativeQuery(@RequestParam Integer id)
	{
		return service.getNativeQuery(id);
	}
	
	
	@GetMapping("/getall_byjpa")
	public List<QueryTab> getAllJPAQueries()
	{
		return service.getAllJPAQueries();
	}
	
	
	@GetMapping("/getByIdJPAQueries")
	public QueryTab getByIdJPAQueries(@RequestParam Integer id)
	{
		return service.getByIdJPAQueries(id);
	}
	
	
	//JPA Repo Save 
	@PostMapping("/create")
	public QueryTab createQuery(@RequestBody QueryTab query)
	{
		return service.createQuery(query);
	}
	@GetMapping("/namedjpql")
	public List<QueryTab> getAllNamedJPAQueries()
	{
		return service.getAllNamedJPAQueries();
	}
	
	@GetMapping("/namenativequery")
	public List<QueryTab> getAllNamedNativeQueries()
	{
		return service.getAllNamedNativeQueries();
	}
	
	@PutMapping("/update")
	public void updateQuery(@RequestParam Integer id, @RequestParam String query)
	{
		 service.updateQuery(id,query);
	}
	
	
	
	@PostMapping("/insertUsingJPQL")
	public void insertUsingJPQL(@RequestParam String query, @RequestParam String fromuser)
	{
		 service.insertUsingJPQL(query,fromuser);
	}
	
	@GetMapping("/noted")
	public void carefulCase()
	{
		service.carefulCase();
		
	}
}
