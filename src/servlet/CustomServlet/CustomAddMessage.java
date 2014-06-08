package servlet.CustomServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Custom;
import bean.Rest_message;
import bean.Restaurant;
import dao.impl.Rest_messageDaoImpl;

public class CustomAddMessage extends HttpServlet {

	public CustomAddMessage() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = request.getParameter("area");
		int rest_id =((Restaurant) request.getSession().getAttribute("restMessage")).getRest_ID();
		int custom_id =((Custom)request.getSession().getAttribute("custom")).getCustom_ID();
		Rest_message me = new Rest_message();
		me.setCustom_ID(custom_id);
		me.setMessage(message);
		me.setRest_ID(rest_id);
		Rest_messageDaoImpl dao =new Rest_messageDaoImpl();
		dao.addRest_message(me);
		List<Rest_message> all = (List<Rest_message>) request.getSession().getAttribute("mess");
		all.add(me);
		response.sendRedirect("/Ordering/jsp/restCustom/RestaurantMsgShow.jsp");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
