package servlet.RestCustomServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import dao.impl.DishMenuDaoImpl;

import bean.DishMenu;

import util.JspSmart;

public class RestCustomAddMenu extends HttpServlet {

	public RestCustomAddMenu() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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
		
		String style = file.getMySmartUpload().getRequest().getParameter("style");
		String restId = file.getMySmartUpload().getRequest().getParameter("restId");
		String name = file.getMySmartUpload().getRequest().getParameter("name");
		String price = file.getMySmartUpload().getRequest().getParameter("price");
		String remark = file.getMySmartUpload().getRequest().getParameter("remark");
		DishMenu dishMenu = new DishMenu();
		dishMenu.setCount_buy(0);
		dishMenu.setDish_Photo(file.getPath());
		dishMenu.setDish_Name(name);
		dishMenu.setDish_Style_ID(Integer.parseInt(style));
		dishMenu.setDish_Price(Integer.parseInt(price));
		dishMenu.setRemark(remark);
		dishMenu.setRest_ID(Integer.parseInt(restId));
		
		System.out.println(dishMenu);
		DishMenuDaoImpl dao = new DishMenuDaoImpl();
		dao.addDishMenu(dishMenu);
		
		response.sendRedirect("/Ordering/jsp/restCustom/RestCustomInfo.jsp");
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
