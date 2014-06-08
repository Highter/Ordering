package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.JdbcUtil;
import bean.Custom;
import bean.Rest_message;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.IRest_message;

public class Rest_messageDaoImpl implements IRest_message {

	@Override
	public boolean addRest_message(Rest_message rest_message) {
		//获取表的记录数量
		String sql = "select max(Message_ID) from Rest_message";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int rows = 0;		
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
		
		
		
		rest_message.setMessage_ID(rows+1);
		
		
		sql = "insert into Rest_message values (?,?,?,?,?)";
		
		try {
		  ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, rest_message.getMessage_ID());
			ps.setInt(2, rest_message.getCustom_ID());
			ps.setInt(3,rest_message.getRest_ID());
			ps.setString(4, new Date().toString());
			ps.setString(5, rest_message.getMessage());
			ps.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public boolean deleteRest_message(int Message_ID) {
		String sql = "delete from Rest_message where Message_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Custom temp = null;
		
			try {
				ps = (PreparedStatement) conn.prepareStatement(sql);
				
				ps.setInt(1, Message_ID);
				boolean isDelete = ps.execute();
				return isDelete;
				
			} catch (SQLException e) {
				
				
				return false;
				
			}			
	}

	@Override
	public Rest_message getRest_message(int Message_ID) {
		String sql = "select * from Rest_message where Message_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Rest_message temp = null;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Message_ID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new Rest_message();
				temp.setMessage_ID(rs.getInt(1));
				temp.setCustom_ID(rs.getInt(2));
				temp.setRest_ID(rs.getInt(3));
				temp.setTime(rs.getString(4));
				temp.setMessage(rs.getString(5));
				return temp;
			}
			
			return null;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}

	@Override
	public List<Rest_message> getCustom_Rest_messages(int custom_ID) {
		
		String sql = "select * from Rest_message where custom_ID =?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Rest_message temp = null;
		List<Rest_message> all = new ArrayList<Rest_message>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, custom_ID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				
				temp = new Rest_message();
				temp.setMessage_ID(rs.getInt(1));
				temp.setCustom_ID(rs.getInt(2));
				temp.setRest_ID(rs.getInt(3));
				temp.setTime(rs.getString(4));
				temp.setMessage(rs.getString(5));
				all.add(temp);
			}
			
			return all;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}

	@Override
	public List<Rest_message> getRestaurant_messages(int Rest_ID) {
		String sql = "select * from Rest_message where Rest_ID =?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Rest_message temp = null;
		List<Rest_message> all = new ArrayList<Rest_message>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Rest_ID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new Rest_message();
				temp.setMessage_ID(rs.getInt(1));
				temp.setCustom_ID(rs.getInt(2));
				temp.setRest_ID(rs.getInt(3));
				temp.setTime(rs.getString(4));
				temp.setMessage(rs.getString(5));
				System.out.println("11"+temp);
				all.add(temp);
			}
			
			return all;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}

	@Override
	public List<Rest_message> getRest_messages() {
		String sql = "select * from Rest_message";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Rest_message temp = null;
		List<Rest_message> all = new ArrayList<Rest_message>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next())
			{
	
				temp = new Rest_message();
				temp.setMessage_ID(rs.getInt(1));
				temp.setCustom_ID(rs.getInt(2));
				temp.setRest_ID(rs.getInt(3));
				temp.setTime(rs.getString(4));
				temp.setMessage(rs.getString(5));
				all.add(temp);
			}
			
			return all;
		} catch (SQLException e) {
			return null;
			
		}
	}
	
	
	public static void main(String[] args) {
		
		Rest_messageDaoImpl test = new Rest_messageDaoImpl();
//		Rest_message rest_message = new Rest_message();
//		rest_message.setTime(new java.util.Date());
//		rest_message.setCustom_ID(1);
//		rest_message.setRest_ID(1);
//		
//		test.addRest_message(rest_message);
		
		
//		test.deleteRest_message(9);
//		System.out.println(test.getRest_message(1));
		
//		System.out.println(test.getCustom_Rest_messages(1));
		
		
		
//		System.out.println(test.getRestaurant_messages(3));
		
		System.out.println(test.getRest_messages());
		
	}
	

}
