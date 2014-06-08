package servlet.CustomServlet;
//处理用户登录
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Custom;
import bean.Restaurant;
import bean.ShoppingCar;
import dao.impl.CustomDaoImpl;
import dao.impl.RestaurantDaoImpl;
import dao.impl.ShopCarImpl;

public class CustomLoginServlet extends HttpServlet {

	public CustomLoginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String select = request.getParameter("Role");
		System.out.println(select);
		String login_name = request.getParameter("login_name");
		String custom_password = request.getParameter("custom_password");
		System.out.println("login_name:"+login_name+"----custom_password:"+custom_password);
		CustomDaoImpl dao = new CustomDaoImpl();
		Custom cus = dao.getCustom(login_name);
		
		
		if(select.equals("0"))
		{
			System.out.println("select"+0);
			if(cus==null)
			{
				response.sendRedirect("/Ordering/html/custom/CustomLogin.html");
			}else
			{
				if(!custom_password.equals(cus.getCustom_password()))
				{
					response.sendRedirect("/Ordering/html/custom/CustomLogin.html");
					return;
				}
				request.getSession().setAttribute("custom", cus);
				System.out.println("custom"+cus);
				ShopCarImpl daoCar = new ShopCarImpl();
				List<ShoppingCar> all = daoCar.getShopCars(((Custom)request.getSession().getAttribute("custom")).getCustom_ID());
				request.getSession().setAttribute("shop", all);
				response.sendRedirect("/Ordering/jsp/custom/CustomWelcome.jsp");
				
			}
		}else if(select.equals("1"))
		{
			System.out.println("select"+1);
			if(cus==null)
			{
				response.sendRedirect("/Ordering/html/custom/CustomLogin.html");
			}else
			{
				if(!custom_password.equals(cus.getCustom_password()))
				{
					response.sendRedirect("/Ordering/html/custom/CustomLogin.html");
//					return;
				}
				RestaurantDaoImpl rdao = new RestaurantDaoImpl();
				
				Restaurant temp = null;
				//通过用户id得到餐馆
				temp = rdao.getRestaurantByCEO(cus.getCustom_ID());
				System.out.println("temp="+temp);
				if(temp!=null)
				{
					request.getSession().setAttribute("rest", temp);
//					System.out.println(temp);

				}
				request.getSession().setAttribute("custom",cus);
				System.out.println("custom"+cus);
				response.sendRedirect("/Ordering/jsp/restCustom/RestCustomWelcome.jsp");
				
				
				ShopCarImpl daoCar = new ShopCarImpl();
				List<ShoppingCar> all = daoCar.getShopCars(((Custom)request.getSession().getAttribute("custom")).getCustom_ID());
				request.getSession().setAttribute("shop", all);
				
				System.out.println("here");
			}
		}else if(select.equals("2"))
		{
			if(login_name.equals("admin")&&(custom_password.endsWith("12"))){
				response.sendRedirect("/Ordering/jsp/admin/AdminWelcome.jsp");
			}else{
				response.sendRedirect("/Ordering/html/custom/CustomLogin.html");
			}
//			System.out.println("select"+2);
		}

	}

}
