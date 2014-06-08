package dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.JdbcUtil;
import bean.Restaurant;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.IRestaurant;

public class RestaurantDaoImpl implements IRestaurant {

	@Override
	public boolean addRestaurant(Restaurant restaurant) {
		String sql = "select max(Rest_ID) from restaurant";
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
		
		
		
		restaurant.setRest_ID(rows+1);
		
		
		sql = "insert into restaurant values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
		  ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, restaurant.getRest_ID());
			ps.setInt(2, restaurant.getDish_Style_ID());
			ps.setString(3, restaurant.getRest_Name());
			ps.setInt(4, restaurant.getRest_CEO_ID());
			ps.setString(5, restaurant.getRest_phone());
			ps.setString(6, restaurant.getRest_Address());
			ps.setString(7, restaurant.getRest_Photo());
			ps.setString(8, restaurant.getRemark());
			ps.setString(9, new Date().toString());
			ps.setString(10,new Date().toString());
			ps.setInt(11, restaurant.getVnum());
			ps.setInt(12, restaurant.getVnum());

			ps.execute();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteRestaurant(int Rest_ID) {
		String sql = "delete from Restaurant where Rest_ID = ?";
		Connection conn  = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Rest_ID);
			boolean isDelete  = ps.execute();
			return isDelete;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean updateRestaurant(int Rest_ID) {
		
		
			return false;
	}

