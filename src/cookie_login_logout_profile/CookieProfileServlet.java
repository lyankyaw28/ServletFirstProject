package cookie_login_logout_profile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CookieProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("cookie_login_logout_profile/link.html").include(request, response);

		Cookie ck[] = request.getCookies();
		if (ck != null) {
			String name = ck[0].getValue();
			if (!name.equals("") || name != null) {
				out.print("<b>Welcome to Profile</b>");
				out.print("<br>Welcome, " + name);
			}
		} else {
			out.print("Please login first");
			request.getRequestDispatcher("cookie_login_logout_profile/login.html").include(request, response);
		}
		out.close();
	}
}
