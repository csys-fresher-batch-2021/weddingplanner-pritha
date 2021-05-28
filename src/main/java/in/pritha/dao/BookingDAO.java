package in.pritha.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;




import in.pritha.exception.DBException;
import in.pritha.model.Booking;

import in.pritha.util.ConnectionUtil;

public class BookingDAO {

	private BookingDAO() {
		//to avoid object creation
	}

	public static void addBookingDetails(Integer booking_id,String status,String userName,LocalDate weddingDate, LocalTime weddingTime, String weddingLocation, String weddingStyle, String weddingStyleLocation, String weddingFoodType, String weddingGuestCount, String weddingDecorType) throws DBException {
		
		//2-Get Connection
		Connection connection=null;
		PreparedStatement pst=null;
	try {	
		 connection = ConnectionUtil.getConnection();
		//3- query
		String sql = "insert into booking_details(bookingid,status,username,weddingdate,weddingtime,weddinglocation,weddingstyle,weddingstylelocation,weddingfoodtype,weddingguestcount,weddingdecortype) values (?,?,?,?,?,?,?,?,?,?,?)";
		//4-execute query
		
		 pst = connection.prepareStatement(sql);
		 // to avoid case sensitive
		 	
			pst.setString(3, userName.toUpperCase());
			pst.setDate(4, Date.valueOf(weddingDate));
			pst.setTime(5, Time.valueOf(weddingTime));
			pst.setString(6, weddingLocation);
			pst.setString(7, weddingStyle);
			pst.setString(8, weddingStyleLocation);
			pst.setString(9, weddingFoodType);
			pst.setString(10, weddingGuestCount);
			pst.setString(11, weddingDecorType);
			pst.setInt(1, booking_id);
			pst.setString(2, status );
	        pst.executeUpdate();
			
		//5-release connection

		}catch(SQLException  | ClassNotFoundException e) {
		e.printStackTrace();
		e.getMessage();
		throw new DBException(e,"Can't add booking details in DB");

		}finally {
			ConnectionUtil.close(pst,connection);
		}

}

	public static  List<Booking> displayBookingDetails(String userName) throws DBException {
		List<Booking> bookingDetailsList = new ArrayList<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select * from booking_details where username=?";
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			//input set
			pst.setString(1, userName.toUpperCase());
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				
				String userNameStr = result.getString("username");
				Integer booking_id= result.getInt("bookingid");
				String status = result.getString("status");
				
				LocalDate weddingDate = LocalDate.parse(result.getString("weddingdate"));
				LocalTime weddingTime = LocalTime.parse(result.getString("weddingtime"));
				String weddingLocation = result.getString("weddinglocation");
				String weddingStyle = result.getString("weddingstyle");
				String weddingStyleLocation = result.getString("weddingstylelocation");
				String weddingFoodType = result.getString("weddingfoodtype");
				String weddingGuestCount = result.getString("weddingguestcount");
				String weddingDecorType = result.getString("weddingdecortype");
				
				
				// Store the value in list
				Booking booking = new Booking(booking_id,status,userNameStr, weddingDate, weddingTime, weddingLocation, weddingStyle, weddingStyleLocation, weddingFoodType, weddingGuestCount, weddingDecorType);
				bookingDetailsList.add(booking);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list booking details for this username from db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return bookingDetailsList;
		
	}
	
	
	
	
	public static  boolean cancelBooking(Integer booking_id, String status,String userName,String reason) throws DBException {
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		boolean isCancelled=false;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "update booking_details set status='CANCELLED' , cancellation_reason=? where bookingid=?";
			
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			//input set
			pst.setInt(2,booking_id);
			pst.setString(1, reason);
			pst.executeUpdate();
			isCancelled=true;
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't cancel booking in db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		
		return isCancelled;
			
	}
	
