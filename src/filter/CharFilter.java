package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharFilter implements Filter {

	@Override
	public void init(FilterConfig filterconfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletrequest,
			ServletResponse servletresponse, FilterChain filterchain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		servletrequest.setCharacterEncoding("UTF-8");
		servletresponse.setCharacterEncoding("UTF-8");
		filterchain.doFilter(servletrequest, servletresponse);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
