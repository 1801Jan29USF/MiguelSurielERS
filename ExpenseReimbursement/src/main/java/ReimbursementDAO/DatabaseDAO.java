package ReimbursementDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import Beans.User;
import Beans.UserReimbursement;
import ConnectionUtil.ConnectionUtil;


public class DatabaseDAO implements ReimbursementDAO {

	private static ConnectionUtil connUtil = ConnectionUtil.getConnectionUtil();
    private static Logger log = Logger.getRootLogger();
    private static User user = new User();
    private UserReimbursement reim = new UserReimbursement();
    
    
   

    
    
    
     
    // register user into the database there username, password, firstname, lastname, and email	
    
	public User Register(User us) {
		// TODO Auto-generated method stub
				log.trace("New user attempting to register");
				log.trace("Attempting to establish a connection with the database");
				log.trace("Please wait");
				log.trace(".......");
		   try(Connection conn = connUtil.getConnection()) {
			   log.trace("connection established with server, creating new user account");
			   PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) VALUES (?,?,?,?,?,?)");
		       ps.setString(1, us.getUsername());
			   ps.setString(2, us.getPassword());
			   ps.setString(3, us.getFirstname());
			   ps.setString(4, us.getLastname());
			   ps.setString(5, us.getEmail());
			   ps.setInt(6,  2);
			   //insert the registered user into the database 
			   int rowsInserted = ps.executeUpdate();
			   log.debug("new user " + rowsInserted + " has been registered to the server");
			   
		} catch (SQLIntegrityConstraintViolationException e) {
			log.warn("Sorry! failed to register new user. User profile is already made.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	//login



		public User Login(String username, String password) {
		// Login Feature into the DAO Server and if the user information contains in the dao 
		// we return the credential to the user		
	    	log.trace("User attempting to login");
			log.trace("Attempting to establish a connection with the database");
			log.trace("Please wait");
			log.trace(".......");
		try (Connection conn = connUtil.getConnection()) {
			log.trace("connection established with server, attempting to login");
			PreparedStatement s = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=? AND ERS_PASSWORD=?");
			s.setString(1, username);
			s.setString(2, password);
			ResultSet rs = s.executeQuery();
			if (rs.next()) {
				 user = new User(rs.getInt("ERS_USERS_ID"), rs.getString("ERS_USERNAME"), rs.getString("ERS_PASSWORD"), rs.getString("USER_FIRST_NAME"),rs.getString("USER_LAST_NAME"),rs.getString("USER_EMAIL"), rs.getInt("USER_ROLE_ID"));
			    log.trace(user);
				 return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.warn("Unable to retrieve user credentials");
		return null;

	    }

// submit reimbursement



		@Override
		public UserReimbursement SubmitRequest(UserReimbursement us) {
			Date Date = new Date();
			log.trace("Attempting to submit request");
			log.trace("connecting with the database");
			log.trace("Please wait");
			log.trace(".......");
     	   try(Connection conn = connUtil.getConnection()) {
		   log.trace("connection established with server, submitting request");
		   PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_REIMBURSEMENT (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_STATUS_ID, REIMB_TYPE_ID) VALUES (?,?,?,?,?,?)");
		   ps.setDouble(1, us.getReimb_amount());
		   ps.setTimestamp(2, new Timestamp(Date.getTime()));
		   ps.setString(3, us.getReimb_description());
		   ps.setInt(4, user.getId());
		   ps.setInt(5, 1);
		   ps.setInt(6, us.getType_id());
		   int rowsInserted = ps.executeUpdate();
		   log.debug(rowsInserted + " new request has been submitted. Thank you!");
		   
	} catch (SQLException e) {
		log.warn("Sorry! failed to register new request.");
		log.trace(user.getId());
		e.printStackTrace();
	}
			return reim;
		}


//updating status


		@Override
		public UserReimbursement UpdateStatus(UserReimbursement ur) {
			Date Date = new Date();
			log.trace("Attempting to update request");
			log.trace("connecting with the database");
			log.trace("Please wait");
			log.trace(".......");
     	   try(Connection conn = connUtil.getConnection()) {
		   log.trace("connection established with server, updating request");
		   PreparedStatement ps = conn.prepareStatement("UPDATE ERS_REIMBURSEMENT SET REIMB_STATUS_ID =?, REIMB_RESOLVED= ?, REIMB_RESOLVER=? WHERE REIMB_ID=?");
		   ps.setInt(1, ur.getReimb_status_id());
		   ps.setTimestamp(2, new Timestamp(Date.getTime()));
		   ps.setInt(3, user.getId());
		   ps.setInt(4, ur.getReimb_id());
		   log.trace(ur.getReimb_id() + ur.getReimb_status_id() + user.getId());
		   int rowsInserted = ps.executeUpdate();
		   log.debug(rowsInserted + " updated request has been accepted. Thank you!");
		   
	} catch (SQLException e) {
		log.warn("Sorry! failed to update.");
		e.printStackTrace();
	}
		return reim;
		}

// find all by author		
		
		public List<UserReimbursement> findbyAuthorid(int userid) {
		
		    List<UserReimbursement> tickets = new ArrayList<>();
			try(Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE REIMB_AUTHOR=?");
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				UserReimbursement us = new UserReimbursement(rs.getInt("REIMB_ID"),rs.getDouble("REIMB_AMOUNT"),rs.getTimestamp("REIMB_SUBMITTED"),rs.getTimestamp("REIMB_RESOLVED"),rs.getString("REIMB_DESCRIPTION"),rs.getInt("REIMB_AUTHOR"),rs.getInt("REIMB_RESOLVER"),rs.getInt("REIMB_STATUS_ID"),rs.getInt("REIMB_TYPE_ID"));
				tickets.add(us);
			}
			} catch (SQLException e) {
				log.warn("failed to retreive tickets");
				e.printStackTrace();
			}
			return tickets;

}
// find all tickets
		public List<UserReimbursement> FindAllReimbursement(UserReimbursement u) {
			
		    List<UserReimbursement> tickets = new ArrayList<>();
			try(Connection conn = connUtil.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_REIMBURSEMENT WHERE reimb_status_id = ? AND REIMB_AUTHOR != ?");
			ps.setInt(1, 1);
     		ps.setInt(2, user.getId());
			ResultSet rs = ps.executeQuery();		
			while (rs.next()) {
				UserReimbursement us = new UserReimbursement(rs.getInt("REIMB_ID"),rs.getDouble("REIMB_AMOUNT"),rs.getTimestamp("REIMB_SUBMITTED"),rs.getTimestamp("REIMB_RESOLVED"),rs.getString("REIMB_DESCRIPTION"),rs.getInt("REIMB_AUTHOR"),rs.getInt("REIMB_RESOLVER"),rs.getInt("REIMB_STATUS_ID"),rs.getInt("REIMB_TYPE_ID"));
				tickets.add(us);
			}
			} catch (SQLException e) {
				log.warn("failed to retreive tickets");
				e.printStackTrace();
			}
			return tickets;
		}


	
}


	
		
		
		
		
		
		
