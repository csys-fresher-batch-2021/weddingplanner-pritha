package in.pritha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionUtil {
	
	

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/login_db";
		String username = "postgres";
		String password = "Cedricliahh@36";
		// Step 1: Load the jdbc driver in memory
		Class.forName(driverClass);
		// Step 2: Get the connection
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Created");
		return connection;
	}
	public static void close(Connection con) {
		try {
			if (con != null) {
				con.close();
				System.out.println("Connection Released");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}