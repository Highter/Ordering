package servlet.RestCustomServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import dao.impl.CustomDaoImpl;
import dao.impl.Rest_messageDaoImpl;

import bean.Custom;
import bean.Message;
import bean.Rest_message;
import bean.Restaurant;

public class RestShowMessage extends HttpServlet {

	public RestShowMessage() {
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

		System.out.println("/RestShowMessage");
		Restaurant rest = (Restaurant) request.getSession().getAttribute("rest");
		System.out.println(rest.getRest_ID());
		Rest_messageDaoImpl dao = new Rest_messageDaoImpl();
		List<Rest_message> all = dao.getRestaurant_messages(rest.getRest_ID());
		List<Message> trueAll = new ArrayList<Message>();
		CustomDaoImpl cusDao = new CustomDaoImpl();
		for(Rest_message rest1:all)
		{
			Message temp = new Message();
			Custom cus = cusDao.getCustom(rest1.getCustom_ID());
			temp.setCustom_name(cus.getCustom_Name()) ;
			temp.setMessage(rest1.getMessage());
			temp.setTime(rest1.getTime());
			trueAll.add(temp);
		}
		JSONArray jsons = JSONArray.fromObject(trueAll);
		PrintWriter out = response.getWriter();
		System.out.println("jsons"+jsons);
		out.println(jsons);
		out.flush();
		out.close();
	}


	public void init() throws ServletException {
		
	}

}
