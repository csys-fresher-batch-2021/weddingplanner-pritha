package in.pritha.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;


import in.pritha.dto.UserHistoryDTO;
import in.pritha.exception.DBException;

import in.pritha.util.ConnectionUtil;

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
			System.out.println(sql);
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			//input set
			pst.setString(1, userName.toUpperCase());
			System.out.println(userName);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				System.out.println("YES");
				String userNameStr = result.getString("username");
				Integer booking_id= result.getInt("bookingid");
				Integer amount = result.getInt("amount");
				Date bookingDate = result.getDate("bookingdate");
				//LocalDate bookingDate = LocalDate.parse(result.getString("bookingdate"));
				//LocalDate paymentDate= LocalDate.parse(result.getString("paymentdate"));
				Date paymentDate = result.getDate("paymentdate");
				UserHistoryDTO userhistoryDTO= new UserHistoryDTO(userNameStr,booking_id,amount,bookingDate,paymentDate);
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
