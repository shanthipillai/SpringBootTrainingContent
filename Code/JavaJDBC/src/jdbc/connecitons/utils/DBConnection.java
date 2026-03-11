package jdbc.connecitons.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Singleton


/*
 * ============================= JDBC DRAWBACKS =============================
 *
 * In traditional JDBC, every database operation usually does:
 *
 *      Connection con = DriverManager.getConnection(...);
 *
 * Problems with this approach:
 *
 * 1️⃣ Connection Creation is Expensive
 * ----------------------------------------------------
 * Creating a database connection is a heavy operation.
 * Steps involved:
 *      - Network handshake with DB
 *      - Authentication
 *      - Session creation
 *      - Resource allocation in database server
 *
 * If 1000 users access the application:
 *
 *      1000 × Connection creation
 *
 * This makes the application slow.
 *
 *
 * 2️⃣ Too Many Connections Can Crash Database
 * ----------------------------------------------------
 * Databases have connection limits.
 *
 * Example:
 *      MySQL default connection limit = 151
 *
 * If application keeps creating connections:
 *
 *      ERROR: Too many connections
 *
 *
 * 3️⃣ If Developer Forgets to Close Connection
 * ----------------------------------------------------
 * Memory leak occurs.
 *
 * Example:
 *
 *      Connection con = DriverManager.getConnection(...);
 *      // developer forgets con.close()
 *
 * Connections remain open and DB resources are exhausted.
 *
 *
 * ========================== SINGLETON CONNECTION PROBLEM ==========================
 *
 * Some developers try to solve this by creating ONE connection:
 *
 *      public class DBConnection {
 *          static Connection con;
 *      }
 *
 * Problems with Singleton Connection:
 *
 * 1️⃣ If Connection Closes → Application Breaks
 *
 *      If database closes the connection due to timeout or network issue:
 *
 *          java.sql.SQLException: Connection is closed
 *
 *      Entire application stops working.
 *
 *
 * 2️⃣ Not Suitable for Multi-Threaded Applications
 *
 * Example:
 *      Thread-1 → inserting data
 *      Thread-2 → updating data
 *
 * Both share the SAME connection → data corruption / transaction conflicts.
 *
 *
 * 3️⃣ No Connection Scalability
 *
 * Only ONE connection for all users.
 *
 * Example:
 *      100 users → waiting for same connection
 *
 *
 * ========================== SOLUTION ==========================
 *
 * Use Connection Pooling (HikariCP, C3P0, DBCP).
 *
 * Connection Pool maintains reusable connections:
 *
 *      Application → gets connection from pool
 *      After use → connection returned to pool
 *
 * Benefits:
 *
 *      ✔ No repeated connection creation
 *      ✔ Faster performance
 *      ✔ Safe for multi-threaded applications
 *      ✔ Database protected from overload
 *
 * This is why Spring Boot uses HikariCP by default.
 *
 * ===========================================================================
 */
public class DBConnection {

	private static Connection connection;
	private static String url="jdbc:mysql://localhost:3306/eazybank";
	private static String username="root";
	private static String passwrod="admin123";
	private DBConnection()
	{
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		if(connection==null)
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Regitered Deriver");
		
			connection=DriverManager.getConnection(url,username,passwrod);
		}
		//connection.setAutoCommit(false);
		return connection;
	}
}
