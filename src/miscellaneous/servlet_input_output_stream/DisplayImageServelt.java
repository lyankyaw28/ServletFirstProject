package miscellaneous.servlet_input_output_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayImageServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("image/jpeg");
		ServletOutputStream out;
		out = response.getOutputStream();
		ServletContext context = getServletContext();
		String fullPath = context.getRealPath("/miscellaneous/servlet_input_output_stream/java.jpg");
		System.out.println(fullPath);
		FileInputStream fin = new FileInputStream(
				context.getRealPath("/miscellaneous/servlet_input_output_stream/java.jpg"));

		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch = 0;

		while ((ch = bin.read()) != -1) {
			bout.write(ch);
		}

		bin.close();
		fin.close();
		bout.close();
		out.close();
	}
}