	@Override
	public Restaurant getRestaurant(int Rest_ID) {
		String sql = "select * from Restaurant where Rest_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Restaurant temp = new Restaurant();
		temp.setDish_Style_ID(Rest_ID);
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Rest_ID);
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				temp.setRest_ID(rs.getInt(1));
				temp.setDish_Style_ID(rs.getInt(2));
				temp.setRest_Name(rs.getString(3));
				temp.setRest_CEO_ID(rs.getInt(4));
				temp.setRest_phone(rs.getString(5));
				temp.setRest_Address(rs.getString(6));
				temp.setRest_Photo(rs.getString(7));
				temp.setRemark(rs.getString(8));
				temp.setRegtime(rs.getString(9));
				temp.setModifedtime(rs.getString(10));
				temp.setVnum(rs.getInt(11));
				temp.setStatus(rs.getInt(12));
				
			}
			return temp;
		} catch (SQLException e) {
			
			return null;
		}
	}

	@Override
	public List<Restaurant> getDishStyle_Restaurants(int Dish_Style_ID) {
		String sql = "select * from Restaurant where Dish_Style_ID =?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Restaurant temp =null;
		List<Restaurant> all = new ArrayList<Restaurant>();
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Dish_Style_ID);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				temp = new Restaurant();
				temp.setRest_ID(rs.getInt(1));
				temp.setDish_Style_ID(rs.getInt(2));
				temp.setRest_Name(rs.getString(3));
				temp.setRest_CEO_ID(rs.getInt(4));
				temp.setRest_phone(rs.getString(5));
				temp.setRest_Address(rs.getString(6));
				temp.setRest_Photo(rs.getString(7));
				temp.setRemark(rs.getString(8));
				temp.setRegtime(rs.getString(9));
				temp.setModifedtime(rs.getString(10));
				temp.setVnum(rs.getInt(11));
				temp.setStatus(rs.getInt(12));
				all.add(temp);
			}
			return all;
		} catch (SQLException e) {
			
			return null;
		}
	}

	@Override
	public List<Restaurant> getRestaurants() {
		String sql = "select * from Restaurant";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Restaurant temp =null;
		List<Restaurant> all = new ArrayList<Restaurant>();
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				temp = new Restaurant();
				temp.setRest_ID(rs.getInt(1));
				temp.setDish_Style_ID(rs.getInt(2));
				temp.setRest_Name(rs.getString(3));
				temp.setRest_CEO_ID(rs.getInt(4));
				temp.setRest_phone(rs.getString(5));
				temp.setRest_Address(rs.getString(6));
				temp.setRest_Photo(rs.getString(7));
				temp.setRemark(rs.getString(8));
				temp.setRegtime(rs.getString(9));
				temp.setModifedtime(rs.getString(10));
				temp.setVnum(rs.getInt(11));
				temp.setStatus(rs.getInt(12));
				all.add(temp);
			}
			return all;
		} catch (SQLException e) {
			
			return null;
		}
	}
	@Override
	public List<Restaurant> getHotRestaurants() {
	return null;
	}
	
	@Override
	public boolean updateRestaurant(Restaurant rest) {
//		System.out.println("dao"+rest.getRest_ID());
//		System.out.println("dao"+rest.getRest_CEO_ID());
//		System.out.println("dao"+rest.getRest_Address());
//		System.out.println("dao"+rest.getRest_phone());
		String sql ="update restaurant  set Rest_phone=? ,Rest_Address=? where Rest_CEO_ID =?";
		  Connection conn = (Connection) JdbcUtil.getConn();
			PreparedStatement ps = null;
			try {
				ps =  (PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1, rest.getRest_phone());
				ps.setString(2, rest.getRest_Address());
				ps.setInt(3, rest.getRest_CEO_ID());
				ps.execute();
				return true;
			} catch (SQLException e) {
				return false;
			}
	}
	
	
	
	public static void main(String[] args) {
	 RestaurantDaoImpl test  = new RestaurantDaoImpl();
//	 Restaurant restaurant = new Restaurant();
//	 restaurant.setDish_Style_ID(3);
//	 restaurant.setRegtime(new java.util.Date());
//	 restaurant.setModifedtime(new java.util.Date());
//	 test.addRestaurant(restaurant);
	 
//	 test.deleteRestaurant(6);
	 
//	 System.out.println(test.getRestaurant(4));
	 
	 
//	 System.out.println(test.getRestaurants());
//	 System.out.println(test.getDishStyle_Restaurants(3));
	 List<Restaurant> all = test.getHotRestaurants();
	 for(int i =0;i<all.size();i++)
	 {
		 System.out.println(all.get(i).getRest_ID()); 
	 }
	
	
	 
	}

	@Override
	public Restaurant getRestaurantByCEO(int Rest_CEO_ID) {
		String sql = "select * from Restaurant where Rest_CEO_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Restaurant temp = new Restaurant();
//		temp.setDish_Style_ID(Rest_CEO_ID);
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Rest_CEO_ID);
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				temp.setRest_ID(rs.getInt(1));
				temp.setDish_Style_ID(rs.getInt(2));
				temp.setRest_Name(rs.getString(3));
				temp.setRest_CEO_ID(rs.getInt(4));
				temp.setRest_phone(rs.getString(5));
				temp.setRest_Address(rs.getString(6));
				temp.setRest_Photo(rs.getString(7));
				temp.setRemark(rs.getString(8));
				temp.setRegtime(rs.getString(9));
				temp.setModifedtime(rs.getString(10));
				temp.setVnum(rs.getInt(11));
				temp.setStatus(rs.getInt(12));
				
			}
			return temp;
		} catch (SQLException e) {
			
			return null;
		}
	}

	@Override
	public Restaurant getRestaurantByName(String name) {
		String sql = "select * from Restaurant where Rest_Name =?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Restaurant temp =null;
		
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			if(rs.next())
			{
				temp = new Restaurant();
				temp.setRest_ID(rs.getInt(1));
				temp.setDish_Style_ID(rs.getInt(2));
				temp.setRest_Name(rs.getString(3));
				temp.setRest_CEO_ID(rs.getInt(4));
				temp.setRest_phone(rs.getString(5));
				temp.setRest_Address(rs.getString(6));
				temp.setRest_Photo(rs.getString(7));
				temp.setRemark(rs.getString(8));
				temp.setRegtime(rs.getString(9));
				temp.setModifedtime(rs.getString(10));
				temp.setVnum(rs.getInt(11));
				temp.setStatus(rs.getInt(12));
				
			}
			return temp;
		} catch (SQLException e) {
			
			return null;
		}
	}


}
