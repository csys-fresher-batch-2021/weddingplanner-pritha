package in.pritha.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import in.pritha.exception.DBException;
import in.pritha.util.ConnectionUtil;

public class BookingDAO {
	
	private BookingDAO() {
		
	}

	public static void addBookingDetails(String userName,LocalDate weddingDate, LocalTime weddingTime, String weddingLocation) throws DBException {
		//*****add booking details*****
		//2-Get Connection
		Connection connection=null;
		PreparedStatement pst=null;
	try {	
		 connection = ConnectionUtil.getConnection();
		//3- query
		String sql = "insert into booking_details( username,weddingdate, weddingtime,weddinglocation) values (?,?,?,?)";
		//4-execute query
		/*
		 * PreparedStatement pst1 = connection.prepareStatement(sql1); PreparedStatement
		 * pst2 = connection.prepareStatement(sql2);
		 */
		 pst = connection.prepareStatement(sql);
		 // to avoid case sensitive
			pst.setString(1, userName.toUpperCase());
			pst.setDate(2, Date.valueOf(weddingDate));
			pst.setTime(3, Time.valueOf(weddingTime));
			pst.setString(4, weddingLocation);
	         pst.executeUpdate();
			//System.out.println("No.of.rows.inserted "+rows);
		//5-release connection
		
		}catch(SQLException  | ClassNotFoundException e) {
		e.printStackTrace();
		e.getMessage();
		throw new DBException(e,"Can't add booking details in DB");
		
		}finally {
			ConnectionUtil.close(pst,connection);
		}

}
}