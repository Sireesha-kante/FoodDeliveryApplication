package com.foodAppDOC;

import java.util.List;

import com.foodAppModule.User;

public interface UserDao {
	int addUser(User  userName);
	List<User>getAllUsers();
	User getUser(String Email);
	int updateUser(User user);
	int  deleteUser(String Email);
	
}
