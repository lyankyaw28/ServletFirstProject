package session_tracking.url_rewriting;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstUrlRewritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String n = request.getParameter("userName");
			out.print("Welcome " + n);
			out.print("<a href='secondUrlRewritingServlet?uname=" + n + "'>visit</a>");
			out.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
