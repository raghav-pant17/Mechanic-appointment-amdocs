package com.mechanicapp.dao.impl;

 
import java.sql.Connection;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mechanicapp.dao.ClientDao;
import com.mechanicapp.exception.AppointmentNotFoundException;
import com.mechanicapp.exception.ClientNotFoundException;
import com.mechanicapp.model.Appointment;
import com.mechanicapp.model.Client;
import com.mechanicapp.util.DbUtil;

public class ClientDaoImpl implements ClientDao {
	
		private final static String SELECT_ALL = "SELECT * FROM CUSTOMER";
		private final static String SELECT_ALL_APPOINMENT = "SELECT * FROM appointment";
		
		private final static String SELECT_BY_ID = "SELECT * FROM CUSTOMER WHERE customerid=?";
		private final static String SELECT_BY_ID_APPOINTMENT = "SELECT * FROM appointment WHERE customerid=?";
		
		private final static String INSERT = "insert into customer(name,address, emailid, phno) values(?,?,?,?)";
		private final static String INSERT_APPOINTMENT = "insert into appointment(date,location,vehiclename, vehiclenumber, customername, service,customerid) values(?,?,?,?,?,?,?)";
		
		private final static String UPDATE = "UPDATE CUSTOMER SET firstName=?, lastName=?, address=?, emailid=?, phno=? WHERE customerid=?";
		private final static String UPDATE_APPOINTMENT = "UPDATE appointment SET date=?, location=?,vehiclename=?,vehiclenumber=?, customername=?, service=? WHERE customerid=?";
		
		private final static String DELETE = "DELETE FROM CUSTOMER WHERE customerid = ? ";
		private final static String DELETE_APPOINTMENT = "DELETE FROM appointment WHERE customerid = ? ";

		
		private Connection connection = DbUtil.getConnection();
		
	    @Override
	    public List<Client> displayAllClient() throws SQLException {
	    		        List<Client> clients = new ArrayList<>();
	        Statement stmt = connection.createStatement();  
	        ResultSet rs = stmt.executeQuery(SELECT_ALL);
	        
	        while (rs.next()) {
	            Client client = new Client();
 	            client.setCustomerId(rs.getInt("customerid"));
	            client.setName(rs.getString("name"));
	            client.setAddress(rs.getString("address"));
	            client.setEmailId(rs.getString("emailid"));
	            client.setPhno(rs.getLong("phno"));  
	            clients.add(client);
	        }
	        rs.close();
	        stmt.close();
	        return clients;
	    }
	    

