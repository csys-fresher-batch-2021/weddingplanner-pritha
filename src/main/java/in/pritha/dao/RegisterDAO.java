package in.pritha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import in.pritha.util.ConnectionUtil;
import in.pritha.util.Logger;

public class RegisterDAO {

	private RegisterDAO() {

	}

	public static void addUser(String userName, String passWord)  {

		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into user_details( username,password) values (?,?)";

			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(1, userName.toUpperCase()); // to avoid case sensitive
			pst.setString(2, passWord);

			int rows = pst.executeUpdate();
			Logger.println("No.of.rows.inserted " + rows);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

		ConnectionUtil.close(connection);
	}

	public static Map<String, String> getAllUserDetails() {
		final Map<String, String> userListMap = new HashMap<>();
		// Step 1: get Connection
		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select * from user_Details";
			// Step 3: Execute Query
			PreparedStatement pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				String userName = result.getString("username");
				String passWord = result.getString("password");
				// Store the value in map
				userListMap.put(userName, passWord);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		ConnectionUtil.close(connection);
		return userListMap;
	}

	public static void modifyUserPassWord(String userName, String modifiedPassWord)
			{

		Connection connection = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "update user_Details set password=? where username=?";
			// 4-execute query

			PreparedStatement pst = connection.prepareStatement(sql);
			pst.setString(2, userName.toUpperCase()); // to avoid case sensitive
			pst.setString(1, modifiedPassWord);

			int rows = pst.executeUpdate();
			Logger.println("No.of.rows.updated " + rows);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
		// 5-release connection
		ConnectionUtil.close(connection);
	}
	}

}
