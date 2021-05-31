package in.pritha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.pritha.exception.DBException;
import in.pritha.util.ConnectionUtil;
import in.pritha.util.Logger;

public class UserDAO {
	
	private UserDAO() {
		
	}

	public static boolean deleteUser(String logoutUser) throws DBException {
		Connection connection = null;
		PreparedStatement pst=null;
		boolean isDeleted = false;
		try {
			connection = ConnectionUtil.getConnection();

			String sql = "update user_details set status='INACTIVE' where username=?";
			// 4-execute query

			 pst = connection.prepareStatement(sql);
			pst.setString(1, logoutUser.toUpperCase()); // to avoid case sensitive
			int rows = pst.executeUpdate();
			Logger.println(rows);
			isDeleted = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			e.getMessage();
			throw new DBException(e,"can't delete this user in db");
			
		} finally {
		// 5-release connection
		ConnectionUtil.close(pst, connection);
	}
		return isDeleted;
	}
		
	}


