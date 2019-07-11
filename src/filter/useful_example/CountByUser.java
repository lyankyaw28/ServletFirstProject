package filter.useful_example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CountByUser implements Filter {
	static int count = 0;
	public void init(FilterConfig arg0) throws ServletException {}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = res.getWriter();
		chain.doFilter(req, res);
		out.print("<br/>Total visitors " + (++count));
		out.close();
	}
	public void destroy() {}
}
