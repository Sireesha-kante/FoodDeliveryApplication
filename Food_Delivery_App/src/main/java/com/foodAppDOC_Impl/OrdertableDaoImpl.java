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
import com.foodAppDOC.OrdertableDao;
import com.foodAppModule.Ordertable;


public class OrdertableDaoImpl implements OrdertableDao {
	private final static String INSERT_QUERY ="Insert into `ordertable`(`RestaurantId`,`UserId`,`TotalAmount`,`Status`,`PaymentMode`)values(?,?,?,?,?)";
	private final static  String SELECT_ALL_QUERY="Select * from `ordertable`";
	private final static String SELECT_QUERY=" Select * from `ordertable` where `OrderId`=?";
	
	private Connection connection;


    
	public OrdertableDaoImpl() {

		this.connection = DBUtils.myconnect();	
		System.out.println("in ordertable constructor "+connection);
	}
	@Override
	public int addOrder(Ordertable ordertable) {
		int status = 0;
		
		Statement statement=null;
		
	int	generatedOrderId = 0;
		PreparedStatement prepareStatement =null;
		try {
			prepareStatement=connection.prepareStatement(INSERT_QUERY, statement.RETURN_GENERATED_KEYS);
			prepareStatement.setInt(1,ordertable.getRestaurantId());
			prepareStatement.setInt(2,ordertable.getUserId());
			prepareStatement.setFloat(3,ordertable.getTotalAmount());
			prepareStatement.setString(4,ordertable.getStatus());
			prepareStatement.setString(5,ordertable.getPaymentMode());
		    status=	prepareStatement.executeUpdate();
		    if(status>0)
		    {
		  try (ResultSet rs = prepareStatement.getGeneratedKeys()) {
		                if (rs.next()) {
		                    generatedOrderId = rs.getInt(1);
		                    System.out.println(generatedOrderId);
		                }
		            }
		        }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return generatedOrderId;
	}
	@Override
	public List<Ordertable> getAllOrders() {
		ArrayList<Ordertable> ordertableList=new ArrayList<Ordertable>();
		Statement statement=null;
		ResultSet res=null;
		 Ordertable ordertable=null;
		try {
			statement=connection.createStatement();
			res=statement.executeQuery(SELECT_ALL_QUERY);
		  while (res.next())
			{
			    int OrderId =res.getInt("OrderId");
			    int RestaurantId=res.getInt("RestaurantId");
				int UserId =res.getInt("UserId");
				Date OrderDate =res.getDate("OrderDate");
				float TotalAmount =res.getFloat("TotalAmount");
				String Status=res.getString("Status");
				String PaymentMode =res.getString("PaymentMode");
		  ordertable = new Ordertable (OrderId,RestaurantId,UserId,OrderDate,TotalAmount,Status,PaymentMode);
				ordertableList.add(ordertable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ordertableList;

	}
	@Override
	public Ordertable getOrder(int OrderId) {
		PreparedStatement prepareStatement =null;
		ResultSet res=null;
		Ordertable ordertable=null;
		
		try {
			prepareStatement =connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1,OrderId);
			res= prepareStatement.executeQuery();
			if(res.next())
			{
				    int RestaurantId=res.getInt("RestaurantId");
					int UserId =res.getInt("UserId");
					Date OrderDate =res.getDate("OrderDate");
					float TotalAmount =res.getFloat("TotalAmount");
					String Status=res.getString("Status");
					String PaymentMode =res.getString("PaymentMode");
			     ordertable = new Ordertable (OrderId,RestaurantId,UserId,OrderDate,TotalAmount,Status,PaymentMode);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ordertable;
	}
}
