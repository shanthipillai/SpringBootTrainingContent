package feb.training.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import feb.training.springboot.entities.QueryTab;
import jakarta.transaction.Transactional;



@Repository
public interface QueryRepo extends JpaRepository<QueryTab, Integer>{
   //Native Query
    @Query(value = "select * from querytab",nativeQuery = true)
	public List<QueryTab> getAllQueries();
    //select * from querytab where queryid=10;
    @Query(value = "select * from querytab where queryid=:id",nativeQuery = true)
	public QueryTab getNativeQuery(@Param("id") Integer id);
    
    
    
    
    //JPA QUERY
    @Query("select q from QueryTab q")
    public List<QueryTab> getAllJPAQueries();
    
    @Query("select q from QueryTab q where q.queryid = :id")
    public QueryTab getByIdJPAQueries(@Param("id") Integer id);
    
    
    
    //Named Query
    @Query(name = "fetchall")
    public List<QueryTab> getAllNamedJPAQueries();
    
    @Query(name="QueryTab.getAllNative", nativeQuery = true)
    public List<QueryTab> getAllNamedNativeQueries();
    
    //Modifying/Update requires @Transactinal and @Modifying
    
    @Modifying(
    		
    		clearAutomatically = true
    		)
    @Transactional
    @Query("update QueryTab q set q.query=:query where q.id=:id")
    public void updateQuery(@Param("id") Integer id, @Param("query")  String query);
    
    //JPQL doesn't support insert operation if done so an exception will be thrown
    @Modifying
    @Transactional
    @Query("insert into QueryTab q (q.query, q.fromuser) values (:query, :fromuser)")
    void insertUsingJPQL(@Param("query") String query,
                         @Param("fromuser") String fromuser);
    
	
    
    
}
