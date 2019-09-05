package servlet_context.init_param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextInitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		// creating ServletContext object
		ServletContext context = getServletContext();

		// Getting the value of the initialization parameter and printing it
		String driverName = context.getInitParameter("dname");
		pw.println("driver name is=" + driverName);

		pw.close();

	}
}
