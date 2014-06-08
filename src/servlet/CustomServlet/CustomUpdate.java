package servlet.CustomServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.CustomDaoImpl;

import bean.Custom;

public class CustomUpdate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomUpdate() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("the id is=" +id);
		String name = request.getParameter("name");
		String trueName = request.getParameter("trueName");
		String pass = request.getParameter("pass");
		String sex = request.getParameter("age");
		String person = request.getParameter("person");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String mail = request.getParameter("mail");
		String qq = request.getParameter("qq");
		String age = request.getParameter("age");
		
		CustomDaoImpl dao = new CustomDaoImpl();
		
		Custom cus = dao.getCustom(Integer.parseInt(id));
		System.out.println("cus:"+cus);
		
		cus.setCustom_Name(trueName);
		cus.setCustom_password(pass);
		cus.setCustom_age(Integer.parseInt(age));
		cus.setAddress(address);
		cus.setPerson_ID(person);
		cus.setPhone(phone);
		cus.setQQ(qq);
		cus.setEmail(mail);
		cus.setCustom_sex(Integer.parseInt(sex));
		cus.setLogin_name(name);
		System.out.println("cus:"+cus);
		
		dao.updateCustom(cus);
		request.getSession().setAttribute("custom", cus);
		response.sendRedirect("/Ordering/jsp/custom/CustomInfo.jsp");
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