	    @Override
	    public Client findById(int clientId) throws ClientNotFoundException, SQLException {
	        Client client = null;
	        PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID);
	        stmt.setInt(1, clientId);
	        ResultSet rs = stmt.executeQuery();
	       // System.out.println("Rs  : "  + rs);
	        if (rs.next()) {
	            client = new Client();
	            client.setCustomerId(rs.getInt("customerid"));
	            client.setName(rs.getString("name"));
	            client.setAddress(rs.getString("address"));
	            client.setEmailId(rs.getString("email"));
	            client.setPhno(rs.getLong("phno"));
	        } else {
	            throw new ClientNotFoundException("Client Not Found With Id: " + clientId);
	        }
	        rs.close();
	        stmt.close();
	        return client;
	    }
	    
		@Override
		public boolean update(Client client) throws SQLException {
			PreparedStatement stmt = connection.prepareStatement(UPDATE);
			
			stmt.setString(1,client.getName() );
			stmt.setString(2,client.getAddress() );
			stmt.setString(3, client.getEmailId());
			stmt.setLong(4, client.getPhno());
			stmt.setInt(5,client.getCustomerId() );
			
			int updated = stmt.executeUpdate();
			stmt.close();
			
			return updated > 0;	
			
	}
		//@Override
		public boolean delete(Client client) throws SQLException {
			PreparedStatement stmt = connection.prepareStatement(DELETE);
	        stmt.setInt(1, client.getCustomerId());
			
			int deleted = stmt.executeUpdate();
			
			stmt.close();
			return deleted > 0;

	}

		@Override
		public boolean insert (Client client) throws SQLException {
			boolean result=false;
			PreparedStatement stmt = connection.prepareStatement(INSERT);
			stmt.setString(1,client.getName() );
			stmt.setString(2,client.getAddress() );
			stmt.setString(3, client.getEmailId());
			stmt.setLong(4, client.getPhno());
			if(stmt.executeUpdate()>0) {
				result = true;
			}
			stmt.close();
			return result;
		}

		@Override
		public List<Appointment> displayAllAppointment() throws SQLException {
			List<Appointment> appointments = new ArrayList<>();
	        Statement stmt = connection.createStatement();  
	        ResultSet rs = stmt.executeQuery(SELECT_ALL_APPOINMENT);
	        
	        while (rs.next()) {
	            Appointment appointment = new Appointment();
	            appointment.setAppointmentid(rs.getInt("Appointmentid"));
	            appointment.setDate(rs.getDate("date"));
	            appointment.setLocation(rs.getString("location"));
	            appointment.setVehicleName(rs.getString("vehiclename"));
	            appointment.setVehicleNumber(rs.getString("vehiclenumber"));
	            appointment.setCustomerName(rs.getString("customername"));
	            appointment.setService(rs.getString("service")); 
	            appointment.setCustomerid(rs.getInt("customerid"));
	            appointments.add(appointment);
	        }
	        rs.close();
	        stmt.close();
	        return appointments;
			 
		}

		
		@Override
		public Appointment appointmentfindById(int appointmentId) throws AppointmentNotFoundException, SQLException {
			Appointment appointment = null;
	        PreparedStatement stmt = connection.prepareStatement(SELECT_BY_ID_APPOINTMENT);
	        stmt.setInt(1, appointmentId);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	        	appointment = new Appointment();
	        	appointment.setAppointmentid(rs.getInt("appointmentid"));
	        	appointment.setDate(rs.getDate("date"));
	            appointment.setLocation(rs.getString("location"));
	            appointment.setVehicleName(rs.getString("vehiclename"));
	            appointment.setVehicleNumber(rs.getString("vehiclenumber"));
	            appointment.setCustomerName(rs.getString("customername"));
	            appointment.setService(rs.getString("service")); 
	            appointment.setCustomerid(rs.getInt("customerid"));
	        } else {
	            throw new AppointmentNotFoundException("Appointment Not Found With Id: " + appointmentId);
	        }
	        rs.close();
	        stmt.close();
	        return appointment;
			 
		}

		
		@Override
		public boolean insertappointment(Appointment appointment) throws SQLException {
			boolean result=false;
			PreparedStatement stmt = connection.prepareStatement(INSERT_APPOINTMENT);
			stmt.setDate(1, new java.sql.Date(appointment.getDate().getTime()));
			stmt.setString(2,appointment.getLocation() );
			stmt.setString(3,appointment.getVehicleName() );
			stmt.setString(4,appointment.getVehicleNumber() );
			stmt.setString(5,appointment.getCustomerName());
			stmt.setString(6, appointment.getService());
			stmt.setInt(7,appointment.getCustomerid() );
			if(stmt.executeUpdate()>0) {
				result = true;
			}
			stmt.close();
			return result;
			 
		}

		@Override
		public boolean updateappointment(Appointment appointment) throws SQLException {
			PreparedStatement stmt = connection.prepareStatement(UPDATE_APPOINTMENT);
			stmt.setDate(1, new java.sql.Date(appointment.getDate().getTime()));
			stmt.setString(2,appointment.getLocation() );
			stmt.setString(3,appointment.getVehicleName() );
			stmt.setString(4,appointment.getVehicleNumber() );
			stmt.setString(5,appointment.getCustomerName() );
			stmt.setString(6, appointment.getService());
			stmt.setInt(7,appointment.getCustomerid());			
			int updated = stmt.executeUpdate();
			stmt.close();
			
			return updated > 0;	
			 
		}

		
		@Override
		public boolean deleteappointment(Appointment appointment) throws SQLException {
			PreparedStatement stmt = connection.prepareStatement(DELETE_APPOINTMENT);
	        stmt.setInt(1, appointment.getAppointmentid());
			
			int deleted = stmt.executeUpdate();
			
			stmt.close();
			return deleted > 0;
			 
		}


		 

}
