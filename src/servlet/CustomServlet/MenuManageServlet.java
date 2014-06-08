package servlet.CustomServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import bean.Order_list;
import dao.impl.Order_listDaoImpl;

public class MenuManageServlet extends HttpServlet {

	public MenuManageServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Order_listDaoImpl dao = new Order_listDaoImpl();
		List<Order_list> menu = dao.getCustom_Order_lists(0);
		response.setContentType("text/html");	
		PrintWriter out = response.getWriter();
		JSONArray jsons = JSONArray.fromObject(menu);
		out.println(jsons);
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
