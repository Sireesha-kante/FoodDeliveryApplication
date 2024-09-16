package com.foodAppDOC_Impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.JDBC.DBUtils;
import com.foodAppDOC.UserDao;
import com.foodAppModule.User;

public class UserDaoImpl implements UserDao {

	private final static String INSERT_QUERY ="Insert into `user`(`UserName`,`Password`,`Email`,`PhoneNumber`,`Address`)values(?,?,?,?,?)";
	private final static  String SELECT_ALL_QUERY="Select * from user";
	private final static String SELECT_QUERY="Select * from `user` where `Email`=?";
	private final static String UPDATE_QUERY="Update `user` set `UserName`=? ,`Password`=?,`Email`=? , `PhoneNumber`=? ,`Address`=? where `UserId`=?";
	private final static String DELETE_QUERY="Delete from`user` where `Email`=?";	
	
	private Connection connection;
	
	public UserDaoImpl()
	{
		this.connection = DBUtils.myconnect();	
		System.out.println("in user constructor "+connection);
	}
	public int addUser(User user) {
		int status = 0;
		PreparedStatement prepareStatement =null;
		 try {
			 prepareStatement=connection.prepareStatement(INSERT_QUERY);
			prepareStatement.setString(1,user.getUserName());
			prepareStatement.setString(2,user.getPassword());
			prepareStatement.setString(3,user.getEmail());
			prepareStatement.setLong(4,user.getPhoneNumber());
			prepareStatement.setString(5,user.getAddress());
		status=	prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return status;
	}
	
	
	@Override
	public List<User> getAllUsers() {
		ArrayList<User> userList=new ArrayList<User>();
		Statement statement=null;
		ResultSet res=null;
		try {
			statement=connection.createStatement();
			res=statement.executeQuery(SELECT_ALL_QUERY);
		  while (res.next())
			{
			    int UserId=res.getInt("UserId");
				String UserName=res.getString("UserName");
				String Password=res.getString("Password");
				String Email=res.getString("Email");
				Long PhoneNumber=res.getLong("PhoneNumber");
				String Address=res.getString("Address");
				Date CreatedDate =res.getDate("CreatedDate");
				Date LastLoginDate =res.getDate("LastLoginDate");
				User user = new User(UserId, UserName, Password, Email, PhoneNumber, Address, CreatedDate, LastLoginDate);
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;

		}

	@Override
	public User getUser(String Email) {
		User user = null;
		PreparedStatement prepareStatement =null;
		ResultSet res=null;
		try {
			 prepareStatement =this.connection.prepareStatement(SELECT_QUERY);
			 prepareStatement.setString(1,Email);
			res= prepareStatement.executeQuery();
			if(res.next())
			{
				int UserId=res.getInt("UserId");
				String UserName=res.getString("UserName");
				String Password=res.getString("Password");
				Long PhoneNumber=res.getLong("PhoneNumber");
				String Address=res.getString("Address");
				Date CreatedDate =res.getDate("CreatedDate");
				Date LastLoginDate =res.getDate("LastLoginDate");
				user = new User(UserId, UserName, Password, Email, PhoneNumber, Address, CreatedDate, LastLoginDate);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int  updateUser(User user) {
		PreparedStatement prepareStatement =null;
		int status = 0;
		try {
			prepareStatement=connection.prepareStatement(UPDATE_QUERY);
			
			prepareStatement.setString(1, user.getUserName());
			prepareStatement.setString(2, user.getPassword());
			prepareStatement.setString(3, user.getEmail());
			prepareStatement.setLong(4, user.getPhoneNumber());
			prepareStatement.setString(5, user.getAddress());
			prepareStatement.setInt(6, user.getUserId());
			status=prepareStatement.executeUpdate(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteUser(String Email) {
		int status = 0;
		PreparedStatement prepareStatement =null;
		try {
			prepareStatement=connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setString(1, Email);
			status=prepareStatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
