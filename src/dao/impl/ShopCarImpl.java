package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.JdbcUtil;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import bean.ShoppingCar;
import bean.ShoppingCarDateBase;
import dao.IShopCar;

public class ShopCarImpl implements IShopCar {

	@Override
	public long addShopCar(ShoppingCarDateBase shopcar) {
		String sql = "select max(id) from shopcar";
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
		
		
		
		 shopcar.setId(rows+1);
		
		
		sql = "insert into shopcar values (?,?,?,?,?,?,?,?)";
		
		try {
		  ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setLong(1, shopcar.getId());
			ps.setInt(2,shopcar.getCustom_id());
			ps.setInt(3, shopcar.getCustom_car().getDishId());
			ps.setInt(4, shopcar.getCustom_car().getPrice());
			ps.setString(5, shopcar.getCustom_car().getRestName());
			ps.setInt(6,shopcar.getCustom_car().getCount());
			ps.setString(7,shopcar.getCustom_car().getPhoto());
			ps.setString(8, shopcar.getCustom_car().getRemark());
			ps.execute();
			return rows;
		} catch (SQLException e) {
			
			return rows;
		}
		
	}

	@Override
	public List<ShoppingCar> getShopCars(int custom_id) {
		String sql = "select * from shopcar where Custom_id=?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<ShoppingCar> all = new ArrayList<ShoppingCar>();
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, custom_id);
			rs = ps.executeQuery();
			while(rs.next())
			{
				
				ShoppingCar car = new ShoppingCar();
				car.setDishId(rs.getInt(3));
				car.setPrice(rs.getInt(4));
				car.setDishName(rs.getString(5));
				car.setCount(rs.getInt(6));
				car.setPhoto(rs.getString(7));
				car.setRemark(rs.getString(8));
				all.add(car);
			}
			return all;
			
		} catch (SQLException e) {
			
			return null;
		}
	}
	
	@Override
	public boolean deleteShopCar(int custom_id) {
		String sql = "delete from shopcar where Custom_id=?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, custom_id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) {
		ShopCarImpl shop = new ShopCarImpl();
		
		
//		ShoppingCarDateBase shopcar = new ShoppingCarDateBase();
//		ShoppingCar te = new ShoppingCar();
//		shopcar.setCustom_car(te);
//		shop.addShopCar(shopcar);
		
		
//		List<ShoppingCarDateBase> all = shop.getShopCars(0);
//		System.out.println(all);
		
		
//		shop.deleteShopCar(11);
		
	}



}
