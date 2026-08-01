import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/v1/user")
public class DayThirtyJsonApiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Set Response Header to JSON format
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        // 2. Set HTTP Status Code (200 OK)
        response.setStatus(HttpServletResponse.SC_OK);

        // 3. Constructing a JSON String (Simulating serialized object data)
        String jsonResponse = "{\n" +
                "  \"status\": \"success\",\n" +
                "  \"milestone\": \"Day 30/100\",\n" +
                "  \"user\": {\n" +
                "    \"id\": 101,\n" +
                "    \"name\": \"Rahul\",\n" +
                "    \"role\": \"Full Stack Developer\"\n" +
                "  }\n" +
                "}";

        // 4. Writing JSON response back to the client
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
}