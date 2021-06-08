package in.pritha.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.pritha.exception.DBException;

import in.pritha.model.Payment;
import in.pritha.util.ConnectionUtil;
import in.pritha.util.Logger;

public class PaymentDAO {
	private PaymentDAO() {
		//to avoid object creation
	}

	public static void addPaymentDetails(String cardUserName, Integer bookingId, String cardType, Integer amount, String status, String transactionCode) throws DBException {
		
		//2-Get Connection
		Connection connection=null;
		PreparedStatement pst=null;
	try {	
		 connection = ConnectionUtil.getConnection();
		//3- query
		String sql = "insert into payment_details(username,bookingid,cardtype,amount,status,transactioncode) values (?,?,?,?,?,?)";
		//4-execute query
		
		 pst = connection.prepareStatement(sql);
		 // to avoid case sensitive
		 	pst.setString(1, cardUserName.toUpperCase());
		 	pst.setInt(2, bookingId);
		 	pst.setString(3, cardType);
		 	pst.setInt(4, amount);
			pst.setString(5, status );
			pst.setString(6, transactionCode);
	        pst.executeUpdate();
			
		//5-release connection
		}catch(SQLException  | ClassNotFoundException e) {
		e.printStackTrace();
		e.getMessage();
		throw new DBException(e,"Can't add given payment details in DB");

		}finally {
			ConnectionUtil.close(pst,connection);
		}

}
	
	public static List<Payment> displayAllPaidBookingDetails() throws DBException {
		List<Payment> paidBookingDetailsList = new ArrayList<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select * from payment_details where status='PAID'";
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				
				String userName = result.getString("username");
				Integer bookingId= result.getInt("bookingid");
				String cardType = result.getString("cardtype");
				Integer amount = result.getInt("amount");
				String status = result.getString("status");
				String transactioncode = result.getString("transactioncode");
				
				
				
				
				// Store the value in list
				Payment payment = new Payment(userName,bookingId,cardType,amount,status,transactioncode);
				paidBookingDetailsList.add(payment);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list all paid booking details from db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return paidBookingDetailsList;
		
		
		
	}

	
			public static void insertDiscountDetails(Integer bookingId ) throws DBException {
				//2-Get Connection
						Connection connection=null;
						PreparedStatement pst=null;
					try {	
						 connection = ConnectionUtil.getConnection();
						//3- query
						String sql = "INSERT INTO discount_details (bookingid) values(?)";
						//4-execute query
						
						 pst = connection.prepareStatement(sql);
						//input set
						 	
						 	Logger.println(sql);
						 	pst.setInt(1, bookingId);
					        pst.executeUpdate();
							
						//5-release connection
						}catch(SQLException  | ClassNotFoundException e) {
						e.printStackTrace();
						e.getMessage();
						throw new DBException(e,"Can't add given discount details in DB");

						}finally {
							ConnectionUtil.close(pst,connection);
						}

		
	}
	


}
