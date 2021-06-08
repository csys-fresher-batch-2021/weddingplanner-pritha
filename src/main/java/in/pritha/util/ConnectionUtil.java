package in.pritha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectionUtil {
	
	private ConnectionUtil() {
		//private constructor
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/weddingapp_db";
		String username = "postgres";
		String password = "Cedricliahh@36";
		
		
		
		// Step 1: Load the jdbc driver in memory
		Class.forName(driverClass);
		// Step 2: Get the connection
		Connection connection = DriverManager.getConnection(url, username, password);
		Logger.println("Connection Created");
		return connection;
	}
	public static void close(Statement st, Connection con) {
		try {
			if(st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, Statement st, Connection con) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}