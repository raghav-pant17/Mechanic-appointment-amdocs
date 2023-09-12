package com.mechanicapp.model;

import java.util.Date;

public class Appointment {
	
	private int appointmentid;
	private Date date;
	private String location;
	private String vehicleName;
	private String vehicleNumber;
	private String customerName;
	private String service;
	private int customerid;
	
	public int getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	 
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Appointment(int appointmentid, Date date, String location, String customerName, String service) {
		this.appointmentid = appointmentid;
		this.date = date;
		this.location = location;
		this.customerName = customerName;
		this.service = service;
	}
	public Appointment(Date date, String location,  String customerName, String service) {
		this.date = date;
		this.location = location;
		this.customerName = customerName;
		this.service = service;
	}
	public Appointment() {
		//super();
	}
	public Appointment(int appointmentid) {
		//super();
		this.appointmentid = appointmentid;
	}
	public Appointment(int appointmentid, Date date, String location, String vehicleName, String vehicleNumber,
			String customerName, String service) {
		//super();
		this.appointmentid = appointmentid;
		this.date = date;
		this.location = location;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.customerName = customerName;
		this.service = service;
	}
	public Appointment(Date date, String location, String vehicleName, String vehicleNumber, String customerName,
			String service) {
		//super();m
		this.date = date;
		this.location = location;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.customerName = customerName;
		this.service = service;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public Appointment(Date date, String location, String vehiclename, String vehiclenumber, String customername,
			String service, int customerid) {
		//super();
		this.date = date;
		this.location = location;
		this.vehicleName = vehicleName;
		this.vehicleNumber = vehicleNumber;
		this.customerName = customerName;
		this.service = service;
		this.customerid = customerid;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentid=" + appointmentid + ", date=" + date + ", location=" + location
				+ ", vehicleName=" + vehicleName + ", vehicleNumber=" + vehicleNumber + ", customerName=" + customerName
				+ ", service=" + service + ", customerid=" + customerid
				+ "]";
	}
	 
	
	 
	 

}
