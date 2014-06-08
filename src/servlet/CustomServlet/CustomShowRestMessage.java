package servlet.CustomServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Rest_message;
import bean.Restaurant;

import dao.impl.Rest_messageDaoImpl;
import dao.impl.RestaurantDaoImpl;

public class CustomShowRestMessage extends HttpServlet {

	public CustomShowRestMessage() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("restId:"+id);
		RestaurantDaoImpl dao = new RestaurantDaoImpl();
		Restaurant rest = dao.getRestaurant(Integer.parseInt(id));
		request.getSession().setAttribute("restMessage", rest);
		
		Rest_messageDaoImpl daom = new Rest_messageDaoImpl();
		List<Rest_message> mess = daom.getRestaurant_messages(Integer.parseInt(id));
		
		System.out.println("mess"+mess);
		request.getSession().setAttribute("mess", mess);
		
		response.sendRedirect("/Ordering/jsp/restCustom/RestaurantMsgShow.jsp");
		
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
