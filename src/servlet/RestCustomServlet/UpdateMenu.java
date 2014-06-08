package servlet.RestCustomServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DishMenu;

import dao.impl.DishMenuDaoImpl;

public class UpdateMenu extends HttpServlet {

	public UpdateMenu() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String remark = request.getParameter("remark");
		DishMenuDaoImpl dao = new DishMenuDaoImpl();
		DishMenu menu = dao.getDishMenu(Integer.parseInt(id));
		System.out.println("update"+menu);
		if(menu!=null)
		{
			menu.setDish_Name(name);
			menu.setDish_Price(Integer.parseInt(price));
			menu.setRemark(remark);
		}
		dao.updateDishMenu(menu);
		response.sendRedirect("/Ordering/jsp/restCustom/RestCustomInfo.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
