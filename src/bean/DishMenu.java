/*�˵���Ϣ��*/
package bean;

import java.io.Serializable;
import java.util.Date;

public class DishMenu implements Serializable {

	private int Dish_ID; // Bigint ��ƷID Primary Key
	private int Dish_Style_ID; // Int ������ϵ Not null
	private int Rest_ID; // Int �͹�Id (���) Not null
	private String Dish_Name; // Varchar 20 ��Ʒ����
	private int Dish_Price; // int ��Ʒ�۸�
	private int Count_buy; // Int ��¼���������
	private String Dish_Photo; // Varchar 200 ͼƬ�������ӵ�ַ
	private String Remark; // Varchar 200 ��ע
	private String Regtime; // datetime ע��ʱ��
	private String Modifedtime; // Datetime ����ʱ��
	private int Vnum; // Int �汾��
	private int status; // Int ״̬0=δ���� 1 �Ѿ����� -1�߼�ɾ��

	public DishMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DishMenu(int dish_Style_ID, int rest_ID, String dish_Name,
			int dish_Price, int count_buy, String dish_Photo, String remark,
			String regtime, String modifedtime, int vnum, int status) {
		super();
		Dish_Style_ID = dish_Style_ID;
		Rest_ID = rest_ID;
		Dish_Name = dish_Name;
		Dish_Price = dish_Price;
		Count_buy = count_buy;
		Dish_Photo = dish_Photo;
		Remark = remark;
		Regtime = regtime;
		Modifedtime = modifedtime;
		Vnum = vnum;
		this.status = status;
	}



	public DishMenu(int dish_ID, int dish_Style_ID, int rest_ID,
			String dish_Name, int dish_Price, int count_buy, String dish_Photo,
			String remark, String regtime, String modifedtime, int vnum,
			int status) {
		super();
		Dish_ID = dish_ID;
		Dish_Style_ID = dish_Style_ID;
		Rest_ID = rest_ID;
		Dish_Name = dish_Name;
		Dish_Price = dish_Price;
		Count_buy = count_buy;
		Dish_Photo = dish_Photo;
		Remark = remark;
		Regtime = regtime;
		Modifedtime = modifedtime;
		Vnum = vnum;
		this.status = status;
	}



	public int getDish_ID() {
		return Dish_ID;
	}

	public void setDish_ID(int dish_ID) {
		Dish_ID = dish_ID;
	}

	public int getDish_Style_ID() {
		return Dish_Style_ID;
	}

	public void setDish_Style_ID(int dish_Style_ID) {
		Dish_Style_ID = dish_Style_ID;
	}

	public int getRest_ID() {
		return Rest_ID;
	}

	public void setRest_ID(int rest_ID) {
		Rest_ID = rest_ID;
	}

	public String getDish_Name() {
		return Dish_Name;
	}

	public void setDish_Name(String dish_Name) {
		Dish_Name = dish_Name;
	}

	public int getDish_Price() {
		return Dish_Price;
	}

	public void setDish_Price(int dish_Price) {
		Dish_Price = dish_Price;
	}

	public int getCount_buy() {
		return Count_buy;
	}

	public void setCount_buy(int count_buy) {
		Count_buy = count_buy;
	}

	public String getDish_Photo() {
		return Dish_Photo;
	}

	public void setDish_Photo(String dish_Photo) {
		Dish_Photo = dish_Photo;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "DishMenu [Dish_ID=" + Dish_ID + ", Dish_Style_ID="
				+ Dish_Style_ID + ", Rest_ID=" + Rest_ID + ", Dish_Name="
				+ Dish_Name + ", Dish_Price=" + Dish_Price + ", Count_buy="
				+ Count_buy + ", Dish_Photo=" + Dish_Photo + ", Remark="
				+ Remark + ", Regtime=" + Regtime + ", Modifedtime="
				+ Modifedtime + ", Vnum=" + Vnum + ", status=" + status + "]";
	}

}
