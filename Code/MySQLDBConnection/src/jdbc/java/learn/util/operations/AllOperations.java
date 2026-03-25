package jdbc.java.learn.util.operations;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.java.learn.util.DBConnection;

public class AllOperations {
	
	
	public static String createUserTable() throws ClassNotFoundException, SQLException
	{
		String str = "create table usertab(username varchar(50),password varchar(50), role varchar(50))";
		Connection con = DBConnection.getConnection();
		Statement statement = con.createStatement();

		statement.executeUpdate(str);
		return "Created";
	}
	
	public static void authenticateUser() throws SQLException, ClassNotFoundException
	{
	
		String sql="select * from usertab where username='shanthi' and password='wrong' OR '1'='1'";
		Connection con = DBConnection.getConnection();
		Statement statement = con.createStatement();

		Boolean result=statement.execute(sql);
		if(result)
		{
			System.out.println("Authentication success");
		}
		else
		{
			System.out.println("User Id or Password is invalid");
		}
		
	}
	
	
	

	public static String createTable() throws ClassNotFoundException, SQLException {
		String str = "create table jdbctab(id int, name varchar(50),department varchar(50))";
		Connection con = DBConnection.getConnection();
		Statement statement = con.createStatement();

		statement.executeUpdate(str);
		return "Created";

	}

	public static Boolean insert() throws ClassNotFoundException, SQLException {

		// String sql="insert into jdbctab values(1,'Shanthi','DEV') ";
		String sql2 = "insert into jdbctab(id, department) values(5,'QA') ";
		Connection con = DBConnection.getConnection();
		Statement statement = con.createStatement();
		boolean result = statement.execute(sql2);
		
		return result;
	}

	public static boolean update() throws ClassNotFoundException, SQLException {
		String sql2 = "update jdbctab set id=11 where id=1 ";
		Connection con = DBConnection.getConnection();
		Statement statement = con.createStatement();
		boolean result = statement.execute(sql2);
		return result;
	}

	public static boolean delete() throws ClassNotFoundException, SQLException {

		String sql2 = "delete from jdbctab where name='2' ";
		Connection con = DBConnection.getConnection();
		Statement statement = con.createStatement();
		boolean result = statement.execute(sql2);
		return result;
	}

	public static void getDetails() throws SQLException, ClassNotFoundException {

		String sql2 = "select * from jdbctab";
		Connection con = DBConnection.getConnection();
		Statement statement = con.createStatement(
				
				        ResultSet.TYPE_SCROLL_INSENSITIVE,
				        ResultSet.CONCUR_READ_ONLY
			
				);
		ResultSet resultset = statement.executeQuery(sql2);
	
		resultset.afterLast();
		while (resultset.previous()) {
			System.out.println(resultset.getInt("id"));
			System.out.println(resultset.getString("name"));
			System.out.println(resultset.getString("department"));
		}

	}

	
	public static void addBatch() throws ClassNotFoundException, SQLException
	{
		Connection con = DBConnection.getConnection();
		Statement statement = con.createStatement();

		statement.addBatch("insert into jdbctab values(1,'Shanthi','DEV')");
		statement.addBatch("insert into jdbctab values(2,'Ravi','QA')");
		statement.addBatch("insert into jdbctab values(3,'Kumar','HR')");
		statement.addBatch("insert into jdbctab values(4,'Anu','DEV')");
		try
		{
		int arr[]=statement.executeBatch();
		}
		catch(BatchUpdateException ex)
		{
			System.out.println(ex);
		}

	}
	
	public static void dropTab() throws ClassNotFoundException, SQLException
	{

		Connection con = DBConnection.getConnection();
		Statement statement = con.createStatement();
		String sql="drop table jdbctab";
		statement.executeUpdate(sql);
		
	}
	
	public static void transactionmanagment() throws ClassNotFoundException, SQLException
	{

		Connection con = DBConnection.getConnection();
		
		//con.commit();
		con.rollback();
		con.commit();
		 
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// createTable();
		// insert();
		// update();
		// delete();
		//getDetails();
		//createUserTable();
		//authenticateUser();
		//insert()
		//addBatch();
		//getDetails();
		//dropTab();
		//createTable();
		insert();
		
		transactionmanagment();
		
	}
}
