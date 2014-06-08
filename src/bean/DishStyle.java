/*菜系信息表s*/
package bean;

import java.io.Serializable;
import java.util.Date;

public class DishStyle implements Serializable {
	private int Dish_Style_ID; // int 菜单编号(只有8个) primary
	private String Dish_Style_Name; // varchar 50 菜系名
	private String Discription; // varchar 300 基本介绍
	private String Regtime; // date 注册时间
	private String Modifedtime; // Datetime 更新时间
	private int Vnum; // Int 版本号
	private int status; // Int 餐馆状态0=未激活 1 已经激活 -1逻辑删除

	public DishStyle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DishStyle(int dish_Style_ID, String dish_Style_Name,
			String discription, String regtime, String modifedtime, int vnum,
			int status) {
		super();
		Dish_Style_ID = dish_Style_ID;
		Dish_Style_Name = dish_Style_Name;
		Discription = discription;
		Regtime = regtime;
		Modifedtime = modifedtime;
		Vnum = vnum;
		this.status = status;
	}



	public int getDish_Style_ID() {
		return Dish_Style_ID;
	}

	public void setDish_Style_ID(int dish_Style_ID) {
		Dish_Style_ID = dish_Style_ID;
	}

	public String getDish_Style_Name() {
		return Dish_Style_Name;
	}

	public void setDish_Style_Name(String dish_Style_Name) {
		Dish_Style_Name = dish_Style_Name;
	}

	public String getDiscription() {
		return Discription;
	}

	public void setDiscription(String discription) {
		Discription = discription;
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
		return "DishStyle [Dish_Style_ID=" + Dish_Style_ID
				+ ", Dish_Style_Name=" + Dish_Style_Name + ", Discription="
				+ Discription + ", Regtime=" + Regtime + ", Modifedtime="
				+ Modifedtime + ", Vnum=" + Vnum + ", status=" + status + "]";
	}

}
