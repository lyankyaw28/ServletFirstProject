package event_and_listener.servlet_context_event_listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextMyListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent event) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/servlet?" + "user=root&password=root");
			
			String query = "CREATE TABLE `servlet`.`emp32` (`id` INT NOT NULL,`name` VARCHAR(45) NULL , PRIMARY KEY (`id`))";
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeUpdate();
			
			String query1 = "INSERT INTO `servlet`.`emp32` (`id`, `name`) VALUES ('1', 'Kyaw Kyaw')";
			ps = con.prepareStatement(query1);
			ps.executeUpdate();
			
			String query2 = "INSERT INTO `servlet`.`emp32` (`id`, `name`) VALUES ('2', 'Lyan Kyaw')";
			ps = con.prepareStatement(query2);
			ps.executeUpdate();

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
