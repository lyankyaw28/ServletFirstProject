package http_session_event_listener;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionLoginLogoutEventServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n = request.getParameter("username");
		out.print("Welcome " + n);
		HttpSession session = request.getSession();
		session.setAttribute("uname", n);
		// retrieving data from ServletContext object
		ServletContext ctx = getServletContext();
		int t = (Integer) ctx.getAttribute("totalusers");
		int c = (Integer) ctx.getAttribute("currentusers");
		out.print("<br>total users= " + t);
		out.print("<br>current users= " + c);
		out.print("<br><a href='httpSessionLoginLogoutEventServlet2'>logout</a>");
		out.close();
	}

}
