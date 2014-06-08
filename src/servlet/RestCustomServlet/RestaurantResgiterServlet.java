package servlet.RestCustomServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import util.JspSmart;
import bean.Restaurant;
import dao.impl.RestaurantDaoImpl;

public class RestaurantResgiterServlet extends HttpServlet {

	public RestaurantResgiterServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JspSmart file = new JspSmart();
		JspFactory jsp1 = JspFactory.getDefaultFactory();
        PageContext pageContext = jsp1.getPageContext(this, request, response, null, true,8192, true);
		file.fileUpload(pageContext);
//		String Rest_Name = file.getMySmartUpload().getRequest().getParameter("Rest_Name");
//		System.out.println("Rest_Name"+Rest_Name);
		String Rest_Name = file.getMySmartUpload().getRequest().getParameter("Rest_Name");
		String Rest_CEO_ID = file.getMySmartUpload().getRequest().getParameter("Rest_CEO_ID");
//		String Rest_Photo = file.getMySmartUpload().getRequest().getParameter("Rest_Photo");
		
//		System.out.println(Rest_Photo);
		String Rest_Address = file.getMySmartUpload().getRequest().getParameter("Rest_Address");
		String Remark =file.getMySmartUpload().getRequest().getParameter("Remark");
		String Rest_phone = file.getMySmartUpload().getRequest().getParameter("Rest_phone");
		String Dish_Style_ID =file.getMySmartUpload().getRequest().getParameter("Dish_Style_ID");
		
//	    System.out.println(Rest_Photo);
	    
		Restaurant rest = new Restaurant();
		rest.setRest_Name(Rest_Name);
		rest.setDish_Style_ID(Integer.parseInt(Dish_Style_ID));
		rest.setRest_CEO_ID(Integer.parseInt(Rest_CEO_ID));
		rest.setRest_phone(Rest_phone);
		rest.setRest_Photo(file.getPath());
		rest.setRest_Address(Rest_Address);
		rest.setRemark(Remark);
		rest.setVnum(1);
		rest.setStatus(1);
		
		System.out.println(rest);
		RestaurantDaoImpl dao = new RestaurantDaoImpl();
		dao.addRestaurant(rest);
		

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/admin/AdminWelcome.jsp");
		rd.include(request, response);
	}

}































