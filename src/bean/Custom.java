/*�������û���Ϣ��*/
package bean;

import java.io.Serializable;
import java.util.Date;

public class Custom implements Serializable {

	private int custom_ID; // Int �˿�ID�������� primary
	private String login_name; // Varchar 20 �û���¼��
	private String custom_password; // Varchar 20 �˿͵�½����
	private String custom_Name; // Varchar 20 �û���ʵ����
	private int custom_sex; // Varchar 2 �Ա�(��/Ů)-----------1�����У�0����Ů
	private int custom_age; // Int ����
	private String person_ID; // Varchar 17 ���֤����
	private String Address; // Varchar 100 �ͻ���ַ
	private String Phone; // Varchar 11 ��ϵ�绰
	private String Email; // Varchar 50 �����ʼ�
	private String QQ; // Varchar 10 QQ
	private int Role; // Int 0=��ͨ�û�/1=�͹ݷ���/2=��̨����Ա
	private String Regtime; // datetime ע��ʱ��
	private String Modifedtime; // Datetime ����ʱ��
	private int Vnum; // Int �汾��
	private int status; // Int ״̬:0=δ����/1=�Ѿ�����/-1=�߼�ɾ��

	public Custom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Custom(int custom_ID, String login_name, String custom_password,
			String custom_Name, int custom_sex, int custom_age,
			String person_ID, String address, String phone, String email,
			String qQ, int role, String regtime, String modifedtime, int vnum,
			int status) {
		super();
		this.custom_ID = custom_ID;
		this.login_name = login_name;
		this.custom_password = custom_password;
		this.custom_Name = custom_Name;
		this.custom_sex = custom_sex;
		this.custom_age = custom_age;
		this.person_ID = person_ID;
		Address = address;
		Phone = phone;
		Email = email;
		QQ = qQ;
		Role = role;
		Regtime = regtime;
		Modifedtime = modifedtime;
		Vnum = vnum;
		this.status = status;
	}



	//ע��:�ù��췽��û������-------custom_id
	public Custom(String login_name, String custom_password,
			String custom_Name, int custom_sex, int custom_age,
			String person_ID, String address, String phone, String email,
			String qQ, int role, String regtime, String modifedtime, int vnum,
			int status) {
		super();
		this.login_name = login_name;
		this.custom_password = custom_password;
		this.custom_Name = custom_Name;
		this.custom_sex = custom_sex;
		this.custom_age = custom_age;
		this.person_ID = person_ID;
		Address = address;
		Phone = phone;
		Email = email;
		QQ = qQ;
		Role = role;
		Regtime = regtime;
		Modifedtime = modifedtime;
		Vnum = vnum;
		this.status = status;
	}


	public int getCustom_ID() {
		return custom_ID;
	}

	public void setCustom_ID(int custom_ID) {
		this.custom_ID = custom_ID;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getCustom_password() {
		return custom_password;
	}

	public void setCustom_password(String custom_password) {
		this.custom_password = custom_password;
	}

	public String getCustom_Name() {
		return custom_Name;
	}

	public void setCustom_Name(String custom_Name) {
		this.custom_Name = custom_Name;
	}

	public int getCustom_sex() {
		return custom_sex;
	}

	public void setCustom_sex(int custom_sex) {
		this.custom_sex = custom_sex;
	}

	public int getCustom_age() {
		return custom_age;
	}

	public void setCustom_age(int custom_age) {
		this.custom_age = custom_age;
	}

	public String getPerson_ID() {
		return person_ID;
	}

	public void setPerson_ID(String person_ID) {
		this.person_ID = person_ID;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public int getRole() {
		return Role;
	}

	public void setRole(int role) {
		Role = role;
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
		return "Custom [custom_ID=" + custom_ID + ", login_name=" + login_name
				+ ", custom_password=" + custom_password + ", custom_Name="
				+ custom_Name + ", custom_sex=" + custom_sex + ", custom_age="
				+ custom_age + ", person_ID=" + person_ID + ", Address="
				+ Address + ", Phone=" + Phone + ", Email=" + Email + ", QQ="
				+ QQ + ", Role=" + Role + ", Regtime=" + Regtime
				+ ", Modifedtime=" + Modifedtime + ", Vnum=" + Vnum
				+ ", status=" + status + "]";
	}

}
