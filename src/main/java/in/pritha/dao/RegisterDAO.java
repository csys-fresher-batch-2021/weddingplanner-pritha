package in.pritha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import in.pritha.model.User;
import in.pritha.util.ConnectionUtil;

public class RegisterDAO {

	public static void addUser(String userName, String passWord) throws ClassNotFoundException,SQLException{
	//*****add username*****
	//2-Get Connection
	Connection connection = ConnectionUtil.getConnection();
	//3-query
	/*
	 * String sql1= "create table userDetails(username varchar(100) not null)";
	 * String sql2 ="alter table userDetails add passWord varchar(100) primary key";
	 */
	String sql = "insert into user_details( username,password) values (?,?)";
	//4-execute query
	/*
	 * PreparedStatement pst1 = connection.prepareStatement(sql1); PreparedStatement
	 * pst2 = connection.prepareStatement(sql2);
	 */
	PreparedStatement pst = connection.prepareStatement(sql);
	pst.setString(1, userName.toUpperCase()); // to avoid case sensitive
	pst.setString(2, passWord);
	/*
	 * pst1.execute(); pst2.execute();
	 */
	int rows = pst.executeUpdate();
	System.out.println("No.of.rows.inserted "+rows);
	//5-release connection
	ConnectionUtil.close(connection);
	}
	
	public static Map<String,String> getAllUserDetails() throws ClassNotFoundException, SQLException {
	 final Map<String, String> userListMap = new HashMap<>();
		// Step 1: get Connection
		Connection connection = ConnectionUtil.getConnection();
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
			userListMap.put(userName,passWord);
		}
		ConnectionUtil.close(connection);
		return userListMap;
	}
	
	public static void modifyUserPassWord(String userName, String modifiedPassWord) throws ClassNotFoundException,SQLException{
		//*****add username*****
		//2-Get Connection
		Connection connection = ConnectionUtil.getConnection();
		//3-query
		/*
		 * String sql1= "create table userDetails(username varchar(100) not null)";
		 * String sql2 ="alter table userDetails add passWord varchar(100) primary key";
		 */
		String sql = "update user_Details set password=? where username=?";
		//4-execute query
		/*
		 * PreparedStatement pst1 = connection.prepareStatement(sql1); PreparedStatement
		 * pst2 = connection.prepareStatement(sql2);
		 */
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(2, userName.toUpperCase()); // to avoid case sensitive
		pst.setString(1, modifiedPassWord);
		/*
		 * pst1.execute(); pst2.execute();
		 */
		int rows = pst.executeUpdate();
		System.out.println("No.of.rows.updated "+rows);
		//5-release connection
		ConnectionUtil.close(connection);
		}
		

	
	
}
