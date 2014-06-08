package servlet.RestCustomServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Restaurant;
import dao.impl.RestaurantDaoImpl;

public class RestautantUpdate extends HttpServlet {
	public RestautantUpdate() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String phone = request.getParameter("phone");
		String address= request.getParameter("address");
		RestaurantDaoImpl dao = new RestaurantDaoImpl();
		
		Restaurant rest=null;
		Restaurant temp = null;
		List<Restaurant> all = dao.getRestaurants();
		for(int i = 0;i<all.size();i++)
		{
			temp = all.get(i);
			if(temp.getRest_CEO_ID()==Integer.parseInt(id))
			{
				rest= temp;
				break;
			}
		}
		rest.setRest_phone(phone);
		rest.setRest_Address(address);
		request.getSession().setAttribute("rest",rest);
		System.out.println("rest"+rest);
		dao.updateRestaurant(rest);
		response.sendRedirect("/Ordering/jsp/restCustom/RestCustomInfo.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}
	public void init() throws ServletException {
		// Put your code here
	}

}
