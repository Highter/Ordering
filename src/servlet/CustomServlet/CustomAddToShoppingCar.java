package servlet.CustomServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.DishMenuDaoImpl;
import dao.impl.RestaurantDaoImpl;

import bean.DishMenu;
import bean.Restaurant;
import bean.ShoppingCar;

public class CustomAddToShoppingCar extends HttpServlet {
	public CustomAddToShoppingCar() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dishId= request.getParameter("id");
		System.out.println("dishId="+dishId);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id= request.getParameter("id");
		List<ShoppingCar> all = (List<ShoppingCar>) request.getSession().getAttribute("shop");
		
		DishMenuDaoImpl dao = new DishMenuDaoImpl();
		DishMenu dish = dao.getDishMenu(Integer.parseInt(id));
		
		ShoppingCar message = new ShoppingCar();
		RestaurantDaoImpl getRestName = new RestaurantDaoImpl();
		Restaurant rest = getRestName.getRestaurant(dish.getRest_ID());
		message.setDishId(Integer.parseInt(id));
		message.setDishName(dish.getDish_Name());
		message.setPhoto(dish.getDish_Photo());
		message.setPrice(dish.getDish_Price());
		message.setRemark(dish.getRemark());
		message.setRestName(rest.getRest_Name());
		message.setCount(1);
		if(all==null)
		{
			//Session里没有东西，则必定不存在
			all=new ArrayList<ShoppingCar>();
			request.getSession().setAttribute("shop", all);
			all.add(message);
			
		}else
		{
			int i=0;
			for(i = 0;i<all.size();i++)
			{
				//如果产品已经存在，则加一
				if(all.get(i).getDishId()==Integer.parseInt(id))
				{
					all.get(i).setCount(all.get(i).getCount()+1);
					break;
				}
			}
			if(i==all.size())
			{
				//如果产品不存在，则直接添加
				all.add(message);	
			}
			
			
		}
		response.sendRedirect("/Ordering/jsp/restCustom/MenuShow.jsp");	
	}
	public void init() throws ServletException {
	}

}
