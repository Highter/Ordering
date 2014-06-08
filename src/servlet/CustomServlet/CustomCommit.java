package servlet.CustomServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.Order_itemDaoImpl;
import dao.impl.Order_listDaoImpl;
import dao.impl.RestaurantDaoImpl;
import dao.impl.ShopCarImpl;

import bean.Custom;
import bean.Order_item;
import bean.Order_list;
import bean.ShoppingCar;

public class CustomCommit extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomCommit() {
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

		this.doPost(request, response);
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

		System.out.println("CustomCommit");
		List<ShoppingCar> all = (List<ShoppingCar>) request.getSession().getAttribute("shop");
		System.out.println("all"+all);
		if(all==null)
		{
			return;
		}
		else
		{
			double sum = 0;
			Order_listDaoImpl dao = new Order_listDaoImpl();
			RestaurantDaoImpl rdao = new RestaurantDaoImpl();
			Order_itemDaoImpl idao = new Order_itemDaoImpl();
			
			for(int i=0;i<all.size();i++)
			{
				sum = all.get(i).getCount()*all.get(i).getPrice();
				
				Order_list order = new Order_list();
				order.setAddress(((Custom)request.getSession().getAttribute("custom")).getAddress());
				order.setCustom_ID(((Custom)request.getSession().getAttribute("custom")).getCustom_ID());
				order.setSum_Price(sum);
				order.setPhone(((Custom)request.getSession().getAttribute("custom")).getPhone());
				order.setRestaurant_ID(rdao.getRestaurantByName(all.get(i).getRestName()).getRest_ID());
				long id = dao.addOrder_list(order);
				Order_item item = new Order_item();
				item.setDish_number(all.get(i).getCount());
				item.setDish_ID(all.get(i).getDishId());
				item.setOrder_ID(id);
				idao.addOrder_item(item);
			}
			
			ShopCarImpl daos = new ShopCarImpl();
			daos.deleteShopCar(((Custom)request.getSession().getAttribute("custom")).getCustom_ID());
			
		}
		response.sendRedirect("/Ordering/jsp/custom/ShowOrderMessage.jsp");
		
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
