package development.wirte_data_to_pdf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javafx.scene.shape.MoveTo;

public class ServletPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "inline; filename='javatpoint.pdf'");
		PDF pdf = new PDF(out);
		Page p1 = new Page(p);
		p1.add(new MoveTo(p, 200, 700));
		p1.add(new Text(p, "www.javatpoint.com"));
		p1.add(new Text(p, "by Sonoo Jaiswal"));

		p.add(p1);
		p.setAuthor("Ian F. Darwin");

		p.writePDF();
	}
}
