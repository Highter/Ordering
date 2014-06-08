package servlet.CustomServlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.CustomDaoImpl;

import bean.Custom;

public class CustomRegisterServet extends HttpServlet {

	public CustomRegisterServet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
		System.out.println("Register");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login_name = request.getParameter("login_name");
		String custom_password = request.getParameter("custom_password");
//		System.out.println("这里是处理  用户注册  的Servlet类");
//		System.out.println("login_name:"+login_name+"----custom_password:"+custom_password);
		String custom_Name = request.getParameter("custom_Name");	
		String custom_sex  = request.getParameter("custom_sex");
		String  custom_age = request.getParameter("custom_Age");
		String person_ID = request.getParameter("custom_ID");
		String Address = request.getParameter("custom_Address");
		String Phone = request.getParameter("custom_Phone");
		String Email = request.getParameter("custom_Email");
		String QQ = request.getParameter("custom_QQ");
		
		Custom cus = new Custom();
		
		cus.setLogin_name(login_name);
		cus.setCustom_password(custom_password);
		cus.setCustom_Name(custom_Name);
		cus.setCustom_sex(Integer.parseInt(custom_sex));
		cus.setCustom_age(Integer.parseInt(custom_age));
		cus.setPerson_ID(person_ID);
		cus.setAddress(Address);
		cus.setPhone(Phone);
		cus.setEmail(Email);
		cus.setQQ(QQ);
		cus.setRole(1);
	
		cus.setVnum(1);
		cus.setStatus(1);
		
		CustomDaoImpl dao = new CustomDaoImpl();
		dao.addCustom(cus);
		
		
		
	}

}
