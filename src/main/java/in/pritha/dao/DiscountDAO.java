package in.pritha.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import in.pritha.exception.DBException;
import in.pritha.model.Discount;
import in.pritha.util.ConnectionUtil;

public class DiscountDAO {
	
	private DiscountDAO() {
		
	}
	
public static void addDiscountDetails(String username, Integer bookingId, String status) throws DBException {
		System.out.println("inserted discount table");
		//2-Get Connection
		Connection connection=null;
		PreparedStatement pst=null;
	try {	
		 connection = ConnectionUtil.getConnection();
		//3- query
		String sql = "insert into discount_details(username,bookingid,booking_status) values (?,?,?)";
		//4-execute query
		
		 pst = connection.prepareStatement(sql);
		 // to avoid case sensitive
		 	pst.setString(1,username.toUpperCase());
			pst.setInt(2, bookingId);
			pst.setString(3,status);
			pst.executeUpdate();
			
			
		//5-release connection
		}catch(SQLException  | ClassNotFoundException e) {
		e.printStackTrace();
		e.getMessage();
		throw new DBException(e,"Can't add discount details in DB");

		}finally {
			ConnectionUtil.close(pst,connection);
		}

}

public static Integer countEarnedCoins(String userName) throws DBException {
	
	//2-Get Connection
			Connection connection=null;
			PreparedStatement pst=null;
			Integer earnedCoins =null;
		
		
		try {	
			 connection = ConnectionUtil.getConnection();
			//3- query
			String sql = "select sum(earned_coins) as earned_coins "
					+ "from discount_details\r\n"
					+ "where username=? and discount_status ='UNUSED'\r\n"
					+ "having count(*)>=1";
			pst = connection.prepareStatement(sql);
			//input set
			pst.setString(1, userName.toUpperCase());
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				
				  earnedCoins = result.getInt("earned_coins");
				  System.out.println("EarnedCoins"+earnedCoins);
			}
		}catch(SQLException  | ClassNotFoundException |NullPointerException e) {
			e.printStackTrace();
			e.getMessage();
			throw new DBException(e,"Can't collect earned coins from discount details in DB");

			}finally {
				ConnectionUtil.close(pst,connection);
			}
		return earnedCoins;

	}
			
public static void updateDiscountDetails(String userName
		) throws DBException {
	//2-Get Connection
	
			Connection connection=null;
			PreparedStatement pst=null;
		try {	
			 connection = ConnectionUtil.getConnection();
			//3- query
			String sql = "update discount_details set discount_status='USED', earned_coins=0 where username=?";
			//4-execute query
			
			 pst = connection.prepareStatement(sql);
			//input set
			 	
			 	
			 	pst.setString(1, userName.toUpperCase());
				
	
		        pst.executeUpdate();
				
			//5-release connection
			}catch(SQLException  | ClassNotFoundException e) {
			e.printStackTrace();
			e.getMessage();
			throw new DBException(e,"Can't update given discount details in DB");

			}finally {
				ConnectionUtil.close(pst,connection);
			}
}
				
				
				
		


}
