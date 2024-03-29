package servlet_collaboration.request_dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String p = request.getParameter("userPass");

		if (p.equals("servlet")) {
			RequestDispatcher rd = request.getRequestDispatcher("welcomeServlet");

			rd.forward(request, response);
		} else {
			out.print("Sorry UserName or Password Error!");
			RequestDispatcher rd = request.getRequestDispatcher("/servlet_collaboration/request_dispatcher/login.html");
			rd.include(request, response);
		}
	}
}
