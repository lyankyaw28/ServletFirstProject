package url_rewriting;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlRewritingServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String n = request.getParameter("userName");
			out.print("Welcome " + n);

			// appending the username in the query string
			out.print("<a href='urlRewritingServlet2?uname=" + n + "'>visit</a>");
			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
