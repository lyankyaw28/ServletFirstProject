package servlet_context.all_init_param;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextAllInitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();

		ServletContext context = getServletContext();
		Enumeration<String> e = context.getInitParameterNames();

		String str = "";
		while (e.hasMoreElements()) {
			str = e.nextElement();
			out.print("<br>Name: " + str);
			out.print(" value: " + context.getInitParameter(str));
		}
	}
}
