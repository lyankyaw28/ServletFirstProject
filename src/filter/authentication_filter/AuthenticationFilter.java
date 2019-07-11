package filter.authentication_filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AuthenticationFilter implements Filter {
	public void init(FilterConfig arg0) throws ServletException {}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = resp.getWriter();
		String password = req.getParameter("password");
		if (password.equals("admin")) {
			chain.doFilter(req, resp);// sends request to next resource
		} else {
			out.print("username or password error!" );
			//ဒီ code က သူ႕ website မွာက်န္ခဲ့တယ္ အဲ့တာ မပါရင္ html ကို browser က ui အေနနဲ႔ မၿပႏိုင္ေတာ့ဘူး
			resp.setContentType("text/html");
			req.getRequestDispatcher("filter/authentication_filter/index.html").include(req, resp);
		}
	}

	public void destroy() {}
}
