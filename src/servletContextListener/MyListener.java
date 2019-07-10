package servletContextListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServlet;

public class MyListener extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void contextInitialized(ServletContextEvent arg0) {  
		try{  
		Class.forName("oracle.jdbc.driver.OracleDriver");  
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
		          
		String query="create table emp32(id number(10),name varchar2(40))";  
		PreparedStatement ps=con.prepareStatement(query);  
		ps.executeUpdate();  
		          
		System.out.println(query);  
		  
		}catch(Exception e){e.printStackTrace();}  
		}

	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("project undeployed");

	}
}
