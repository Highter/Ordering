/*订单信息表*/
package bean;

import java.io.Serializable;
import java.util.Date;

public class Order_list implements Serializable {

	private long Order_ID; // Varchar 20 订单编号 Primary Key

	private int Custom_ID; // Int 下单顾客ID
	private double Sum_Price; // Int 总价
	private int Restaurant_ID; // -----------------餐馆ID
	private String Address; // Varchar 100 送货地址
	private String Phone; // Varchar 11 联系电话
	private String Order_Time; // Datetime 下订单时间
	private int Order_Condition; // Varchar 2 订单状态:-------------（未受理=0/已受理=1）
	private String Regtime; // datetime 注册时间
	private String Modifedtime; // Datetime 更新时间
	private int Vnum; // Int 版本号

	public Order_list() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Order_list(int sum_Price, int custom_ID, int restaurant_ID,
			String address, String phone, String order_Time,
			int order_Condition, String regtime, String modifedtime, int vnum) {
		super();
		Sum_Price = sum_Price;
		Custom_ID = custom_ID;
		Restaurant_ID = restaurant_ID;
		Address = address;
		Phone = phone;
		Order_Time = order_Time;
		Order_Condition = order_Condition;
		Regtime = regtime;
		Modifedtime = modifedtime;
		Vnum = vnum;
	}



	public Order_list(long order_ID, int sum_Price, int custom_ID,
			int restaurant_ID, String address, String phone, String order_Time,
			int order_Condition, String regtime, String modifedtime, int vnum) {
		super();
		Order_ID = order_ID;
		Sum_Price = sum_Price;
		Custom_ID = custom_ID;
		Restaurant_ID = restaurant_ID;
		Address = address;
		Phone = phone;
		Order_Time = order_Time;
		Order_Condition = order_Condition;
		Regtime = regtime;
		Modifedtime = modifedtime;
		Vnum = vnum;
	}



	public long getOrder_ID() {
		return Order_ID;
	}
	
	public void setOrder_ID(long order_ID) {
		Order_ID = order_ID;
	}

	public double getSum_Price() {
		return Sum_Price;
	}

	public void setSum_Price(double sum_Price) {
		Sum_Price = sum_Price;
	}

	public int getCustom_ID() {
		return Custom_ID;
	}

	public void setCustom_ID(int custom_ID) {
		Custom_ID = custom_ID;
	}

	public int getRestaurant_ID() {
		return Restaurant_ID;
	}

	public void setRestaurant_ID(int restaurant_ID) {
		Restaurant_ID = restaurant_ID;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getOrder_Time() {
		return Order_Time;
	}

	public void setOrder_Time(String order_Time) {
		Order_Time = order_Time;
	}

	public int getOrder_Condition() {
		return Order_Condition;
	}

	public void setOrder_Condition(int order_Condition) {
		Order_Condition = order_Condition;
	}

	public String getRegtime() {
		return Regtime;
	}

	public void setRegtime(String regtime) {
		Regtime = regtime;
	}

	public String getModifedtime() {
		return Modifedtime;
	}

	public void setModifedtime(String modifedtime) {
		Modifedtime = modifedtime;
	}

	public int getVnum() {
		return Vnum;
	}

	public void setVnum(int vnum) {
		Vnum = vnum;
	}

	@Override
	public String toString() {
		return "Order_list [Order_ID=" + Order_ID + ", Sum_Price=" + Sum_Price
				+ ", Custom_ID=" + Custom_ID + ", Restaurant_ID="
				+ Restaurant_ID + ", Address=" + Address + ", Phone=" + Phone
				+ ", Order_Time=" + Order_Time + ", Order_Condition="
				+ Order_Condition + ", Regtime=" + Regtime + ", Modifedtime="
				+ Modifedtime + ", Vnum=" + Vnum + "]";
	}
}
