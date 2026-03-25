package jdbc.java.learn.util.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.java.learn.util.DBConnection;

public class PreparedStatemntConenctions {

	public static String createUserTable() throws ClassNotFoundException, SQLException {
		String sql = "create table usertab1(username varchar(50),password varchar(50), role varchar(50))";
		Connection con = DBConnection.getConnection();
		PreparedStatement preparetatemnt = con.prepareStatement(sql);
		preparetatemnt.execute();

		return "Created";
	}

	public static void insert() throws ClassNotFoundException, SQLException {

		// String sql="insert into jdbctab values(1,'Shanthi','DEV') ";
		String sql2 = "insert into usertab1 values(?,?,?) ";
		Connection con = DBConnection.getConnection();
		PreparedStatement preparetatemnt = con.prepareStatement(sql2);
        preparetatemnt.setString(1, "shanthi");
        preparetatemnt.setString(2, "DEV");
        preparetatemnt.setString(3, "Admin");
        preparetatemnt.execute();
        preparetatemnt.setString(1, "Madhuri");
        preparetatemnt.setString(2, "DEV");
        preparetatemnt.setString(3, "Admin");
        preparetatemnt.execute();
		
	}
	
	public static void authenticateUser() throws SQLException, ClassNotFoundException
	{
	     String name="Shanthi";
	     String pwd="wrong 'OR '1'='1";
		String sql="select * from usertab where username=? and password=?";
		Connection con = DBConnection.getConnection();
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, name);
		statement.setString(2, pwd);
		

		ResultSet result=statement.executeQuery();
		if(result.next())
		{
			System.out.println("Authentication success");
		}
		else
		{
			System.out.println("User Id or Password is invalid");
		}
		
	}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//createUserTable();
		//insert();
		authenticateUser();
	}
}
