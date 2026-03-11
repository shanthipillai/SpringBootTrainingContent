package jdbc.connecitons.utils.operations;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



import jdbc.connecitons.utils.DBConnection;

public class JDBCOperations {
	static Connection con;
	static Statement statement;
	static
	{
		try {
			 con = DBConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			 statement = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void createTable() throws ClassNotFoundException, SQLException {
		String sql = "create table user(username varchar(50),password varchar(50),role varchar(50) )";
		
		//Statement statement = con.createStatement();
		statement.executeUpdate(sql);
		/*
		 * con.commit(); con.rollback();
		 */
	}
	
	public static void insertRecord() throws ClassNotFoundException, SQLException
	{
		String sql="insert into user values ('Madhuri','admin','DEV')";
		//String sql1="insert into user (username,password) values ('madhuri','DEV')";
		//Connection con = DBConnection.getConnection();
		//Statement statement = con.createStatement();
		statement.executeUpdate(sql);
		
	}
	
	public static void updateRecord() throws SQLException
	{
		String sql="update user set role='Admin' where username='Shanthi'";
		//Statement statement = con.createStatement();
		statement.executeUpdate(sql);
	} 
	
	public static void batchInserts() throws SQLException
	{
		statement.addBatch("insert into user values ('Madhuri','admin','DEV')");
		statement.addBatch("insert into user values ('Ravi','admin','QA')");
		statement.addBatch("insert into user values ('James','admin','Architect')");
		statement.executeBatch();
	}
	public static void deleteRecord() throws SQLException
	{
		String sql="delete from user where username='Ravi'";
		statement.executeUpdate(sql);
	}
	
	public static void selectAllUsers() throws SQLException
	{
		String sql="select * from user";
		java.sql.ResultSet rs=statement.executeQuery(sql);
		while(rs.next())
		{
			System.out.println("Username="+rs.getString("username"));
			System.out.println("Password="+rs.getString("password"));
			System.out.println("Role="+rs.getString("role"));
			System.out.println("________________________________________");
		}
		
	}
	
	public static void authenticate() throws SQLException
	{
		//SQL Injection
		String sql="select * from user where username='Shanthi' and password='wrong' OR '1'='1'";
		java.sql.ResultSet resultset=statement.executeQuery(sql);
		if(resultset.next())
		{
			System.out.println("Authentication success");
		}
		else
		{
			System.out.println("Invalid username or password");
		}
		
	}
	
	public static void dropTable() throws SQLException
	{
		String sql="drop table user";
		statement.executeUpdate(sql);
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//createTable();
		//insertRecord();
		//updateRecord();
		//batchInserts();
		//deleteRecord();
		selectAllUsers();
		authenticate();
	}

}
