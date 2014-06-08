package dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.JdbcUtil;
import bean.Custom;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dao.ICustom;

public class CustomDaoImpl implements ICustom {

	@Override
	public boolean addCustom(Custom custom) {
		
		//获取表的记录数量
		String sql = "select max(custom_id) from Custom";
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
		
		
		
		custom.setCustom_ID(rows+1);
		
		
		sql = "insert into Custom values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
		  ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, custom.getCustom_ID());
			ps.setString(2, custom.getLogin_name());
			ps.setString(3, custom.getCustom_password());
			ps.setString(4, custom.getCustom_Name());
			ps.setInt(5, custom.getCustom_sex());
			ps.setInt(6, custom.getCustom_age());
			ps.setString(7, custom.getPerson_ID());
			ps.setString(8, custom.getAddress());
			ps.setString(9, custom.getPhone());
			ps.setString(10,custom.getEmail());
			ps.setString(11, custom.getQQ());
			ps.setInt(12, custom.getRole());
			//ps.setString(13, custom.getRegtime());
			ps.setString(13, new Date().toString());
			//ps.setString(14, custom.getModifedtime());
			ps.setString(14, new Date().toString());
			ps.setInt(15, custom.getVnum());
			ps.setInt(16, custom.getStatus());
			ps.execute();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}

	@Override
	public boolean deleteCustom(int custom_id) {
		String sql = "delete from custom where custom_id = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Custom temp = null;
		
			try {
				ps = (PreparedStatement) conn.prepareStatement(sql);
				
				ps.setInt(1, custom_id);
				boolean isDelete = ps.execute();
				return isDelete;
				
			} catch (SQLException e) {
				
				
				return false;
				
			}			
	}



	@Override
	public Custom getCustom(int custom_id) {
		String sql = "select * from custom where custom_id = ?";
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Custom temp = null;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, custom_id);
			rs = ps.executeQuery();
			if(rs.next())
			{
				temp = new Custom();
				temp.setCustom_ID(rs.getInt(1));		
				temp.setLogin_name(rs.getString(2));
				temp.setCustom_password(rs.getString(3));
				temp.setCustom_Name(rs.getString(4));
				temp.setCustom_sex(rs.getInt(5));			
				temp.setCustom_age(rs.getInt(6));
				temp.setPerson_ID(rs.getString(7));
				temp.setAddress(rs.getString(8));			
				temp.setPhone(rs.getString(9));
				temp.setEmail(rs.getString(10));
				temp.setQQ(rs.getString(11));
				temp.setRole(rs.getInt(12));
				temp.setRegtime(rs.getString(13));
				temp.setModifedtime(rs.getString(14));
				temp.setVnum(rs.getInt(15));
				temp.setStatus(rs.getInt(16));
				return temp;
			}
			
			return null;
		} catch (SQLException e) {
			
			
			return null;
			
		}
	}
	@Override
	public List<Custom> getCustomLists(int Role) {
		String sql ="select * from Custom  where Role = ?";
		if(Role<0||Role>2)
		{
			return null;
		}
		
		Connection conn = (Connection) JdbcUtil.getConn();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<Custom> getAll = new ArrayList<Custom>();
		Custom temp = null;
		int rows = 0;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, Role);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				temp = new Custom();
				temp.setCustom_ID(rs.getInt(1));
				temp.setLogin_name(rs.getString(2));
				temp.setCustom_password(rs.getString(3));
				temp.setCustom_Name(rs.getString(4));
				temp.setCustom_sex(rs.getInt(5));
				temp.setCustom_age(rs.getInt(6));
				temp.setPerson_ID(rs.getString(7));
				temp.setAddress(rs.getString(8));
				temp.setPhone(rs.getString(9));
				temp.setEmail(rs.getString(10));
				temp.setQQ(rs.getString(11));
				temp.setRole(rs.getInt(12));
				temp.setRegtime(rs.getString(13));
				temp.setModifedtime(rs.getString(14));
				temp.setVnum(rs.getInt(15));
				temp.setStatus(rs.getInt(16));
				getAll.add(temp);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, ps, conn);
		}
		
		return getAll;
	}
	
	
	@Override
	public boolean updateCustomRole(int custom_id) {
		String sql ="update custom  set Role = 1   where  custom_id =?";
        Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, custom_id);
			ps.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	
	@Override
	public boolean updateCustom(Custom cus) {
		String sql ="update custom  set login_name=?, custom_password=?, custom_Name=?,custom_sex=? ,custom_age=?,person_ID=?,Address=?,Phone=?,Email=?,QQ=? where  custom_id =?";
		System.out.println("updateCustom");
		Connection conn = (Connection) JdbcUtil.getConn();
		PreparedStatement ps = null;
		
		
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, cus.getLogin_name());
			ps.setString(2, cus.getCustom_password());
			ps.setString(3, cus.getCustom_Name());
			ps.setInt(4, cus.getCustom_sex());
			ps.setInt(5, cus.getCustom_age());
			ps.setString(6, cus.getPerson_ID());
			ps.setString(7, cus.getAddress());
			ps.setString(8, cus.getPhone());
			ps.setString(9, cus.getEmail());
			ps.setString(10, cus.getQQ());
			ps.setInt(11, cus.getCustom_ID());
			ps.execute();
			return true;
		} catch (SQLException e) {
			
			return false;
		}
		
		
		
	}
public static void main(String[] args) {
	CustomDaoImpl test = new CustomDaoImpl();
	List<Custom>  temp = test.getCustomLists(1);
	
	for(Custom c:temp)
	{
		System.out.println(c);
	}
//	Custom e = new Custom();
//	test.addCustom(e);
//	e = test.getCustom(1);
//	System.out.println(e);
//	test.deleteCustom(4);
	
}

@Override
public Custom getCustom(String Login_name) {
	String sql = "select * from custom where  login_name= ?";
	Connection conn = (Connection) JdbcUtil.getConn();
	PreparedStatement ps = null;
	ResultSet rs = null;
	Custom temp = null;
	try {
		ps = (PreparedStatement) conn.prepareStatement(sql);
		ps.setString(1, Login_name);
		rs = ps.executeQuery();
		if(rs.next())
		{
			temp = new Custom();
			temp.setCustom_ID(rs.getInt(1));		
			temp.setLogin_name(rs.getString(2));
			temp.setCustom_password(rs.getString(3));
			temp.setCustom_Name(rs.getString(4));
			temp.setCustom_sex(rs.getInt(5));			
			temp.setCustom_age(rs.getInt(6));
			temp.setPerson_ID(rs.getString(7));
			temp.setAddress(rs.getString(8));			
			temp.setPhone(rs.getString(9));
			temp.setEmail(rs.getString(10));
			temp.setQQ(rs.getString(11));
			temp.setRole(rs.getInt(12));
			temp.setRegtime(rs.getString(13));
			temp.setModifedtime(rs.getString(14));
			temp.setVnum(rs.getInt(15));
			temp.setStatus(rs.getInt(16));
			return temp;
		}
		
		return null;
	} catch (SQLException e) {
		
		
		return null;
		
	}
}


}
