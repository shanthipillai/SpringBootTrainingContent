package jdbc.java.learn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection;
	private static String url = "jdbc:mysql://localhost:3306/eazybank";
	private static String username = "root";
	private static String password = "admin123";

	private DBConnection()
	{
		
	}
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Object created");
			connection.setAutoCommit(false);

		}
		//connection.setAutoCommit(false);
		return connection;
	}
}
