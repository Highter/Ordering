package dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import bean.DishStyle;
import dao.IDishStyle;

public class DishStyleDaoImpl implements IDishStyle {

	@Override
	public boolean addishStyle(DishStyle dishStyle) {
		//获取表的记录数量
		String sql = "select max(Dish_Style_ID) from dishStyle";
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
		
		
		
		dishStyle.setDish_Style_ID(rows+1);
		
		
		sql = "insert into dishStyle values (?,?,?,?,?,?)";
		
		try {
		  ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, dishStyle.getDish_Style_ID());
			ps.setString(2, dishStyle.getDish_Style_Name());
			ps.setString(3, dishStyle.getDiscription());
			java.util.Date date  = new java.util.Date();
			ps.setDate(4, new java.sql.Date(date.getTime()));
			ps.setDate(5, new java.sql.Date(date.getTime()));
			ps.setInt(6, dishStyle.getVnum());
			ps.execute();
			return true;
			
		} catch (SQLException e) {
			
			return false;
		}
		
	}

	@Override
	public boolean deleteishStyle(int Dish_Style_ID) {
		String sql = "delete from dishStyle where Dish_Style_ID = ?";
		Connection conn  = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Dish_Style_ID);
			boolean isDelete  = ps.execute();
			return isDelete;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean updateishStyle(int Dish_Style_ID) {
	
		
		return false;
	}

	@Override
	public DishStyle getDishStyle(int Dish_Style_ID) {
		
		
		
		
		String sql = "select * from dishStyle where  Dish_Style_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DishStyle temp = new DishStyle();
		temp.setDish_Style_ID(Dish_Style_ID);
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Dish_Style_ID);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				temp.setDish_Style_Name(rs.getString(2));
				temp.setDiscription(rs.getString(3));
				temp.setRegtime(rs.getString(4));
				temp.setModifedtime(rs.getString(5));
				temp.setVnum(rs.getInt(6));
				
			}
			return temp;
		} catch (SQLException e) {
			
			return null;
		}
	}

	@Override
	public List<DishStyle> getDishStyles() {
		String sql = "select * from dishStyle";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DishStyle temp = null;
		List<DishStyle> all = new ArrayList<DishStyle>();
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				temp = new DishStyle();
				temp.setDish_Style_ID(rs.getInt(1));
				temp.setDish_Style_Name(rs.getString(2));
				temp.setDiscription(rs.getString(3));
				temp.setRegtime(rs.getString(4));
				temp.setModifedtime(rs.getString(5));
				temp.setVnum(rs.getInt(6));	
				all.add(temp);
			}
			return all;
		} catch (SQLException e) {
			
			return null;
		}
	}
	
	
	public static void main(String[] args) {

		DishStyleDaoImpl test = new DishStyleDaoImpl();
//		test.addishStyle(new DishStyle());
//		test.deleteishStyle(2);
//		 System.out.println(test.getDishStyle(5));
		
//		for(DishStyle temp :test.getDishStyles())
//		{
//			System.out.println(temp);
//		}
		
		
	}

}
