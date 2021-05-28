package in.pritha.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import in.pritha.exception.DBException;
import in.pritha.util.ConnectionUtil;

public class WeddingAppDAO {
	private WeddingAppDAO() {
		
	}
	
	public static Map<String, Integer> getAllWeddingStyles() throws DBException {
		final Map<String, Integer> weddingStylesMap = new HashMap<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select * from wedding_styles";
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				String weddingStyles = result.getString("weddingstyles");
				Integer packages = result.getInt("packages");
				// Store the value in map
				weddingStylesMap.put(weddingStyles, packages);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list wedding styles from db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return weddingStylesMap;
	}

	

	public static Map<String, Integer> getAllWeddingLocations() throws DBException {
		final Map<String, Integer> weddingLocationsMap = new HashMap<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select * from wedding_locations";
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				String weddingLocations = result.getString("weddinglocations");
				Integer packages = result.getInt("packages");
				// Store the value in map
				weddingLocationsMap.put(weddingLocations, packages);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list wedding locations details from db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return weddingLocationsMap;
	}
	
	public static Map<String, Integer> getAllFoodtypes() throws DBException {
		final Map<String, Integer> weddingFoodMap = new HashMap<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select * from food_types";
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				String weddingStyles = result.getString("foodtypes");
				Integer packages = result.getInt("packages");
				// Store the value in map
				weddingFoodMap.put(weddingStyles, packages);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list wedding foods from db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return weddingFoodMap;
	}

	public static Map<String, Integer> getDecortypes() throws DBException {
		final Map<String, Integer> weddingDecorMap = new HashMap<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select * from decor_types";
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				String weddingStyles = result.getString("decortypes");
				Integer packages = result.getInt("packages");
				// Store the value in map
				weddingDecorMap.put(weddingStyles, packages);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list wedding decors from db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return weddingDecorMap;
	}
	public static Map<String, Integer> getAllGuestCount() throws DBException {
		final Map<String, Integer> weddingGuestMap = new HashMap<>();
		// Step 1: get Connection
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			// Step 2: Query Statement
			String sql = "select * from guest_counts";
			// Step 3: Execute Query
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				// Getting the Values
				String weddingStyles = result.getString("guestcounts");
				Integer packages = result.getInt("packages");
				// Store the value in map
				weddingGuestMap.put(weddingStyles, packages);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.getMessage();
			e.printStackTrace();
			throw new DBException(e,"Can't list wedding guest count from db");
		}
		finally {
		ConnectionUtil.close(pst,connection);
		}
		return weddingGuestMap;
	}


}
