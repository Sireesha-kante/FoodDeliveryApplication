package com.foodAppDOC_Impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.JDBC.DBUtils;
import com.foodAppDOC.MenuDao;
import com.foodAppModule.Menu;



public  class MenuDaoImpl implements MenuDao{

	private final static String INSERT_QUERY ="Insert into `menu`(`MenuName`,`Description`,`Price`,`isAvailable`,`imgPath`)values(?,?,?,?,?)";
	private final static  String SELECT_ALL_QUERY="Select * from `menu`";
	private final static String SELECT_QUERY="Select * from `menu` where `RestaurantId`=? ";
	private final static String UPDATE_QUERY="Update `menu` set `Description`=?,`Price`=? ,`isAvailable`=? ,`imgPath`=? where `MenuName`=?";
	private final static String DELETE_QUERY= "Delete from `menu` where `MenuName`=?";	
	
	private Connection connection;
	public MenuDaoImpl() {
		this.connection = DBUtils.myconnect();	
		System.out.println("in menu constructor "+connection);
	}
@Override
	public int addMenu(Menu menu)  {
	int status = 0;
	PreparedStatement prepareStatement =null;
		 try {
				prepareStatement=connection.prepareStatement(INSERT_QUERY);
				prepareStatement.setString(1,menu.getMenuName());
				prepareStatement.setString(2,menu.getDescription());
				prepareStatement.setFloat(3,menu.getPrice());
				prepareStatement.setString(4,menu.getIsAvailable());
				prepareStatement.setString(5,menu.getImgPath());
				status=	prepareStatement.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
			 return status;
	}

	@Override
	public List<Menu> getAllMenu() {
		ArrayList<Menu> menuList=new ArrayList<Menu>();
		Statement statement=null;
		ResultSet res=null;
		try {
			statement=connection.createStatement();
			res=statement.executeQuery(SELECT_ALL_QUERY);
		  while (res.next())
			{
			     int MenuId=res.getInt("MenuId");
			    int RestaurantId=res.getInt("RestaurantId");
				String MenuName=res.getString("MenuName");
				String Description =res.getString("Description");
				float Price=res.getFloat("Price");
				String isAvailable =res.getString("isAvailable");
				String imgPath = res.getString("imgPath");
			  Menu menu = new Menu (MenuId,RestaurantId,MenuName,Description,Price,isAvailable,imgPath);
			menuList.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public List<Menu> getMenu(int RestaurantId ) {
		ArrayList<Menu> menuList=new ArrayList<Menu>();
		Menu menu = null;
		PreparedStatement prepareStatement =null;
		ResultSet res=null;
		try {
			prepareStatement =connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, RestaurantId);
			res= prepareStatement.executeQuery();
			while(res.next())
			{ 
				int MenuId=res.getInt("MenuId");
		    String MenuName =res.getString("MenuName");
			String Description =res.getString("Description");
			float Price=res.getFloat("Price");
			String isAvailable =res.getString("isAvailable");
			String imgPath = res.getString("imgPath");
		   menu = new Menu ( MenuId,RestaurantId,MenuName,Description,Price,isAvailable,imgPath);
		   menuList.add(menu);
		}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuList;
	}
@Override
	public int updateMenu(Menu menu) {
	PreparedStatement prepareStatement =null;
	int status = 0;
		try {
			prepareStatement=connection.prepareStatement(UPDATE_QUERY);
			prepareStatement.setString(1,menu.getDescription());
			prepareStatement.setFloat(2,menu.getPrice());
			prepareStatement.setString(3,menu.getIsAvailable());
			prepareStatement.setString(3,menu.getImgPath());
			prepareStatement.setString(5,menu.getMenuName());
			status=prepareStatement.executeUpdate(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public int deleteMenu(String MenuName) {
		int status = 0;
		PreparedStatement prepareStatement =null;
		try {
			prepareStatement=connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setString(1, MenuName);
			status=prepareStatement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	}
