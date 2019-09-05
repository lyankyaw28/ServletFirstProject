package attribute;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AttributeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			ServletContext context = getServletContext();
			context.setAttribute("company", "IBM");
			out.println("Welcome to first servlet");
			out.println("<a href='attributeServlet2'>visit</a>");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}