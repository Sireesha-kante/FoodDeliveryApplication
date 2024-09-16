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
import com.foodAppDOC.OrderHistoryDao;

import com.foodAppModule.OrderHistory;


public class OrderHistoryDaoImpl implements OrderHistoryDao {
	private final static String INSERT_QUERY ="Insert into `orderhistory`(`OrderId`,`UserId`,`TotalAmount`,`Status`)values(?,?,?,?)";
	private final static  String SELECT_ALL_QUERY="Select * from `orderhistory`";
	private final static String SELECT_QUERY=" Select * from `orderhistory` where `UserId`=?";
	
	private Connection connection;
	
	
    
	public OrderHistoryDaoImpl() {
		this.connection = DBUtils.myconnect();	
		System.out.println("in orderHistory constructor "+connection);
	}

	@Override
	public int addOrderHistory(OrderHistory orderhistory) {
		PreparedStatement preparestatement=null;
			 int status=0;
			// int generatedOrderId=0;
		try {
			preparestatement=connection.prepareStatement(INSERT_QUERY);
			preparestatement.setInt(1,orderhistory.getOrderId());
			preparestatement.setInt(2,orderhistory.getUserId());
			preparestatement.setFloat(3,orderhistory.getTotalAmount());
			preparestatement.setString(4,orderhistory.getStatus());
		    status=	preparestatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return status;
	}

	@Override
	public List<OrderHistory> getAllOrderHistorys() {
		ResultSet res=null;
	    Statement statement=null;
	    OrderHistory  orderhistory =null;
		ArrayList<OrderHistory> orderhistoryList=new ArrayList<OrderHistory>();
		try {
			statement=connection.createStatement();
			res=statement.executeQuery(SELECT_ALL_QUERY);
		  while (res.next())
			{
			    int OrderHistoryId =res.getInt("OrderHistoryId");
			    int OrderId=res.getInt("OrderId");
				int UserId =res.getInt("UserId");
				Date OrderDate =res.getDate("OrderDate");
				float TotalAmount =res.getFloat("TotalAmount");
				String Status =res.getString("Status");
				orderhistory = new OrderHistory (OrderHistoryId,OrderId,UserId,OrderDate,TotalAmount,Status);
				orderhistoryList.add(orderhistory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderhistoryList ;
	}

	@Override
	public List<OrderHistory> getOrderHistory(int UserId) {
		PreparedStatement preparestatement=null;
    	ResultSet res=null;
	    Statement statement=null;
	    OrderHistory orderhistory =null;
	    ArrayList<OrderHistory> orderhistoryList=new ArrayList<OrderHistory>();
		try {
			preparestatement =connection.prepareStatement(SELECT_QUERY);
			preparestatement.setInt(1,UserId);
			res= preparestatement.executeQuery();
			while(res.next())
			{
				int OrderId=res.getInt("OrderId");
				int OrderHistoryId =res.getInt("OrderHistoryId");
				Date OrderDate =res.getDate("OrderDate");
				float TotalAmount =res.getFloat("TotalAmount");
				String Status =res.getString("Status");
				OrderHistory  orderHistory = new OrderHistory (OrderHistoryId,OrderId,UserId,OrderDate,TotalAmount,Status);
				orderhistoryList.add(orderHistory);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderhistoryList;
	}
	
}
