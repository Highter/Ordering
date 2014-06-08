package servlet.CustomServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import bean.MenuList;

import dao.IDishMenu;
import dao.impl.DishMenuDaoImpl;

public class MenuListServlet extends HttpServlet {

	public MenuListServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//System.out.println("MenuListServlet");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		/*IDishMenu dao = new DishMenuDaoImpl();
		List<DishMenu> menuList = dao.getDishStyle_DishMenus(1);
		JSONArray jsons_menuList = JSONArray.fromObject(menuList);
		System.out.println(jsons_menuList);
		out.println(jsons_menuList);*/
		
		
		/*IDishMenu dao = new DishMenuDaoImpl();
		Map<String, List<DishMenu>> menuMap = new HashMap<String, List<DishMenu>>();
		for(int i=0;i<8;i++){
			String t = i+"";
			List<DishMenu> menuList = dao.getDishStyle_DishMenus(i);
			menuMap.put(t,menuList);
		}
		JSONArray jsons_menuMap = JSONArray.fromObject(menuMap);
		System.out.println(jsons_menuMap);
		out.println(jsons_menuMap);*/
		
		IDishMenu dao = new DishMenuDaoImpl();
		MenuList menuList = new MenuList();
		menuList.setMenuList1(dao.getDishStyle_DishMenus(1));
		menuList.setMenuList2(dao.getDishStyle_DishMenus(2));
		menuList.setMenuList3(dao.getDishStyle_DishMenus(3));
		menuList.setMenuList4(dao.getDishStyle_DishMenus(4));
		menuList.setMenuList5(dao.getDishStyle_DishMenus(5));
		menuList.setMenuList6(dao.getDishStyle_DishMenus(6));
		menuList.setMenuList7(dao.getDishStyle_DishMenus(7));
		menuList.setMenuList8(dao.getDishStyle_DishMenus(8));
		
		JSONArray jsons_menuList = JSONArray.fromObject(menuList);
		//System.out.println(jsons_menuList);
		out.println(jsons_menuList);
		
		out.flush();
		out.close();
	}

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

}
