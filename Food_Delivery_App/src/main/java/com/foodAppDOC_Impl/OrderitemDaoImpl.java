package com.foodAppDOC_Impl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.JDBC.DBUtils;
import com.foodAppDOC.OrderitemDao;
import com.foodAppModule.Orderitem;


public class OrderitemDaoImpl implements OrderitemDao {
	private final static String INSERT_QUERY ="Insert into `orderitem`(`OrderId`,`MenuId`,`Quantity`,`SubTotal`)values(?,?,?,?)";
	private final static  String SELECT_ALL_QUERY="Select * from `orderitem`";
	private final static String SELECT_QUERY=" Select * from `orderitem` where `OrderItemId`=?";
	
	private Connection connection;
    
	public OrderitemDaoImpl() {
		this.connection = DBUtils.myconnect();	
		System.out.println("in orderitem constructor "+connection);
	}

	@Override
	public int addOrderitem(Orderitem orderitem) {
		int status = 0;
		PreparedStatement prepareStatement =null;
		try {
			prepareStatement=connection.prepareStatement(INSERT_QUERY);
			prepareStatement.setInt(1,orderitem.getOrderId());
			prepareStatement.setInt(2,orderitem.getMenuId());
			prepareStatement.setInt(3,orderitem.getQuantity());
			prepareStatement.setFloat(4,orderitem.getSubTotal());
		    status=	prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return status;
	}

	@Override
	public List<Orderitem> getAllOrderitems() {
		ArrayList<Orderitem> orderitemList =new ArrayList<Orderitem>();
		Statement statement=null;
		ResultSet res=null;
		Orderitem orderitem=null;
		try {
			statement=connection.createStatement();
			res=statement.executeQuery(SELECT_ALL_QUERY);
		  while (res.next())
			{
			    int OrderItemId =res.getInt("OrderItemId");
			    int OrderId=res.getInt("OrderId");
				int MenuId =res.getInt("MenuId");
				int Quantity =res.getInt("Quantity");
				float SubTotal =res.getFloat("SubTotal");
				orderitem = new Orderitem (OrderItemId,OrderId,MenuId,Quantity,SubTotal);
				orderitemList.add(orderitem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderitemList;

	}

	@Override
	public Orderitem getOrder(int OrderId) {
		Orderitem orderitem=null;
		PreparedStatement prepareStatement =null;
		ResultSet res=null;
		try {
			prepareStatement =connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, OrderId);
			res= prepareStatement.executeQuery();
			if(res.next())
			{
			    int OrderItemId=res.getInt("OrderItemId");
				int MenuId =res.getInt("MenuId");
				int Quantity =res.getInt("Quantity");
				float SubTotal =res.getFloat("SubTotal");
				orderitem = new Orderitem (OrderItemId,OrderId,MenuId,Quantity,SubTotal);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderitem;
	}
}
