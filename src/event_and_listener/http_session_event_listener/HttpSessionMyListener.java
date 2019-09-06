package event_and_listener.http_session_event_listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionMyListener implements HttpSessionListener {
	ServletContext servletContext = null;
	static int total = 0, current = 0;

	public void sessionCreated(HttpSessionEvent e) {
		total++;
		current++;
		servletContext = e.getSession().getServletContext();
		servletContext.setAttribute("totalusers", total);
		servletContext.setAttribute("currentusers", current);
	}

	public void sessionDestroyed(HttpSessionEvent e) {
		current--;
		servletContext.setAttribute("currentusers", current);
	}

}
