package jdbc.java.learn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JDBCConnection {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	//Register Driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	//Get Connection object
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eazybank","root","admin123");
	
	//Create Query
	String sql="insert into emptest(name,dept) values (?,?)";
	//Preparing Statement
	PreparedStatement statement=con.prepareStatement(sql);

	statement.setString(1, "Shanthi"); 
	statement.setString(2, "DEV");
	int rows=statement.executeUpdate();
	System.out.println(rows);
	
	PreparedStatement statement1=con.prepareStatement("select * from emptest");
	ResultSet result=statement1.executeQuery();
	
	while(result.next())
	{
		System.out.println("Emp Id="+result.getInt("id"));
		System.out.println("Emp Name="+result.getString("name"));
		System.out.println("Emp Dept="+result.getString("dept"));
		System.out.println("______________________________________");
	}
	//Closing Connection
	con.setAutoCommit(false);
	con.close();
	
	
	
	
}
}
