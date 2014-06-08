package servlet.CustomServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DishMenu;
import bean.Restaurant;
import bean.ShoppingCar;

import dao.impl.DishMenuDaoImpl;
import dao.impl.Rest_messageDaoImpl;
import dao.impl.RestaurantDaoImpl;

public class CustomShowMenu extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomShowMenu() {
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
		System.out.println(id);
		
		DishMenuDaoImpl dao = new DishMenuDaoImpl();
		DishMenu dish = dao.getDishMenu(Integer.parseInt(id));
		System.out.println("dish:"+dish);
		ShoppingCar message = new ShoppingCar();
		if(dish!=null)
		{
			RestaurantDaoImpl getRestName = new RestaurantDaoImpl();
			Restaurant rest = getRestName.getRestaurant(dish.getRest_ID());
			System.out.println("dish.getRest_ID"+dish.getRest_ID());
			System.out.println("rest:"+rest);
			message.setDishId(Integer.parseInt(id));
			message.setDishName(dish.getDish_Name());
			message.setPhoto(dish.getDish_Photo());
			message.setPrice(dish.getDish_Price());
			message.setRemark(dish.getRemark());
			message.setRestName(rest.getRest_Name());
			System.out.println("1111111111111111111111111111"+rest.getRest_Name());
			request.getSession().setAttribute("message",message);
			response.sendRedirect("/Ordering/jsp/restCustom/MenuShow.jsp");	
		}
		
		
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
