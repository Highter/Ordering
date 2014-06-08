package servlet.RestCustomServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.impl.DishMenuDaoImpl;

public class RestDeleteMenu extends HttpServlet {

	public RestDeleteMenu() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("RestDeleteMenu="+id);
		DishMenuDaoImpl dao = new DishMenuDaoImpl();
		dao.deleteDishMenu(Integer.parseInt(id));
		PrintWriter out = response.getWriter();
//		JSONObject test = JSONObject.fromObject("success");
		out.println("success");
//		System.out.println(test);
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
