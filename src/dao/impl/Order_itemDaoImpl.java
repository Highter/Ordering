package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;
import bean.Custom;
import bean.Order_item;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.IOrder_item;

public class Order_itemDaoImpl implements IOrder_item {

	@Override
	public boolean addOrder_item(Order_item order_item) {
		
		//获取表的最大将记录数
		String sql = "select max(item_id) from Order_item";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rows = 0;
		
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
				rows +=rs.getInt(1);
				System.out.println("rows"+rows);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		order_item.setDish_ID(rows+1);
		
		sql = "insert into Order_item values (?,?,?,?)";
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, rows+1);
			ps.setLong(2, order_item.getOrder_ID());
			ps.setInt(3, order_item.getDish_ID());
			ps.setInt(4, order_item.getDish_number());
			ps.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteOrder_item(int item_ID) {
		String sql = "delete from Order_item where item_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Custom temp = null;
		
			try {
				ps = (PreparedStatement) conn.prepareStatement(sql);
				
				ps.setInt(1, item_ID);
				boolean isDelete = ps.execute();
				return isDelete;
				
			} catch (SQLException e) {
				
				
				return false;
				
			}		
	}

	@Override
	public boolean updateOrder_item(int item_ID) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Order_item getOrder_item(int item_ID) {
		String sql = "select * from Order_item where item_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order_item temp = null;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, item_ID);
			rs = ps.executeQuery();
			if(rs.next())
			{
				temp = new Order_item();
				temp.setDish_ID(rs.getInt(1));
				temp.setOrder_ID(rs.getLong(2));
				temp.setDish_ID(rs.getInt(3));
				temp.setDish_number(rs.getInt(4));
				return temp;
			}
			
			return null;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}

	@Override
	public List<Order_item> getOrder_list_Order_items(int Order_ID) {
		String sql = "select * from Order_item while Order_ID =?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order_item temp = null;
		List<Order_item> all = new ArrayList<Order_item>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Order_ID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new Order_item();
				temp.setDish_ID(rs.getInt(1));
				temp.setOrder_ID(rs.getLong(2));
				temp.setDish_ID(rs.getInt(3));
				temp.setDish_number(rs.getInt(4));
				all.add(temp);
			}
			
			return all;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}

	@Override
	public List<Order_item> getDishMenu_Order_items(int Dish_ID) {
		String sql = "select * from Order_item while Dish_ID =?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order_item temp = null;
		List<Order_item> all = new ArrayList<Order_item>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Dish_ID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new Order_item();
				temp.setDish_ID(rs.getInt(1));
				temp.setOrder_ID(rs.getLong(2));
				temp.setDish_ID(rs.getInt(3));
				temp.setDish_number(rs.getInt(4));
				all.add(temp);
			}
			
			return all;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}

	@Override
	public List<Order_item> getOrder_items() {
		String sql = "select * from Order_item ";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order_item temp = null;
		List<Order_item> all = new ArrayList<Order_item>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);

			rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new Order_item();
				temp.setDish_ID(rs.getInt(1));
				temp.setOrder_ID(rs.getLong(2));
				temp.setDish_ID(rs.getInt(3));
				temp.setDish_number(rs.getInt(4));
				all.add(temp);
			}
			
			return all;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}
	
	public static void main(String[] args) {
		Order_itemDaoImpl test = new Order_itemDaoImpl();
//		Order_item e = new Order_item();
//		e.setOrder_ID(new Long(100));
//		test.addOrder_item((e));
//		test.deleteOrder_item(1);
		System.out.println(test.getOrder_items());
		
	}

}
