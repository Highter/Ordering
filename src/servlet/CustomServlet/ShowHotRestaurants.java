package servlet.CustomServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import bean.DishMenu;
import bean.Restaurant;

import dao.impl.DishMenuDaoImpl;
import dao.impl.RestaurantDaoImpl;

public class ShowHotRestaurants extends HttpServlet {

	public ShowHotRestaurants() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ShowHotRestaurants");
		RestaurantDaoImpl dao = new RestaurantDaoImpl();
		List<Restaurant> all = dao.getRestaurants();
		int a[] = new int[all.size()];
		int b[] = new int[all.size()];
		DishMenuDaoImpl mdao = new DishMenuDaoImpl();
		for(int i=0;i<all.size();i++)
		{
			List<DishMenu> allm=mdao.getRestaurant_DishMenus(all.get(i).getRest_ID());
			int k=0;
			for(int j=0;j<allm.size();j++)
			{
				k=k+allm.get(j).getCount_buy();
				
			}
			a[i] =k;
			b[i] =all.get(i).getRest_ID();
		}
		int id[] = new int[3];
		for(int i=0;i<3;i++)
		{
			int temp = a[0];
			int shop =0;
			for(int j=0;j<a.length;j++)
			{
				if(a[j]>temp)
				{
					temp =a[j];
					shop=j;
				}
			}
			a[shop]=-1;
			id[i] =b[shop];
		}
		for(int i=0;i<3;i++)
		{
			System.out.println(id[i]);
		}
		List<Restaurant> rest = new ArrayList<Restaurant>();
		Restaurant temp = dao.getRestaurant(id[0]);
		rest.add(temp);
		 temp = dao.getRestaurant(id[1]);
		 rest.add(temp);
		 temp = dao.getRestaurant(id[2]);
		 rest.add(temp);
		 PrintWriter out = response.getWriter();
		 
		 JSONArray jsons = JSONArray.fromObject(rest);
		 
		 System.out.println("restJSONS"+jsons);
		 
		 out.println(jsons);
		 out.flush();
		 out.close();
		 
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
