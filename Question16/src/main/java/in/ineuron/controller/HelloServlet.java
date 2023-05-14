package in.ineuron.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Check if the user's name is already stored in the session
        String name = (String) session.getAttribute("name");

        // If the name is not set, display a form to enter the name
        if (name == null) {
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Welcome!</h1>");
            response.getWriter().println("<form method=\"post\">");
            response.getWriter().println("<label for=\"name\">Enter your name:</label>");
            response.getWriter().println("<input type=\"text\" id=\"name\" name=\"name\" required>");
            response.getWriter().println("<input type=\"submit\" value=\"Submit\">");
            response.getWriter().println("</form>");
            response.getWriter().println("</body></html>");
        } else {
            // If the name is already set, display a greeting with the name
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Hello, " + name + "!</h1>");
            response.getWriter().println("</body></html>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the submitted name from the form
        String name = request.getParameter("name");

        HttpSession session = request.getSession();
        // Store the name in the session
        session.setAttribute("name", name);

        // Redirect the user back to the main page
        response.sendRedirect(request.getContextPath() + "/hello");
    }
}
