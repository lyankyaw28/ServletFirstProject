package request_dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String p = request.getParameter("userPass");
		//password မွန္ခဲ့ရင္ welcomeServlet ဆိုတဲ့ servlet ကို လုပ္စရာလုပ္စရာရွိတာကို လုပ္ဖို႔ခိုင္းလိုက္ၿပီး respone ကို သူ႕ဆီၿပန္ယူလာခိုင္းလိုက္တာ
		// include မွာ page ကို ထည့္ေပးလိုက္တာက်ေတာ့ login servlet response ၿပန္ရင္ အဲ့ page ကို ထည့္ေပးလိုက္တဲ့ သေဘာပဲ
		if (p.equals("servlet")) {
			RequestDispatcher rd = request.getRequestDispatcher("welcomeServlet");
			
			// getRequestDispatcher method ရဲ႕ parameter က servlet name ၿဖစ္လို႔ရသလို page name လည္းၿဖစ္လို႔ရတယ္
			rd.forward(request, response);
		} else {
			out.print("Sorry UserName or Password Error!");
			RequestDispatcher rd = request.getRequestDispatcher("/request_dispatcher/login.html");
			rd.include(request, response);
		}
	}
}
