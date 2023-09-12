package com.mechanicapp.model;

public class Client {
	
	private int customerid;
	private String name;
	private String email;
	private String address;
	private long phno;
	
	public Client() {
	}
	
	public Client(int customerid) {
		this.customerid = customerid;
	}
	public Client(String name, String email, String address, long phno) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.phno = phno;
	}
	public Client(int customerid, String name, String email, String address, long phno) {
		this.customerid = customerid;
		this.name = name;
		this.email = email;
 		this.address = address;
		this.phno = phno;
	}
	public int getCustomerId() {
		return customerid;
	}
	public void setCustomerId(int customerid) {
		this.customerid = customerid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return email;
	}
	public void setEmailId(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhno() {
		return phno;
	}
	public void setPhno(long phno) {
		this.phno = phno;
	}
	
	@Override
	public String toString() {
		return "Client [customerid=" + customerid + ", name=" + name + ", email=" + email + ", address="
				+ address + ", phno=" + phno + "]";
	}
	
	 
	 
	
	
	
}
