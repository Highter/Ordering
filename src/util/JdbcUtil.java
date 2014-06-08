package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	static String driverClassName;
	static String url;
	static String username;
	static String password;
	static{
		try {
			Properties prop=new Properties();
			prop.load(JdbcUtil.class
						.getResourceAsStream("mysql.properties"));
			driverClassName=prop.getProperty("drivername");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			
			//1�����������ࣨ������ɺ󣬾Ϳ�����DriverManager��
			Class.forName(driverClassName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�ṩ���Ӷ���
	public static Connection getConn(){
		try {
			Connection conn=DriverManager.getConnection(url, username, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//�ر���Ӧ��Դ
	public static void close(ResultSet rs, Statement stmt, Connection conn){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(stmt!=null){
				stmt.close();
				stmt=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(JdbcUtil.getConn());
	}
}
