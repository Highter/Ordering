package servlet.CustomServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import bean.Rest_message;
import dao.impl.Rest_messageDaoImpl;

public class MsgManageServlet extends HttpServlet {

	
	public MsgManageServlet() {
		super();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Rest_messageDaoImpl dao = new Rest_messageDaoImpl();
		List<Rest_message> msg = dao.getCustom_Rest_messages(1);//自己插入数据测试，数据库中可能还没有数据，用户ID为1
		
		response.setContentType("text/html");	
		PrintWriter out = response.getWriter();
		
		JSONArray jsons = JSONArray.fromObject(msg);
		out.println(jsons);
		out.flush();
		out.close();
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
