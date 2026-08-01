import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Mapping this Servlet to handle requests directed at /api/status
@WebServlet("/api/status")
public class DayTwentyNineServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("🚀 [Servlet Lifecycle] Initializing DayTwentyNineServlet...");
    }

    // Handling GET Requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Day 29: Java Web Server Active!</h2>");
        out.println("<p>Status: HTTP 200 OK | Handling GET Request cleanly.</p>");
        out.println("</body></html>");
    }

    // Handling POST Requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        response.setContentType("text/plain");
        
        response.getWriter().println("Received POST request for user: " + username);
    }

    @Override
    public void destroy() {
        System.out.println(" [Servlet Lifecycle] Destroying Servlet and releasing resources...");
    }
}