	public static  List<Booking> cancelledBookingDetails(Integer id, String userName, String status) throws DBException {
		List<Booking> bookingDetailsList = new ArrayList<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			 String sql = "select * from booking_details where username=?";
			
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			//input set
			pst.setString(1, userName.toUpperCase());
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
			
				String userNameStr = result.getString("username");
				
				LocalDate weddingDate = LocalDate.parse(result.getString("weddingdate"));
				LocalTime weddingTime = LocalTime.parse(result.getString("weddingtime"));
				String weddingLocation = result.getString("weddinglocation");
				String weddingStyle = result.getString("weddingstyle");
				String weddingStyleLocation = result.getString("weddingstylelocation");
				String weddingFoodType = result.getString("weddingfoodtype");
				String weddingGuestCount = result.getString("weddingguestcount");
				String weddingDecorType = result.getString("weddingdecortype");
				
				
				// Store the value in list
				Booking booking = new Booking(userNameStr, weddingDate, weddingTime, weddingLocation, weddingStyle, weddingStyleLocation, weddingFoodType, weddingGuestCount, weddingDecorType);
				bookingDetailsList.add(booking);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list booking details for this username from db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return bookingDetailsList;
		
	}
	public static  List<Booking> displayAllBookingDetails() throws DBException {
		List<Booking> bookingDetailsList = new ArrayList<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select * from booking_details";
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				
				String userName = result.getString("username");
				
				String status = result.getString("status");
				LocalDate weddingDate = LocalDate.parse(result.getString("weddingdate"));
				LocalTime weddingTime = LocalTime.parse(result.getString("weddingtime"));
				String weddingLocation = result.getString("weddinglocation");
				String weddingStyle = result.getString("weddingstyle");
				String weddingStyleLocation = result.getString("weddingstylelocation");
				String weddingFoodType = result.getString("weddingfoodtype");
				String weddingGuestCount = result.getString("weddingguestcount");
				String weddingDecorType = result.getString("weddingdecortype");
				Integer booking_id= result.getInt("bookingid");
				
				
				
				// Store the value in list
				Booking booking = new Booking(booking_id,status,userName, weddingDate, weddingTime, weddingLocation, weddingStyle, weddingStyleLocation, weddingFoodType, weddingGuestCount, weddingDecorType);
				bookingDetailsList.add(booking);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list all booking details from db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return bookingDetailsList;
		
	}

	public static List<Booking> displayAllConfirmedBookingDetails() throws DBException {
		List<Booking> bookingDetailsList = new ArrayList<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select * from booking_details where status='BOOKED'";
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				
				String userName = result.getString("username");
			
				String status = result.getString("status");
				LocalDate weddingDate = LocalDate.parse(result.getString("weddingdate"));
				LocalTime weddingTime = LocalTime.parse(result.getString("weddingtime"));
				String weddingLocation = result.getString("weddinglocation");
				String weddingStyle = result.getString("weddingstyle");
				String weddingStyleLocation = result.getString("weddingstylelocation");
				String weddingFoodType = result.getString("weddingfoodtype");
				String weddingGuestCount = result.getString("weddingguestcount");
				String weddingDecorType = result.getString("weddingdecortype");
				Integer booking_id= result.getInt("bookingid");
				
				
				
				// Store the value in list
				Booking booking = new Booking(booking_id,status,userName, weddingDate, weddingTime, weddingLocation, weddingStyle, weddingStyleLocation, weddingFoodType, weddingGuestCount, weddingDecorType);
				bookingDetailsList.add(booking);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list all confimed booking details from db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return bookingDetailsList;
		
		
	}

	public static List<Booking> displayAllCancelledBookingDetails() throws DBException {
		
		List<Booking> bookingDetailsList = new ArrayList<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select * from booking_details where status='CANCELLED'";
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				
				String userName = result.getString("username");
				
				String reason = result.getString("cancellation_reason");
				String status = result.getString("status");
				LocalDate weddingDate = LocalDate.parse(result.getString("weddingdate"));
				LocalTime weddingTime = LocalTime.parse(result.getString("weddingtime"));
				String weddingLocation = result.getString("weddinglocation");
				String weddingStyle = result.getString("weddingstyle");
				String weddingStyleLocation = result.getString("weddingstylelocation");
				String weddingFoodType = result.getString("weddingfoodtype");
				String weddingGuestCount = result.getString("weddingguestcount");
				String weddingDecorType = result.getString("weddingdecortype");
				Integer booking_id= result.getInt("bookingid");
				
				
				
				// Store the value in list
				Booking booking = new Booking(booking_id,reason, status,userName, weddingDate, weddingTime, weddingLocation, weddingStyle, weddingStyleLocation, weddingFoodType, weddingGuestCount, weddingDecorType);
				bookingDetailsList.add(booking);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list all cancelled booking details from db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return bookingDetailsList;
		
		
	}
	
	
} 
