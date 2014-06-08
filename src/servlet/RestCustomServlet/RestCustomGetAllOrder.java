package servlet.RestCustomServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import bean.Order_list;
import bean.Restaurant;

import dao.impl.Order_listDaoImpl;

public class RestCustomGetAllOrder extends HttpServlet {

	public RestCustomGetAllOrder() {
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

	System.out.println("getCustomOrder"); 
	Restaurant rest =  (Restaurant) request.getSession().getAttribute("rest");
	Order_listDaoImpl dao = new Order_listDaoImpl();
	List<Order_list> all= dao.getRestaurant_Order_lists(rest.getRest_ID());
	System.out.println("rest_id"+rest.getRest_ID());
	JSONArray jsons = JSONArray.fromObject(all);
	System.out.println("jsons:"+jsons);
	PrintWriter out = response.getWriter();
	out.println(jsons);
	out.flush();
	out.close();
	
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
