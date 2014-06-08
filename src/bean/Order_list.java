/*������Ϣ��*/
package bean;

import java.io.Serializable;
import java.util.Date;

public class Order_list implements Serializable {

	private long Order_ID; // Varchar 20 ������� Primary Key

	private int Custom_ID; // Int �µ��˿�ID
	private double Sum_Price; // Int �ܼ�
	private int Restaurant_ID; // -----------------�͹�ID
	private String Address; // Varchar 100 �ͻ���ַ
	private String Phone; // Varchar 11 ��ϵ�绰
	private String Order_Time; // Datetime �¶���ʱ��
	private int Order_Condition; // Varchar 2 ����״̬:-------------��δ����=0/������=1��
	private String Regtime; // datetime ע��ʱ��
	private String Modifedtime; // Datetime ����ʱ��
	private int Vnum; // Int �汾��

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
