package dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.JdbcUtil;
import bean.Custom;
import bean.DishMenu;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.IDishMenu;

public class DishMenuDaoImpl implements IDishMenu {

	@Override
	public boolean addDishMenu(DishMenu dishMenu) {
		String sql = "select max(Dish_ID) from DishMenu";
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
		
		
		
		dishMenu.setDish_ID(rows+1);
		
		
		sql = "insert into DishMenu values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
		  ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, dishMenu.getDish_ID());
			ps.setInt(3,dishMenu.getDish_Style_ID());
			ps.setInt(2, dishMenu.getRest_ID());
			ps.setString(4, dishMenu.getDish_Name());
			ps.setInt(5, dishMenu.getDish_Price());
			ps.setInt(6, dishMenu.getCount_buy());
			ps.setString(7, dishMenu.getDish_Photo());
			ps.setString(8,dishMenu.getRemark());
			ps.setString(9, new Date().toString());
			ps.setString(10,  new Date().toString());
			ps.setInt(11, dishMenu.getVnum());
			ps.setInt(12, dishMenu.getStatus());
			ps.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		return false;
	}

	@Override
	public boolean deleteDishMenu(int Dish_ID) {
		String sql = "delete from DishMenu where Dish_ID = ?";
		System.out.println("deleteDishMenu");
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Custom temp = null;
		
			try {
				ps = (PreparedStatement) conn.prepareStatement(sql);
				
				ps.setInt(1, Dish_ID);
				boolean isDelete = ps.execute();
				return isDelete;
				
			} catch (SQLException e) {

				return false;
				
			}			
	}

	@Override
	public boolean updateDishMenu(int Dish_ID) {

		return false;
	}
	@Override
	public boolean updateDishMenu(DishMenu menu) {
		String sql = "update DishMenu  set Dish_Name=?, Dish_Price=?,Remark=?  where Dish_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DishMenu temp = null;
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, menu.getDish_Name());
			ps.setInt(2, menu.getDish_Price());
			ps.setString(3, menu.getRemark());
			ps.setInt(4, menu.getDish_ID());
			ps.execute();
			System.out.println("dao="+menu);
			return true;
		} catch (SQLException e) {
			return false;
		}
		
		
		
		
		
	}
	@Override
	public DishMenu getDishMenu(int Dish_ID) {
		String sql = "select * from DishMenu where Dish_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DishMenu temp = null;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Dish_ID);
			rs = ps.executeQuery();
			if(rs.next())
			{
				temp = new DishMenu();
				temp.setDish_ID(rs.getInt(1));
				temp.setDish_Style_ID(rs.getInt(3));
				temp.setRest_ID(rs.getInt(2));
				temp.setDish_Name(rs.getString(4));
				
				temp.setDish_Price(rs.getInt(5));
				
				temp.setCount_buy(rs.getInt(6));
				temp.setDish_Photo(rs.getString(7));
				
				temp.setRemark(rs.getString(8));
				temp.setRegtime(rs.getString(9));
				temp.setModifedtime(rs.getString(10));
				temp.setVnum(rs.getInt(11));
				temp.setStatus(rs.getInt(12));
				
				return temp;
			}
			
			return null;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}

	@Override
	public List<DishMenu> getRestaurant_DishMenus(int Rest_ID) {
		String sql = "select * from DishMenu where Rest_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DishMenu temp = null;
		List<DishMenu> all = new ArrayList<DishMenu>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Rest_ID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new DishMenu();
				temp.setDish_ID(rs.getInt(1));
				temp.setRest_ID(rs.getInt(2));
				temp.setDish_Style_ID(rs.getInt(3));
				temp.setDish_Name(rs.getString(4));
				
				temp.setDish_Price(rs.getInt(5));
				
				temp.setCount_buy(rs.getInt(6));
				temp.setDish_Photo(rs.getString(7));
				
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
	public List<DishMenu> getDishStyle_DishMenus(int Dish_Style_ID) {
		String sql = "select * from DishMenu where Dish_Style_ID = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DishMenu temp = null;
		List<DishMenu> all = new ArrayList<DishMenu>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Dish_Style_ID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new DishMenu();
				temp.setDish_ID(rs.getInt(1));
				temp.setDish_Style_ID(rs.getInt(3));
				temp.setRest_ID(rs.getInt(2));
				temp.setDish_Name(rs.getString(4));
				
				temp.setDish_Price(rs.getInt(5));
				
				temp.setCount_buy(rs.getInt(6));
				temp.setDish_Photo(rs.getString(7));
				
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
	public List<DishMenu> getDishMenus() {
		String sql = "select * from DishMenu";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DishMenu temp = null;
		List<DishMenu> all = new ArrayList<DishMenu>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ps.setInt(1, Dish_Style_ID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new DishMenu();
				temp.setDish_ID(rs.getInt(1));
				temp.setRest_ID(rs.getInt(2));
				temp.setDish_Style_ID(rs.getInt(3));
				temp.setDish_Name(rs.getString(4));
				
				temp.setDish_Price(rs.getInt(5));
				
				temp.setCount_buy(rs.getInt(6));
				temp.setDish_Photo(rs.getString(7));
				
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
	public List<DishMenu> getDishMenuByOrder() {
		String sql = "select * from DishMenu order by count_buy desc limit 3";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DishMenu temp = null;
		List<DishMenu> all = new ArrayList<DishMenu>();
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ps.setInt(1, Dish_Style_ID);
			rs = ps.executeQuery();
			while(rs.next())
			{
				temp = new DishMenu();
				temp.setDish_ID(rs.getInt(1));
				temp.setRest_ID(rs.getInt(2));
				temp.setDish_Style_ID(rs.getInt(3));
				temp.setDish_Name(rs.getString(4));
				
				temp.setDish_Price(rs.getInt(5));
				
				temp.setCount_buy(rs.getInt(6));
				temp.setDish_Photo(rs.getString(7));
				
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
	public static void main(String[] args) {
		
		DishMenuDaoImpl test = new DishMenuDaoImpl();
//		DishMenu d = new DishMenu();
//		d.setRest_ID(1);
//		d.setDish_ID(3);
//		d.setRegtime(new java.util.Date());
//		d.setModifedtime(new java.util.Date());
//		test.addDishMenu(d);
		
//		test.deleteDishMenu(8);
		
//		System.out.println(test.getDishMenu(1));
		
		
		
		System.out.println(test.getRestaurant_DishMenus(0));
		
		
//		System.out.println(test.getDishMenus());
		
		
//		List<DishMenu> dish = test.getDishMenuByOrder();
//		System.out.println(dish);
//		System.out.println(dish.size());

		
	}

	@Override
	public DishMenu getDishMenu(String DishName) {
		String sql = "select * from DishMenu where Dish_Name = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DishMenu temp = null;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, DishName);
			rs = ps.executeQuery();
			if(rs.next())
			{
				temp = new DishMenu();
				temp.setDish_ID(rs.getInt(1));
				temp.setDish_Style_ID(rs.getInt(3));
				temp.setRest_ID(rs.getInt(2));
				temp.setDish_Name(rs.getString(4));
				
				temp.setDish_Price(rs.getInt(5));
				
				temp.setCount_buy(rs.getInt(6));
				temp.setDish_Photo(rs.getString(7));
				
				temp.setRemark(rs.getString(8));
				temp.setRegtime(rs.getString(9));
				temp.setModifedtime(rs.getString(10));
				temp.setVnum(rs.getInt(11));
				temp.setStatus(rs.getInt(12));
				
				return temp;
			}
			
			return null;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}


}
