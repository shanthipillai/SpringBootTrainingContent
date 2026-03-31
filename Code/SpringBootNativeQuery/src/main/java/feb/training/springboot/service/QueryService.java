package feb.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import feb.training.springboot.entities.QueryTab;
import feb.training.springboot.repo.QueryRepo;

@Service
public class QueryService {
    @Autowired
	QueryRepo repo;
	public List<QueryTab> getAllQueries() {
		// TODO Auto-generated method stub
		return repo.getAllQueries();
	}
	public QueryTab createQuery(QueryTab query) {
		// TODO Auto-generated method stub
	return	repo.save(query);
	}
	public List<QueryTab> getAllJPAQueries() {
		// TODO Auto-generated method stub
		return repo.getAllJPAQueries();
	}
	
	public List<QueryTab> getAllNamedJPAQueries() {
		// TODO Auto-generated method stub
		return repo.getAllNamedJPAQueries();
	}
	public List<QueryTab> getAllNamedNativeQueries() {
		// TODO Auto-generated method stub
		return repo.getAllNamedNativeQueries();
	}
	public void updateQuery(Integer id, String query) {
		// TODO Auto-generated method stub
		 repo.updateQuery(id, query);
	}
	public QueryTab getNativeQuery(Integer id) {
		// TODO Auto-generated method stub
		return repo.getNativeQuery(id);
	}
	public QueryTab getByIdJPAQueries(Integer id) {
		// TODO Auto-generated method stub
		return repo.getByIdJPAQueries(id);
	}
	public void insertUsingJPQL(String query, String fromuser) {
		 repo.insertUsingJPQL(query,fromuser);
		
	}
	public void carefulCase() {
		QueryTab query=repo.findById(4).get();
		
		
		repo.updateQuery(4, "This should be the output because we enabled true");  //Hit directly to DB
		
		System.out.println(query.getQuery());
		
	};

}
