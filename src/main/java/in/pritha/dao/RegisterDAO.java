package in.pritha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import in.pritha.exception.DBException;
import in.pritha.util.ConnectionUtil;



public class RegisterDAO {

	private RegisterDAO() {

	}

	public static void addUser(String userName, String passWord) throws DBException  {

		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "insert into user_details(username,password) values (?,?)";

			pst= connection.prepareStatement(sql);
			pst.setString(1, userName.toUpperCase()); // to avoid case sensitive
			pst.setString(2, passWord);
			pst.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {			
			e.printStackTrace();
			e.getMessage();
			throw new DBException(e,"Unable to add user details in db");
		}finally {

		ConnectionUtil.close(pst,connection);
		}
	}

	public static Map<String, String> getAllUserDetails() throws DBException {
		final Map<String, String> userListMap = new HashMap<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select * from user_details";
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				String userName = result.getString("username");
				String passWord = result.getString("password");
				// Store the value in map
				userListMap.put(userName, passWord);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list user details in db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return userListMap;
	}

	public static void modifyUserPassWord(String userName, String modifiedPassWord) throws DBException
			{

		Connection connection = null;
		PreparedStatement pst=null;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "update user_details set password=? where username=?";
			// 4-execute query

			 pst = connection.prepareStatement(sql);
			pst.setString(2, userName.toUpperCase()); // to avoid case sensitive
			pst.setString(1, modifiedPassWord);

			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			e.getMessage();
			throw new DBException(e,"can't modify password in db");
			
		} finally {
		// 5-release connection
		ConnectionUtil.close(pst, connection);
	}
	}

}
