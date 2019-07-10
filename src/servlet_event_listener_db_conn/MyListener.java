package servlet_event_listener_db_conn;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServlet;

public class MyListener extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void contextInitialized(ServletContextEvent event) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			// storing connection object as an attribute in ServletContext
			ServletContext ctx = event.getServletContext();
			ctx.setAttribute("mycon", con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}
