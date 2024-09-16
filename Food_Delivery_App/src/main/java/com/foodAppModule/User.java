package com.foodAppModule;

import java.util.Date;

public class User {
	private int UserId;
	private String UserName;
	private String Password;
	private String Email;
	private long PhoneNumber;
	private String Address;
	private Date CreatedDate;
	private Date LastLoginDate;

	public User()
	{}
	public User(int userId, String userName, String password, String email,Long phonenumber, String address, Date createddate,
			Date lastlogidate) {
		super();
		this.UserId = userId;
		this.UserName = userName;
		this.Password = password;
		this.Email = email;
		this.PhoneNumber=phonenumber;
		this.Address = address;
		this.CreatedDate = createddate;
		this.LastLoginDate = lastlogidate;
	}
	
	public User(String userName, String password, String email, long phoneNumber, String address, int userid) {
		super();
		UserName = userName;
		Password = password;
		Email = email;
		PhoneNumber = phoneNumber;
		Address = address;
		UserId =userid;
	}
	public User(String userName, String password, String email, long phoneNumber, String address) {
		super();
		UserName = userName;
		Password = password;
		Email = email;
		PhoneNumber = phoneNumber;
		Address = address;
	}
	
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		this.UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		this.UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	
	public long getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public Date getCreateddate() {
		return CreatedDate;
	}

	public void setCreateddate(Date createddate) {
		CreatedDate = createddate;
	}

	public Date getLastlogidate() {
		return LastLoginDate;
	}

	public void setLastlogidate(Date lastlogidate) {
		this.LastLoginDate = lastlogidate;
	}
	
	@Override
	public String toString() {
		
		return "User[" + "Id:" + UserId + "Name:" + UserName + "Email:" + Email + " PhoneNumber:" + PhoneNumber + " Address"+ Address+"]";
	}
}
