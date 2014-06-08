package servlet.RestCustomServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.DishMenu;

public class Test extends HttpServlet {
	public Test() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		List<DishMenu> all =(List<DishMenu>) request.getSession().getAttribute("menu");
		DishMenu menu = null;
		for(int i = 0;i<all.size();i++)
		{
			if(all.get(i).getDish_ID()==Integer.parseInt(id))
			{
				menu = all.get(i);
				request.getSession().setAttribute("update", menu);
				break;
			}
		}
		System.out.println("id="+id);
		response.sendRedirect("/Ordering/jsp/restCustom/RestCustomUpdateMenu.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("id="+id);
		response.sendRedirect("/Ordering/jsp/restCustom/RestCustomUpdateMenu.jsp");
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
