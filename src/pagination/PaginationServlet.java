package pagination;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PaginationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String spageid = request.getParameter("page");
		int pageid = Integer.parseInt(spageid);
		int total = 5;
		if (pageid == 1) {
		} else {
			pageid = pageid - 1;
			pageid = pageid * total + 1;
		}
		List<PaginationEntity> list = PaginationDao.getRecords(pageid, total);
		out.print("<h1>Page No: " + spageid + "</h1>");
		out.print("<table border='1' cellpadding='4' width='60%'>");
		out.print("<tr><th>Id</th><th>Name</th><th>Salary</th>");
		for (PaginationEntity e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getSalary() + "</td></tr>");
		}
		out.print("</table>");
		out.print("<a href='paginationServlet?page=1'>1</a> ");
		out.print("<a href='paginationServlet?page=2'>2</a> ");
		out.print("<a href='paginationServlet?page=3'>3</a> ");
		out.close();
	}
}
