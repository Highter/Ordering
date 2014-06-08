/*订餐者用户信息表*/
package bean;

import java.io.Serializable;
import java.util.Date;

public class Custom implements Serializable {

	private int custom_ID; // Int 顾客ID（主键） primary
	private String login_name; // Varchar 20 用户登录名
	private String custom_password; // Varchar 20 顾客登陆密码
	private String custom_Name; // Varchar 20 用户真实姓名
	private int custom_sex; // Varchar 2 性别(男/女)-----------1代表男，0代表女
	private int custom_age; // Int 年龄
	private String person_ID; // Varchar 17 身份证号码
	private String Address; // Varchar 100 送货地址
	private String Phone; // Varchar 11 联系电话
	private String Email; // Varchar 50 电子邮件
	private String QQ; // Varchar 10 QQ
	private int Role; // Int 0=普通用户/1=餐馆法人/2=后台管理员
	private String Regtime; // datetime 注册时间
	private String Modifedtime; // Datetime 更新时间
	private int Vnum; // Int 版本号
	private int status; // Int 状态:0=未激活/1=已经激活/-1=逻辑删除

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



	//注意:该构造方法没有主键-------custom_id
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
