package com.mechanicapp;

import java.util.Date;

import java.sql.SQLException;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Scanner;

import com.mechanicapp.dao.ClientDao;
import com.mechanicapp.dao.impl.ClientDaoImpl;
import com.mechanicapp.exception.AppointmentNotFoundException;
import com.mechanicapp.exception.ClientNotFoundException;
import com.mechanicapp.model.Appointment;
import com.mechanicapp.model.Client;

public class ClientManagementApp {
	
    private static void registeringClient() {
    	System.out.println("\n Enter Customer name: ");
        String name = scanner.nextLine();
        System.out.println("\nEnter email name: ");
        String email = scanner.nextLine();
        System.out.println("\nEnter Address: ");
        String address = scanner.nextLine();
        System.out.println("\nEnter Customer Phone Number: ");
        long phno = Long.parseLong(scanner.nextLine());
        
        Client client = new Client(name, email, address, phno);
        
        try {
            if (dao.insert(client)) {
                System.out.println("------ Customer Registration Done --------");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    private static void findById() { 
    	System.out.println("\nEnter Customer Id :- ");
    	int clientId = Integer.parseInt(scanner.nextLine());
        
    	try {
            Client findById = dao.findById(clientId);
            System.out.println(findById);
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    private static void displayAllClient() {
    	try {
            List<Client> displayAllClient = dao.displayAllClient();
            for (Client client : displayAllClient) {
                System.out.println(client);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateAddress() {
        System.out.println("\nEnter Customer Id :- ");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Address :- ");
        String address = scanner.nextLine();

        try {
            Client client = dao.findById(clientId);
            client.setAddress(address);

            if (dao.update(client)) {
                System.out.println("------- Customer Address Updated -------");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updatePhno() {
        System.out.println("\nEnter Customer Id :- ");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Mobile Number :- ");
        Long mobileNo = Long.parseLong(scanner.nextLine());

        try {
            Client client = dao.findById(clientId);
            client.setPhno(mobileNo);

            if (dao.update(client)) {
                System.out.println("------ Customer Mobilr number Update Successfully -------");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateEmailId() {
        System.out.println("\nEnter Customer Id :- ");
        int clientId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Email Id :- ");
        String email = scanner.nextLine();

        try {
            Client client = dao.findById(clientId);
            client.setEmailId(email);

            if (dao.update(client)) {
                System.out.println("------ Customer Email ID Update Successfully -------");
            }
        } catch (ClientNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void delete() {
    	System.out.println("\nEnter Customer ID :- ");
        int id = Integer.parseInt(scanner.nextLine());
        Client client = new Client(id);
        
        try {
            if (dao.delete(client)) {
                System.out.println("------ Customer Deleted -------");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

    }
    
    
    public static void bookAppointment() throws ParseException {
    	
    	System.out.println("\nEnter Appointment Date :- ");
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
    	String strDate = scanner.nextLine();
    	Date date = sdf.parse(strDate);
        
    	System.out.println("\n Enter Location :- ");
        String location = scanner.nextLine();
        
        System.out.println("\nEnter Vehicle Name :- ");
        String vehiclename = scanner.nextLine();
        
        System.out.println("\nEnter Vehicle Number :- ");
        String vehiclenumber = scanner.nextLine();
        
        System.out.println("\nEnter Customer Name :- ");
        String customername = scanner.nextLine(); 
        
        System.out.println("\nEnter Service :- ");
        String servicetype = scanner.nextLine();
        
        System.out.println("\nEnter Customer ID :- ");
        int customerid = Integer.parseInt(scanner.nextLine());
        
        Appointment appointment = new Appointment(date, location, vehiclename, vehiclenumber, customername, servicetype, customerid);
        
        try {
            if (dao.insertappointment(appointment)) {
                System.out.println("------ Appointment Book Successfully ------");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void displayAllAppointment() {
    	try {
            List<Appointment> displayAllAppointment = dao.displayAllAppointment();
            for (Appointment appointment : displayAllAppointment) {
                System.out.println(appointment);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void appointmentFindById() { 
    	System.out.println("\nEnter Customer Id :- ");
    	int appointmentId = Integer.parseInt(scanner.nextLine());
        
    	try {
            Appointment appointmentfindById = dao.appointmentfindById(appointmentId);
            System.out.println(appointmentfindById);
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void deleteAppointment() {
    	System.out.println("\nEnter Customer ID :- ");
        int id = Integer.parseInt(scanner.nextLine());
        Appointment appointment = new Appointment(id);
        
        try {
            if (dao.deleteappointment(appointment)) {
                System.out.println("------ Appoinment Deleted -------");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
   private static void updateAppointmentDate() throws ParseException {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        
        System.out.println("\nEnter New Date :- ");
        
       SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd") ;
    	String strDate1 = scanner.nextLine();
    	Date date1 = sdf1.parse(strDate1);

        try {
         Appointment appointment = dao.appointmentfindById(appointmentId);
         appointment.setDate(date1);    
         
          if (dao.updateappointment(appointment)) {
          System.out.println("------ Appointment Date Update Successfully -------");
           }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
       }
   }
    
    private static void updateLocation() {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Location :- ");
        String location = scanner.nextLine();

        try {
            Appointment appointment = dao.appointmentfindById(appointmentId);
            appointment.setLocation(location);

            if (dao.updateappointment(appointment)) {
                System.out.println("------ Appointment Location Update Successfully -------");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateVehicleName() {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Vehicle Name :- ");
        String vehicleName = scanner.nextLine();

        try {
            Appointment appointment = dao.appointmentfindById(appointmentId);
            appointment.setLocation(vehicleName);

            if (dao.updateappointment(appointment)) {
                System.out.println("------ Vehical Name Update Successfully -------");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateVehicleNumber() {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Vehicle Number:- ");
        String vehicleNumber = scanner.nextLine();

        try {
            Appointment appointment = dao.appointmentfindById(appointmentId);
            appointment.setLocation(vehicleNumber);

            if (dao.updateappointment(appointment)) {
                System.out.println("------ Vehical Number Update Successfully -------");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateCustomerName() {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Cutomer Name :- ");
        String customername = scanner.nextLine();

        try {
        	Appointment appointment = dao.appointmentfindById(appointmentId);
        	appointment.setCustomerName(customername);

            if (dao.updateappointment(appointment)) {
                System.out.println("------- Customer name Update Successfully -------");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    private static void updateService() {
        System.out.println("\nEnter Customer Id :- ");
        int appointmentId = Integer.parseInt(scanner.nextLine());
        System.out.println("\nEnter New Service Type :- ");
        String service = scanner.nextLine();

        try {
        	Appointment appointment = dao.appointmentfindById(appointmentId);
            appointment.setService(service);

            if (dao.updateappointment(appointment)) {
                System.out.println("------- Service Type Update Successfully -------");
            }
        } catch (AppointmentNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }
    
    
    private static Scanner scanner = new Scanner(System.in);
    private static ClientDao dao = new ClientDaoImpl();
    
    public static void main(String[] args) throws Exception {
    	while (true) {
    	   try {	
    		
            System.out.println("Enter any below digit");
            System.out.println("write 1 to choose Customers");
            System.out.println("write 2 to choose Mechanic");
            System.out.println("write 3 to choose Appointment");
            System.out.println("write 4 to choose Service");
            System.out.println("write 0 to choose Exit");
            System.out.println("------------------------------------");
            
            int options = Integer.parseInt(scanner.nextLine());
            
            switch (options) {
            
                case 1:
                    System.out.println("Enter digit :- ");
                    System.out.println("write 1 for Registering A Customer");
                    System.out.println("write 2 for Modifying Customer Details");
                    System.out.println("write 3 for Deleting Customer Record");
                    System.out.println("write 4 for Viewing Single Record");
                    System.out.println("write 5 to Display All Records");
                    System.out.println("0 for Exit");
                    System.out.println("------------------------------------");
                    
                    int inputValueInCustomers = Integer.parseInt(scanner.nextLine());
                    
                    switch (inputValueInCustomers) {
                    
                     
                    case 1:
                            System.out.println("Cutomer Registration Started------");
                            registeringClient();
                            System.out.println("------ Cutomer Registration Ended------");
                            break;
                      
                    case 2:
                    	System.out.println("------ Customer Details UPDATE Choice ------");
                        System.out.println("1 Name");
                        System.out.println("2 Address");
                        System.out.println("3 Phone No");
                        System.out.println("4 Email ID");
                        System.out.println("0 Exit");
                        System.out.println("-----------------------------------------");
                        int UC = Integer.parseInt(scanner.nextLine());
                        
                        switch (UC) {
                        
                        case 1:
                                System.out.println("------ Update Customer Name ------");
                                updateCustomerName();
                                break;
                            
                        case 2:
                                System.out.println("------ Update Customer Address ------");
                                updateAddress();
                                break;
                            
                        case 3:
                                System.out.println("------ Update Cutomer Phone Number ------");
                                updatePhno();
                                break;
                            
                        case 5:
                        	System.out.println("------ Update Customer Email -------");
                        	updateEmailId();
                        	break;
                            
                        case 0:
                        	break;
                        default:
                        	System.exit(0);
                    		}
                        	break;
                    
                    case 3:
                            System.out.println("------ Delete Record of Customer ------");
                            delete();
                            System.out.println("----- Delete Record- of Customer -------");
                            break;
                        
                    case 4:
                           System.out.println("------ Display Single Record of Customer ------");
                           findById();
                           System.out.println("------ Display Single Record of cutomer ------");
                           break;
                        
                    case 5:
                            System.out.println("------  Display All Details of Customer -------");
                            displayAllClient();
                            System.out.println("------  Display All Details of Customer -------");
                            break;
                        
                        
                    case 0:
                            System.exit(0);
                        default:
                            System.exit(0);
                    }
                    break;
                
                case 2:
                	break;
                
                case 3:                 
                    System.out.println("------ APPOINTMENT Choice -------");
                    System.out.println("write 1 to book An Appointment");
                    System.out.println("write 2 to Modify Appointment Details");
                    System.out.println("write 3 to Delete An Appointment");
                    System.out.println("write 4 to View Single Record");
                    System.out.println("write 5 to View All Record");
                    System.out.println("write 0 to Exit");
                    System.out.println("-----------------------------------------");
                    
                    int AUI = Integer.parseInt(scanner.nextLine());
                    
                    switch (AUI) {
                        
                        case 1:
                            System.out.println("------ Book An Appointment -------");
                            bookAppointment();
                            System.out.println("------ Book An Appointment ------");
                             break;
                        
                        case 2:
                            System.out.println("------- Modify Appointment Details -------");
                            System.out.println("------ UPDATE Choice ------");
                            System.out.println("write 1 to Modify Appointment Date");
                            System.out.println("write 2 to Modify Location");
                            System.out.println("write 3 to Modify Vehicle Name");
                            System.out.println("write 4 to Modify Vehicle Number");
                            System.out.println("write 5 to Modify Customer Name");
                            System.out.println("write 6 to Modify Service");
                            System.out.println("write 0 to Exit");
                            System.out.println("-----------------------------------------");
                            
                            int UAC = Integer.parseInt(scanner.nextLine());
                            
                            switch(UAC) {
                            
                            case 1: 
                            	System.out.println("--------Modify Date--------");
                            	updateAppointmentDate();
                            	System.out.println("--------Modify Date---------");
                            	break;
                            
                            case 2: 
                            	System.out.println("--------Modify Location---------");
                            	updateLocation();
                            	System.out.println("--------Modify Location---------");
                            	break;
                            
                            case 3:
                            	System.out.println("--------Modify Vehicle Name---------");
                            	updateVehicleName();
                            	System.out.println("--------Modify Vehicle Name---------");
                            	break;
                            	
                            case 4:
                            	System.out.println("--------Modify Vehicle Number---------");
                            	updateVehicleNumber();
                            	System.out.println("--------Modify Vehicle Number---------");
                            	break;
                            
                            case 5:
                            	System.out.println("--------Modify Customer Name---------");
                            	updateCustomerName();
                            	System.out.println("--------Modify Customer Name---------");
                            	break;
                            	
                            case 6:
                            	System.out.println("--------Modify Service---------");
                            	updateService();
                            	System.out.println("--------Modify Service---------");
                            	break;
                            	
                            case 0:
                                System.exit(0);
                                System.out.println("-----------------------------------------");
                            default:
                                System.exit(0);
                        }
                          
                             break;
                        
                        case 3:
                            System.out.println("------ Delete An Appointment -------");
                            deleteAppointment();
                            System.out.println("------ Delete An Appointment ------");
                            break;
                        
                        case 4:
                            System.out.println("------ View Single Record -------");
                            appointmentFindById();
                            System.out.println("----- View Single Record ------");
                             break;
                        
                        case 5:
                            System.out.println("------ View All Record of Appointment ------");
                            displayAllAppointment();
                            System.out.println("------ View All Record of appointment ------");
                             break;
                        
                        
                        case 0:
                            System.exit(0);
                            System.out.println("-----------------------------------------");
                        default:
                            System.exit(0);
                    }
                    break;
                
                 case 0:
                    System.exit(0);
                    System.out.println("-----------------------------------------");
                default:
                    System.exit(0);
            }
 
          }
    	
    	catch(Exception e) {
    		System.err.println(e);
    	}
      }
    }

}



