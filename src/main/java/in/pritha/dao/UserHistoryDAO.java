package in.pritha.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import in.pritha.dto.UserHistoryDTO;
import in.pritha.exception.DBException;

import in.pritha.util.ConnectionUtil;
import in.pritha.util.Logger;

public class UserHistoryDAO {
	
	private UserHistoryDAO() {
		
	}
	
	private static final String BASE_QUERY = "select  u.username as username, b.bookingid as bookingid, p.amount as amount , b.bookingdate as bookingdate ,p.paymentdate as paymentdate  \r\n"
			+ "from user_details u, booking_details b, payment_details p  where b.username= u.username  and b.bookingid=p.bookingid ";
	
	public static  List<UserHistoryDTO> findUserHistory(String userName) throws DBException {
		List<UserHistoryDTO> userHistoryList = new ArrayList<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = BASE_QUERY + " AND b.username = ? ";
			Logger.println(sql);
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			//input set
			pst.setString(1, userName.toUpperCase());
			Logger.println(userName);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				Logger.println("YES");
				String userNameStr = result.getString("username");
				Integer bookingId= result.getInt("bookingid");
				Integer amount = result.getInt("amount");
				Timestamp bookingDateSql = result.getTimestamp("bookingdate");
				Timestamp paymentDateSql = result.getTimestamp("paymentdate");
				LocalDateTime bookingDate = bookingDateSql.toLocalDateTime();
				LocalDateTime paymentDate= paymentDateSql.toLocalDateTime();
				
				UserHistoryDTO userhistoryDTO= new UserHistoryDTO(userNameStr,bookingId,amount,bookingDate,paymentDate);
				userHistoryList.add(userhistoryDTO);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list user history for this username from db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return userHistoryList;
		
		
	}
	

}
