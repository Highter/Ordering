package servlet.CustomServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DishMenu;
import bean.Restaurant;

import dao.impl.DishMenuDaoImpl;
import dao.impl.RestaurantDaoImpl;

public class CustomSearch extends HttpServlet {
	public CustomSearch() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("CustomSearch");
		String msg = request.getParameter("msg");
//		System.out.println("msg:"+msg);
		String select = request.getParameter("select");
		if(select.equals("1")&&msg!=null)
		{
//			System.out.println(1111111111);
			RestaurantDaoImpl dao = new RestaurantDaoImpl();
			Restaurant rest = dao.getRestaurantByName(msg);
			if(rest==null)
			{
				response.sendRedirect("/Ordering/jsp/custom/SearchNotthing.jsp");
				return;
			}
			request.getSession().setAttribute("restMessage", rest);
			response.sendRedirect("/Ordering/jsp/custom/RestSearch.jsp");
			return;
			
		}
		else if(select.equals("2")&&msg!=null)
		{
//			System.out.println(22222222);
			DishMenuDaoImpl dao = new DishMenuDaoImpl();
			DishMenu menu = dao.getDishMenu(msg);
			System.out.println("menu"+menu);
			if(menu==null)
			{
				response.sendRedirect("/Ordering/jsp/custom/SearchNotthing.jsp");
				return;
			}
			request.getSession().setAttribute("menuMessage", menu);
			response.sendRedirect("/Ordering/jsp/custom/DishMenuSearch.jsp");
			return;
		}
		else
		{
			System.out.println(33333333);
			response.sendRedirect("/Ordering/jsp/custom/SearchNotthing.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
