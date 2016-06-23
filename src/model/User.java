package model;

import java.io.Serializable;

public class User implements Serializable{
		

	private String firstName;

	private String lastName;

	private String emailAddr;

	private String address1;

	private String address2;

	private String city;

	private String state;

	private String zipcode;

	private String country;
	
	private int userID;
	
	private String password; 
	
	public User(){
		
	}
	public User(int userid, String firstname, String lastname, String email, String address1, String address2, String city, String state, String zip, String country){
		this.userID=userid;
		this.firstName=firstname;
		this.lastName=lastname;
		this.emailAddr=email;
		this.address1=address1;
		this.address2=address2;
		this.city=city;
		this.state=state;
		this.zipcode=zip;
		this.country=country;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddr() {
		return emailAddr;
	}
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	
	
}
