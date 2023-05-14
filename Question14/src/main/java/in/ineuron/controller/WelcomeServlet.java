package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*14. Create a Java servlet that reads the name of the user from a form and displays a
welcome message on the web page. The servlet should use the GET method to read
the input data from the user.
*/

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("userName");
		System.out.println(name);
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>welcome page</title></head>");
		out.println("<body bgcolor='pink'>");
		out.println("<center>");
		out.println("<form method='get' action='welcome'>");
		out.println("<input type='text' name='userName'   />");
		out.println("<tr><td></td><td><input type='submit' /></td></tr>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	

}
