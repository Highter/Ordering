package dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.JdbcUtil;
import bean.Custom;
import bean.Order_list;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.IOrder_list;

public class Order_listDaoImpl implements IOrder_list {

	@Override
	public long addOrder_list(Order_list order_list) {
		String sql = "select max(Order_ID) from order_list";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		long rows = 0;		
		try { 
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
			  
			while (rs.next()) { 
				rows += rs.getInt(1); 
				System.out.println("rows"+rows);
			} 
		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		order_list.setOrder_ID(rows+1);
		
		
		
		sql = "insert into order_list values (?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
		  ps = (PreparedStatement) conn.prepareStatement(sql);
		  
		  ps.setLong(1, order_list.getOrder_ID());
		  ps.setInt(2, order_list.getCustom_ID());
		  ps.setDouble(3, order_list.getSum_Price());
		  ps.setInt(4, order_list.getRestaurant_ID());
		  ps.setString(5, order_list.getAddress());
		  ps.setString(6, order_list.getPhone());
		  
		  ps.setString(7, new Date().toString());
		  ps.setInt(8, order_list.getOrder_Condition());
		  ps.setString(9, new Date().toString());
		  ps.setString(10,  new Date().toString());
		  ps.setInt(11, order_list.getVnum());
		  
		  //			ps.setInt(1, custom.getCustom_ID());
//			ps.setString(2, custom.getLogin_name());
//			ps.setString(3, custom.getCustom_password());
//			ps.setString(4, custom.getCustom_Name());
//			ps.setInt(5, custom.getCustom_sex());
//			ps.setInt(6, custom.getCustom_age());
//			ps.setString(7, custom.getPerson_ID());
//			ps.setString(8, custom.getAddress());
//			ps.setString(9, custom.getPhone());
//			ps.setString(10,custom.getEmail());
//			ps.setString(11, custom.getQQ());
//			ps.setInt(12, custom.getRole());
//			ps.setString(13, custom.getRegtime());
//			ps.setString(14, custom.getModifedtime());
//			ps.setInt(15, custom.getVnum());
//			ps.setInt(16, custom.getStatus());
			ps.execute();
			
		} catch (SQLException e) {
			
			return rows;
		}
		return rows;
	}

	@Override
	public boolean deleteOrder_list(long Order_ID) {
		String sql = "delete from Order_list where Order_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Custom temp = null;
		
			try {
				ps = (PreparedStatement) conn.prepareStatement(sql);
				
				ps.setLong(1, Order_ID);
				boolean isDelete = ps.execute();
				return isDelete;
				
			} catch (SQLException e) {
				
				
				return false;
				
			}		
	}

	@Override
	public boolean updateOrder_list(long Order_ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order_list getOrder_list(long Order_ID) {
		String sql = "select * from Order_list where Order_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order_list temp = null;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setLong(1, Order_ID);
			rs = ps.executeQuery();
			if(rs.next())
			{
				temp = new Order_list();
				
				temp.setOrder_ID(rs.getInt(1));
				temp.setCustom_ID(rs.getInt(2));		
				temp.setSum_Price(rs.getDouble(3));
				temp.setRestaurant_ID(rs.getInt(4));
				
				temp.setAddress(rs.getString(5));			
				temp.setPhone(rs.getString(6));
				temp.setOrder_Time(rs.getString(7));
				temp.setOrder_Condition(rs.getInt(8));
				temp.setRegtime(rs.getString(9));
				temp.setModifedtime(rs.getString(10));
				temp.setVnum(rs.getInt(11));
				
				return temp;
			}
			
			return null;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}

	@Override
	public List<Order_list> getRestaurant_Order_lists(int Rest_ID) {
		String sql = "select * from Order_list where  Restaurant_ID = ?";
		System.out.println("daoing");
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order_list temp = null;
		List<Order_list> all = new ArrayList<Order_list>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Rest_ID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new Order_list();
				
				temp.setOrder_ID(rs.getInt(1));
				temp.setCustom_ID(rs.getInt(2));		
				temp.setSum_Price(rs.getDouble(3));
				temp.setRestaurant_ID(rs.getInt(4));
				
				temp.setAddress(rs.getString(5));			
				temp.setPhone(rs.getString(6));
				temp.setOrder_Time(rs.getString(7));
				temp.setOrder_Condition(rs.getInt(8));
				temp.setRegtime(rs.getString(9));
				temp.setModifedtime(rs.getString(10));
				temp.setVnum(rs.getInt(11));
				
				all.add(temp);
			}
			
			return all;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}

	@Override
	public List<Order_list> getCustom_Order_lists(int custom_ID) {
		String sql = "select * from Order_list where  custom_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order_list temp = null;
		List<Order_list> all = new ArrayList<Order_list>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, custom_ID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new Order_list();
				
				temp.setOrder_ID(rs.getInt(1));
				temp.setCustom_ID(rs.getInt(2));		
				temp.setSum_Price(rs.getDouble(3));
				temp.setRestaurant_ID(rs.getInt(4));
				
				temp.setAddress(rs.getString(5));			
				temp.setPhone(rs.getString(6));
				temp.setOrder_Time(rs.getString(7));
				temp.setOrder_Condition(rs.getInt(8));
				temp.setRegtime(rs.getString(9));
				temp.setModifedtime(rs.getString(10));
				temp.setVnum(rs.getInt(11));
				
				all.add(temp);
			}
			
			return all;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}

	@Override
	public List<Order_list> getOrder_lists() {
		String sql = "select * from Order_list ";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order_list temp = null;
		List<Order_list> all = new ArrayList<Order_list>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ps.setLong(1, Order_ID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new Order_list();
				
				temp.setOrder_ID(rs.getInt(1));
				temp.setCustom_ID(rs.getInt(2));		
				temp.setSum_Price(rs.getDouble(3));
				temp.setRestaurant_ID(rs.getInt(4));
				
				temp.setAddress(rs.getString(5));			
				temp.setPhone(rs.getString(6));
				temp.setOrder_Time(rs.getString(7));
				temp.setOrder_Condition(rs.getInt(8));
				temp.setRegtime(rs.getString(9));
				temp.setModifedtime(rs.getString(10));
				temp.setVnum(rs.getInt(11));
				
				all.add(temp);
			}
			
			return all;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}
	public static void main(String[] args) {
		Order_listDaoImpl test  = new Order_listDaoImpl();
//		Order_list list = new Order_list();
//		list.setOrder_Time(new java.util.Date());
//		list.setRegtime(new java.util.Date());
//		list.setModifedtime(new java.util.Date());
//		test.addOrder_list(list);
		
//		test.deleteOrder_list(8);
		
		System.out.println(test.getOrder_lists());
		
	}
}
