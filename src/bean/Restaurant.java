/*餐馆信息表*/
package bean;

import java.io.Serializable;
import java.util.Date;

public class Restaurant implements Serializable {

	private int Rest_ID;// 餐馆id Primary key
	private int Dish_Style_ID;// 主营菜系 not null
	private String Rest_Name;// 餐馆名字
	private int Rest_CEO_ID;// 餐馆老板（关联用户表） not null
	private String Rest_phone;// 订餐电话
	private String Rest_Address;// 餐馆地址
	private String Rest_Photo; // 餐馆图片
	private String Remark; // 关于餐馆的介绍
	private String Regtime;// 注册时间,Date类型
	private String Modifedtime;// 更新时间
	private int Vnum; // 版本号
	private int status;// 状态0=未激活/1=已经激活/-1=逻辑删除


	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Restaurant(int rest_ID, int dish_Style_ID, String rest_Name,
			int rest_CEO_ID, String rest_phone, String rest_Address,
			String rest_Photo, String remark, String regtime, String modifedtime,
			int vnum, int status) {
		super();
		Rest_ID = rest_ID;
		Dish_Style_ID = dish_Style_ID;
		Rest_Name = rest_Name;
		Rest_CEO_ID = rest_CEO_ID;
		Rest_phone = rest_phone;
		Rest_Address = rest_Address;
		Rest_Photo = rest_Photo;
		Remark = remark;
		Regtime = regtime;
		Modifedtime = modifedtime;
		Vnum = vnum;
		this.status = status;
	}


	public Restaurant(int dish_Style_ID, String rest_Name, int rest_CEO_ID,
			String rest_phone, String rest_Address, String rest_Photo,
			String remark, String regtime, String modifedtime, int vnum, int status) {
		super();
		Dish_Style_ID = dish_Style_ID;
		Rest_Name = rest_Name;
		Rest_CEO_ID = rest_CEO_ID;
		Rest_phone = rest_phone;
		Rest_Address = rest_Address;
		Rest_Photo = rest_Photo;
		Remark = remark;
		Regtime = regtime;
		Modifedtime = modifedtime;
		Vnum = vnum;
		this.status = status;
	}


	public int getRest_ID() {
		return Rest_ID;
	}


	public void setRest_ID(int rest_ID) {
		Rest_ID = rest_ID;
	}


	public int getDish_Style_ID() {
		return Dish_Style_ID;
	}


	public void setDish_Style_ID(int dish_Style_ID) {
		Dish_Style_ID = dish_Style_ID;
	}


	public String getRest_Name() {
		return Rest_Name;
	}


	public void setRest_Name(String rest_Name) {
		Rest_Name = rest_Name;
	}


	public int getRest_CEO_ID() {
		return Rest_CEO_ID;
	}


	public void setRest_CEO_ID(int rest_CEO_ID) {
		Rest_CEO_ID = rest_CEO_ID;
	}


	public String getRest_phone() {
		return Rest_phone;
	}


	public void setRest_phone(String rest_phone) {
		Rest_phone = rest_phone;
	}


	public String getRest_Address() {
		return Rest_Address;
	}


	public void setRest_Address(String rest_Address) {
		Rest_Address = rest_Address;
	}


	public String getRest_Photo() {
		return Rest_Photo;
	}


	public void setRest_Photo(String rest_Photo) {
		Rest_Photo = rest_Photo;
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
		return "Restaurant [Rest_ID=" + Rest_ID + ", Dish_Style_ID="
				+ Dish_Style_ID + ", Rest_Name=" + Rest_Name + ", Rest_CEO_ID="
				+ Rest_CEO_ID + ", Rest_phone=" + Rest_phone
				+ ", Rest_Address=" + Rest_Address + ", Rest_Photo="
				+ Rest_Photo + ", Remark=" + Remark + ", Regtime=" + Regtime
				+ ", Modifedtime=" + Modifedtime + ", Vnum=" + Vnum
				+ ", status=" + status + "]";
	}

}
