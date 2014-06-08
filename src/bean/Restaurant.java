/*�͹���Ϣ��*/
package bean;

import java.io.Serializable;
import java.util.Date;

public class Restaurant implements Serializable {

	private int Rest_ID;// �͹�id Primary key
	private int Dish_Style_ID;// ��Ӫ��ϵ not null
	private String Rest_Name;// �͹�����
	private int Rest_CEO_ID;// �͹��ϰ壨�����û��� not null
	private String Rest_phone;// ���͵绰
	private String Rest_Address;// �͹ݵ�ַ
	private String Rest_Photo; // �͹�ͼƬ
	private String Remark; // ���ڲ͹ݵĽ���
	private String Regtime;// ע��ʱ��,Date����
	private String Modifedtime;// ����ʱ��
	private int Vnum; // �汾��
	private int status;// ״̬0=δ����/1=�Ѿ�����/-1=�߼�ɾ��


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
