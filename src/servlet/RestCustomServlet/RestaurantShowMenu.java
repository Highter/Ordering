package servlet.RestCustomServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import bean.DishMenu;
import bean.Restaurant;
import dao.impl.DishMenuDaoImpl;

public class RestaurantShowMenu extends HttpServlet {
	public RestaurantShowMenu() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doPost()");
		
		//获取在登录时根据登录名得到的餐馆
		Restaurant rest = (Restaurant) request.getSession().getAttribute("rest");
		System.out.println("rest:"+rest);
		DishMenuDaoImpl dao = new DishMenuDaoImpl();
		//通过餐馆的号得到所有的菜单
		
		List<DishMenu> all = dao.getRestaurant_DishMenus(rest.getRest_ID());
		System.out.println("all:"+all);
		request.getSession().setAttribute("menu", all);
		JSONArray jsons = JSONArray.fromObject(all);
		
		PrintWriter out = response.getWriter();
		System.out.println(jsons);
		
		out.println(jsons);
		out.flush();
		out.close();
		
		
	}

	public void init() throws ServletException {
		
	}

}
