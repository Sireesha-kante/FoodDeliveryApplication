package com.foodAppDOC_Impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.JDBC.DBUtils;
import com.foodAppDOC.RestaurantDao;
import com.foodAppModule.Restaurant;


public class RestaurantDaoImpl implements RestaurantDao {

	private final static String INSERT_QUERY ="Insert into `restaurant`(`RestaurantName`,`DeliveryTime`,`CuisineType`,`Address`,`Rating`,`isActive`,`AdminId`,`imgPath`)values(?,?,?,?,?,?,?,?)";
	private final static  String SELECT_ALL_QUERY="Select * from restaurant";
	private final static String SELECT_QUERY=" Select * from `restaurant` where `RestaurantName`=?";
	private final static String UPDATE_QUERY="Update `restaurant` set `DeliveryTime`=?,`CusineType`=? ,`Address`=? ,`Rating`=?,`isActive`=?,`AdminId`=?,`imgPath`=? where `RestaurantName`=?";
	private final static String DELETE_QUERY= "Delete from `restaurant` where `RestaurantName`=?";	
	
	private Connection connection;
	
	int status=0;

    
	public RestaurantDaoImpl() {
		this.connection = DBUtils.myconnect();	
		System.out.println("in restaurant constructor "+connection);
	}
	@Override
	public int addRestaurant(Restaurant restaurant) {
		int status = 0;
		PreparedStatement prepareStatement =null;
		 try {
			prepareStatement=connection.prepareStatement(INSERT_QUERY);
			prepareStatement.setString(1,restaurant.getRestaurantName());
			prepareStatement.setInt(2,restaurant.getDeliveryTime());
			prepareStatement.setString(3,restaurant.getCuisineType());
			prepareStatement.setString(4,restaurant.getAddress());
			prepareStatement.setFloat(5,restaurant.getRating());
			prepareStatement.setString(5,restaurant.getIsActive());
			prepareStatement.setInt(5,restaurant.getAdminId());
			prepareStatement.setString(5,restaurant.getImgPath());
		status=	prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return status;
	}
	
	@Override
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> restaurantList=new ArrayList<Restaurant>();
		Statement statement=null;
		ResultSet res=null;
		try {
			statement=connection.createStatement();
			res=statement.executeQuery(SELECT_ALL_QUERY);
		  while (res.next())
			{
			    int RestaurantId=res.getInt("RestaurantId");
				String RestaurantName=res.getString("RestaurantName");
				int DeliveryTime =res.getInt("DeliveryTime");
				String CuisineType =res.getString("CuisineType");
				String Address=res.getString("Address");
				float Rating=res.getFloat("Rating");
				String isActive =res.getString("isActive");
			    int AdminId =res.getInt("AdminId");
				String imgPath = res.getString("imgPath");
				Restaurant  restaurant = new Restaurant (RestaurantId,RestaurantName,DeliveryTime,CuisineType,Address,Rating,isActive,AdminId,imgPath);
				restaurantList.add(restaurant);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurantList;

		}
	
	@Override
	public Restaurant getRestaurant(String RestaurantName) {
		
		PreparedStatement prepareStatement =null;
		Restaurant restaurant=null;
		ResultSet res=null;
		try {
			prepareStatement =connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setString(1,RestaurantName);
			res= prepareStatement.executeQuery();
			if(res.next())
			{
				int RestaurantId=res.getInt("RestaurantId");
				int DeliveryTime =res.getInt("DeliveryTime");
				String CuisineType =res.getString("CuisineType");
				String Address=res.getString("Address");
				float Rating=res.getFloat("Rating");
				String isActive =res.getString("isActive");
			    int AdminId =res.getInt("AdminId");
				String imgPath = res.getString("imgPath");
			  restaurant = new Restaurant (RestaurantId,RestaurantName,DeliveryTime,CuisineType,Address,Rating,isActive,AdminId,imgPath);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return restaurant;
	}
	
	@Override
	public int updateRestaurant(Restaurant restaurant) {
		int status = 0;
		PreparedStatement prepareStatement =null;
		
		try {
			prepareStatement=connection.prepareStatement(UPDATE_QUERY);
			prepareStatement.setInt(1,restaurant.getDeliveryTime());
			prepareStatement.setString(2,restaurant.getCuisineType());
			prepareStatement.setString(3,restaurant.getAddress());
			prepareStatement.setFloat(4,restaurant.getRating());
			prepareStatement.setString(5,restaurant.getIsActive());
			prepareStatement.setInt(6,restaurant.getAdminId());
			prepareStatement.setString(7,restaurant.getImgPath());
			prepareStatement.setString(8,restaurant.getRestaurantName());
			status=prepareStatement.executeUpdate(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	@Override
	public int deleteRestaurant(String RestaurantName) {
		int status = 0;
		PreparedStatement prepareStatement =null;
		
		try {
			prepareStatement=connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setString(1, RestaurantName);
			status=prepareStatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	}
	
